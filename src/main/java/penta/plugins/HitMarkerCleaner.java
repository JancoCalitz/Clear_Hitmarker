package penta.plugins;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EnumSet;
import java.util.Set;

public class HitMarkerCleaner extends JavaPlugin implements CommandExecutor {

    private final Set<EntityType> cleanableTypes = EnumSet.of(
            EntityType.ARMOR_STAND,
            EntityType.AREA_EFFECT_CLOUD,
            EntityType.ARROW,
            EntityType.TRIDENT,
            EntityType.MARKER,
            EntityType.TEXT_DISPLAY,
            EntityType.ITEM_DISPLAY,
            EntityType.BLOCK_DISPLAY
    );

    @Override
    public void onEnable() {
        getCommand("cleanhitmarkers").setExecutor(this);
        getLogger().info("HitMarkerCleaner has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("HitMarkerCleaner has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        int removed = 0;

        for (Entity entity : player.getNearbyEntities(10, 10, 10)) {

            EntityType type = entity.getType();

            // Only consider types from our cleanable list
            if (cleanableTypes.contains(type)) {

                // Additional checks for known types (optional strictness)
                if (entity instanceof ArmorStand armorStand) {
                    if (!armorStand.isVisible() && armorStand.getCustomName() == null) {
                        entity.remove();
                        removed++;
                        continue;
                    }
                } else if (entity instanceof Arrow arrow) {
                    if (!arrow.isOnGround() || arrow.isInBlock()) {
                        entity.remove();
                        removed++;
                        continue;
                    }
                } else if (entity instanceof Trident trident) {
                    if (!trident.isOnGround() || trident.isInBlock()) {
                        entity.remove();
                        removed++;
                        continue;
                    }
                } else {
                    // Generic fallback removal for other visual ghost types
                    entity.remove();
                    removed++;
                }
            }
        }

        player.sendMessage(ChatColor.GREEN + "Removed " + removed + " stuck hit marker(s).");
        return true;
    }
}

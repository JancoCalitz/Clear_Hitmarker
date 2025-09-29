# Clear_HitMarker

Clear_HitMarker (HitMarkerCleaner) is a lightweight utility plugin for Paper/Spigot servers.  
It provides players with a simple command to remove unwanted “hit marker” entities that often clutter arenas and builds during gameplay.

## Overview
Over time, entities such as invisible armour stands, stuck arrows, tridents, or leftover display markers can accumulate around players, creating visual noise or even server lag.  
This plugin introduces the `/cleanhitmarkers` command, allowing players to clear these nearby entities in a fair and balanced way.  

Within a 10-block radius around the player, the plugin detects and removes specific entity types that are commonly left behind after combat or special effects.

## Features
- `/cleanhitmarkers` command available to all players.  
- Removes the following nearby entity types:  
  - Invisible `ArmorStand` (without names)  
  - `Arrow` stuck in blocks  
  - `Trident` stuck in blocks  
  - `AreaEffectCloud`, `Marker`, `TextDisplay`, `ItemDisplay`, `BlockDisplay`  
- Displays a green confirmation message showing how many entities were cleared.  
- Protects against accidental removal of visible or named armour stands.  
- Lightweight and efficient — designed for quick cleanups during gameplay.

## Technical
- **Minecraft:** Spigot/Paper 1.21.1  
- **Language:** Java 21  
- **Build Tool:** Maven  

## Installation
1. Build with Maven or use the precompiled JAR.  
2. Place the JAR file in your server’s `plugins/` folder.  
3. Restart or reload the server.  
4. Players can now use `/cleanhitmarkers` in-game.  

---

## Author
Developed by **Penta** as part of ongoing Minecraft plugin development projects.

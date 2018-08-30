package com.nemosw.spigot.sample;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;

public class SampleListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        player.sendMessage("Hello PlayerJoinEvent!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (event.getHand() != EquipmentSlot.HAND)
        {
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("You interacted with action = §b").append(event.getAction()).append(" item §6").append(event.getItem());
        event.getPlayer().sendMessage(builder.toString());
    }
}

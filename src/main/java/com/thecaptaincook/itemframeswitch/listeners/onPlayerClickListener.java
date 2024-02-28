package com.thecaptaincook.itemframeswitch.listeners;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerClickListener implements Listener {

    @EventHandler
    public void onPlayerItemFrameClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof ItemFrame) {
            Player player = event.getPlayer();
            player.sendMessage("You clicked an item frame!");
            /* if item in the itemframe is a compass, switch it to a clock */
            if (((ItemFrame) event.getRightClicked()).getItem().getType().equals(Material.COMPASS)) {
                player.sendMessage("You clicked a compass in the itemFrame!");
                ((ItemFrame) event.getRightClicked()).setItem(new ItemStack(Material.CLOCK));
            }else {
                player.sendMessage("You clicked something else in the itemFrame!");
            }
        }
    }
}

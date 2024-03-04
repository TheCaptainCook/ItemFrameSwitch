package com.thecaptaincook.itemframeswitch.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class washGlowFrame implements Listener {


    @EventHandler
    public void onPlayerWashEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block washCauldronBlock = event.getClickedBlock();
        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) && washCauldronBlock.getBlockData().getMaterial().equals(Material.WATER_CAULDRON) && player.getInventory().getItemInMainHand().getType().equals(Material.GLOW_ITEM_FRAME)) {
            BlockData washCauldronData = washCauldronBlock.getBlockData();
            int level = ((Levelled) washCauldronData).getLevel();
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.getInventory().addItem(new ItemStack(Material.ITEM_FRAME, 1));
                //player.sendMessage("Blockdata: " + washCauldronData.getMaterial() + " Level: " + level);
                if (level > 1) {
                    ((Levelled) washCauldronData).setLevel(level - 1);
                    washCauldronBlock.setBlockData(washCauldronData);
                    //rolling of chance to get the glow frame back
                    if (Math.random() < 0.5) {
                        player.getInventory().addItem(new ItemStack(Material.GLOW_INK_SAC, 1));
                    }
                }
                else {
                    washCauldronBlock.setType(Material.CAULDRON);
                    player.sendMessage("Cauldron is empty");
                }
        }
    }
}
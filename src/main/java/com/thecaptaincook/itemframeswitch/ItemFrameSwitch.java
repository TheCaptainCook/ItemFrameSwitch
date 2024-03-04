package com.thecaptaincook.itemframeswitch;

import com.thecaptaincook.itemframeswitch.listeners.washGlowFrame;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemFrameSwitch extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new washGlowFrame(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

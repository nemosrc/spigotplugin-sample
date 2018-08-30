package com.nemosw.spigot.sample;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SamplePlugin extends JavaPlugin
{
    private Logger logger;

    @Override
    public void onEnable()
    {
        logger = getLogger();
        logger.info("Hello JavaPlugin!");

        setupCommand();
        setupListener();

        logger.info(NMSBridge.INSTANCE.getNMSBlock("dirt").getClass().toString());
    }

    private void setupCommand()
    {
        SampleCommand sampleCommand = new SampleCommand();

        PluginCommand command = getCommand("sample");
        command.setExecutor(sampleCommand);
        command.setTabCompleter(sampleCommand);

        logger.info("Command setup complete");
    }

    private void setupListener()
    {
        getServer().getPluginManager().registerEvents(new SampleListener(), this);
        logger.info("Listener setup complete");
    }

    @Override
    public void onDisable()
    {
        logger.info("Bye bye");
    }
}

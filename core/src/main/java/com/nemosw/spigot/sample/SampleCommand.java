package com.nemosw.spigot.sample;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public class SampleCommand implements TabExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        sender.sendMessage("Hello Command! " + StringUtils.join(args, ' '));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args)
    {
        return Arrays.asList("Hello", "TabExecutor");
    }
}

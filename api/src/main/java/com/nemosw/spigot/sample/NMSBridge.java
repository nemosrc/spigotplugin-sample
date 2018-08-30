package com.nemosw.spigot.sample;

import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface NMSBridge
{
    NMSBridge INSTANCE = loadLibrary();

    static NMSBridge loadLibrary()
    {
        try
        {
            return (NMSBridge) Class.forName(NMSBridge.class.getPackage().getName() + "." + getBukkitVersion() + ".NMS" + NMSBridge.class.getSimpleName()).newInstance();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        throw new AssertionError();
    }

    static String getBukkitVersion()
    {
        Matcher matcher = Pattern.compile("v\\d+_\\d+_R\\d+").matcher(Bukkit.getServer().getClass().getPackage().getName());

        return matcher.find() ? matcher.group() : null;
    }

    Object getNMSBlock(String name);
}

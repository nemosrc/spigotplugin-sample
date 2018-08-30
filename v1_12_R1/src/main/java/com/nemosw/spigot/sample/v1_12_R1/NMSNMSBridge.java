package com.nemosw.spigot.sample.v1_12_R1;

import com.nemosw.spigot.sample.NMSBridge;
import net.minecraft.server.v1_12_R1.Block;

public class NMSNMSBridge implements NMSBridge
{
    @Override
    public Object getNMSBlock(String name)
    {
        return Block.getByName(name);
    }
}

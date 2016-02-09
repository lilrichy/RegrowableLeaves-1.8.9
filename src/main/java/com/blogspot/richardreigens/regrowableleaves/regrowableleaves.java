package com.blogspot.richardreigens.regrowableleaves;

import com.blogspot.richardreigens.regrowableleaves.blocks.BlockLeafAir;
import com.blogspot.richardreigens.regrowableleaves.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class regrowableleaves {
    @Mod.Instance(Reference.MOD_ID)
    public static regrowableleaves instance;

    public static final BlockLeafAir blockLeafAir = new BlockLeafAir();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        GameRegistry.registerBlock(blockLeafAir, "BlockLeafAir");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new com.blogspot.richardreigens.regrowableleaves.EventHandler());
    }
}

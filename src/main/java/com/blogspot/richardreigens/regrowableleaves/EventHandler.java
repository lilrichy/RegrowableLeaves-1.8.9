package com.blogspot.richardreigens.regrowableleaves;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by LiLRichy on 12/26/2015.
 */
public class EventHandler {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void breakEvent(BlockEvent.BreakEvent e) {
        BlockPos pos = e.pos;
        World world = e.world;
        IBlockState state = e.state;
        EntityPlayer player = e.getPlayer();
        Block block = state.getBlock();

        if (player.getCurrentEquippedItem() == null || player.getCurrentEquippedItem().getItem() != Items.shears) {
            if (block == Blocks.leaves) {
                block.harvestBlock(world, player, pos, state, null);
                world.setBlockState(pos, regrowableleaves.blockLeafAir.getStateFromMeta(state.getBlock().getMetaFromState(state) % 4));
                e.setCanceled(true);

            } else if (block == Blocks.leaves2) {
                block.harvestBlock(world, player, pos, state, null);
                world.setBlockState(pos, regrowableleaves.blockLeafAir.getStateFromMeta(state.getBlock().getMetaFromState(state) % 4 + 5));
                e.setCanceled(true);
            }
        }
    }
}
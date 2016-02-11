package com.blogspot.richardreigens.regrowableleaves.blocks;


import com.blogspot.richardreigens.regrowableleaves.ConfigurationHandler;
import net.minecraft.block.BlockAir;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by LiLRichy on 12/26/2015.
 */
public class BlockLeafAir extends BlockAir {
    final int META_OFFSET = 5;
    public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockProperties.EnumType.class);

    public BlockLeafAir() {
        super();
        this.setTickRandomly(true);
        this.setUnlocalizedName("LeafAir");
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, TYPE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, BlockProperties.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockProperties.EnumType) state.getValue(TYPE)).getID();
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {

            int metaToSet = state.getBlock().getMetaFromState(state);

            if (random.nextInt(10) > ConfigurationHandler.leafRegrowthRate && world.getLight(pos) >= ConfigurationHandler.lightRequiredToGrow) {
                if (metaToSet >= META_OFFSET)
                    world.setBlockState(pos, Blocks.leaves2.getStateFromMeta(state.getBlock().getMetaFromState(state) - META_OFFSET + 8));
                else
                    world.setBlockState(pos, Blocks.leaves.getStateFromMeta(state.getBlock().getMetaFromState(state) + 8));
            }
        }
    }
}


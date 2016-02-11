package com.blogspot.richardreigens.regrowableleaves.blocks;

import net.minecraft.util.IStringSerializable;

/**
 * Created by LiLRichy on 2/11/2016.
 */
public class BlockProperties {

    public enum EnumType implements IStringSerializable {
        OAK(0, "oak"),
        SPRUCE(1, "spruce"),
        BIRCH(2, "birch"),
        JUNGLE(3, "jungle"),
        ACACIA(4, "acacia"),
        DARK_OAK(5, "dark_oak");

        private static final BlockProperties.EnumType[] META_LOOKUP = new BlockProperties.EnumType[values().length];
        private int ID;
        private String name;


        private EnumType(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getID() {
            return ID;
        }

        @Override
        public String toString() {
            return getName();
        }
        public static BlockProperties.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
        static
        {
            for (BlockProperties.EnumType blockplanks$enumtype : values())
            {
                META_LOOKUP[blockplanks$enumtype.getID()] = blockplanks$enumtype;
            }
        }
    }
}

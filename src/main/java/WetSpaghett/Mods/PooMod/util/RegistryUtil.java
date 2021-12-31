package WetSpaghett.Mods.PooMod.util;

import WetSpaghett.Mods.PooMod.PooMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RegistryUtil {

    public static Item setItemName(final Item item, final String name) {
        item.setRegistryName(PooMod.MODID, name).setUnlocalizedName(PooMod.MODID + "." + name);
        return item;
    }

    public static Block setBlockName(final Block block, final String name) {
        block.setRegistryName(PooMod.MODID, name).setUnlocalizedName(PooMod.MODID + "." + name);
        return block;
    }

}
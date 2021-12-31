package WetSpaghett.Mods.PooMod;

import net.minecraft.item.*;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;


@ObjectHolder(PooMod.MODID)
public class Items {
    public static Item poo = null;
    public static Item pee = null;
    public static ItemSword poosword = null;
    public static Item poopickaxe = null;
    public static Item pooaxe = null;
    public static ItemSpade pooshovel = null;
    public static ItemHoe poohoe = null;
    public static Item.ToolMaterial POO = EnumHelper.addToolMaterial("PooMod.POO", 3, 512, 10f, 4f, 32);
}

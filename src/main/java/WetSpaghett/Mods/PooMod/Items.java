package WetSpaghett.Mods.PooMod;

import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(PooMod.MODID)
public class Items {
    @ObjectHolder("poopickaxe")
    public static ItemPickaxe poopickaxe;

    @ObjectHolder("pooaxe")
    public static ItemAxe pooaxe;

    @ObjectHolder("poohoe")
    public static ItemHoe poohoe;

    @ObjectHolder("poo")
    public static Item poo;

    @ObjectHolder("pee")
    public static Item pee;

    @ObjectHolder("pooshovel")
    public static ItemSpade pooshovel;

    @ObjectHolder("poosword")
    public static ItemSword poosword;

    @ObjectHolder("poobow")
    public static ItemBow poobow;

    @ObjectHolder("pooshield")
    public static ItemShield pooshield = null;
}

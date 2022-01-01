package WetSpaghett.Mods.PooMod;

import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

// I don't know what ObjectHolders do, but I need them or the game crashes with a nullpointerexception.
@ObjectHolder(PooMod.MODID)
public class Items {
    @ObjectHolder("poopickaxe")
    public static ItemPickaxe POOPICKAXE = null;
    @ObjectHolder("pooaxe")
    public static ItemAxe POOAXE = null;
    @ObjectHolder("poohoe")
    public static ItemHoe POOHOE = null;
    @ObjectHolder("poo")
    public static Item POO = null;
    @ObjectHolder("pee")
    public static Item PEE = null;
    @ObjectHolder("pooshovel")
    public static ItemSpade POOSHOVEL = null;
    @ObjectHolder("poosword")
    public static ItemSword POOSWORD = null;
    @ObjectHolder("poobow")
    public static ItemBow POOBOW = null;
    @ObjectHolder("pooshield")
    public static ItemShield POOSHIELD = null;
}

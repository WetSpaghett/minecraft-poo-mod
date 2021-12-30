package WetSpaghett.Mods.PooMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;


@ObjectHolder(PooMod.MODID)
public class Items {
    public static final Item poo = null;
    public static final Item pee = null;
    public static final ItemSword poosword = null;
    public static Item.ToolMaterial POO = EnumHelper.addToolMaterial("POO", 3, 512, 10f, 4f, 32);
}

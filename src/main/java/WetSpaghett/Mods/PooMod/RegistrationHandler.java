package WetSpaghett.Mods.PooMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PooMod.MODID)
public class RegistrationHandler {
    @SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		final Item[] items = {
				new ItemFood(8, 10f, true).setAlwaysEdible().setRegistryName(PooMod.MODID, "poo").setUnlocalizedName(PooMod.MODID + "." + "poo").setCreativeTab(CreativeTabs.FOOD),
				new ItemFood(4, 10f, true).setAlwaysEdible().setRegistryName(PooMod.MODID, "pee").setUnlocalizedName(PooMod.MODID + "." + "pee").setCreativeTab(CreativeTabs.FOOD),
				new ItemSword(Items.POO).setRegistryName(PooMod.MODID, "poosword").setUnlocalizedName(PooMod.MODID + "." + "poosword").setCreativeTab(CreativeTabs.COMBAT)
		};
		event.getRegistry().registerAll(items);
	}
}


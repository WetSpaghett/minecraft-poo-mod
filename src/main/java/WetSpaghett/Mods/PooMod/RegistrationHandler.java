package WetSpaghett.Mods.PooMod;

import WetSpaghett.Mods.PooMod.util.RegistryUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PooMod.MODID)
public class RegistrationHandler {

    @SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {

		final Item[] items = {
				RegistryUtil.setItemName(new ItemFood(8, 10f, true), "poo").setCreativeTab(CreativeTabs.FOOD),
				RegistryUtil.setItemName(new ItemFood(4, 10f, true), "pee").setCreativeTab(CreativeTabs.FOOD),
				RegistryUtil.setItemName(new ItemSword(Items.POO), "poosword").setCreativeTab(CreativeTabs.COMBAT),
				RegistryUtil.setItemName(new ItemPickaxe(Items.POO), "poopickaxe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemAxe(Items.POO, 9f, 10f), "pooaxe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemSpade(Items.POO), "pooshovel").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemHoe(Items.POO), "poohoe").setCreativeTab(CreativeTabs.TOOLS),
		};
		event.getRegistry().registerAll(items);
	}
}


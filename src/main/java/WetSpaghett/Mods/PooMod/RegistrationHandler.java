package WetSpaghett.Mods.PooMod;

import WetSpaghett.Mods.PooMod.util.RegistryUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PooMod.MODID)
public class RegistrationHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
	public static void registerItems(Register<Item> event) {

		// Set registry names and other variables for all items
		final Item[] items = {
				RegistryUtil.setItemName(new ItemPickaxe(PooMod.POO), "poopickaxe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemAxe(PooMod.POO, 9f, 10f), "pooaxe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemHoe(PooMod.POO), "poohoe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemFood(8, 10f, true), "poo").setCreativeTab(CreativeTabs.FOOD),
				RegistryUtil.setItemName(new ItemFood(4, 10f, true), "pee").setCreativeTab(CreativeTabs.FOOD),
				RegistryUtil.setItemName(new ItemSpade(PooMod.POO), "pooshovel").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemSword(PooMod.POO), "poosword").setCreativeTab(CreativeTabs.COMBAT),
				RegistryUtil.setItemName(new ItemBow(), "poobow").setCreativeTab(CreativeTabs.COMBAT).setMaxDamage(512),
				RegistryUtil.setItemName(new ItemShield(), "pooshield").setCreativeTab(CreativeTabs.COMBAT).setMaxDamage(512)
		};
		event.getRegistry().registerAll(items);
	}
}

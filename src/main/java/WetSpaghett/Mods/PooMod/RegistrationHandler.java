package WetSpaghett.Mods.PooMod;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PooMod.MODID)
public class RegistrationHandler {
    @SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		final Item[] items = {
				new Item().setRegistryName(PooMod.MODID, "poo").setUnlocalizedName(PooMod.MODID + "." + "poo").setCreativeTab(CreativeTabs.DECORATIONS),
				new Item().setRegistryName(PooMod.MODID, "pee").setUnlocalizedName(PooMod.MODID + "." + "pee").setCreativeTab(CreativeTabs.DECORATIONS)
		};
		event.getRegistry().registerAll(items);
	}
}


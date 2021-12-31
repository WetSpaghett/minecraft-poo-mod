package WetSpaghett.Mods.PooMod.Client;

import WetSpaghett.Mods.PooMod.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = WetSpaghett.Mods.PooMod.PooMod.MODID)
public class ModelRegistrationHandler {

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerModel(Items.poo, 0);
		registerModel(Items.pee, 0);
		registerModel(Items.poosword, 0);
		registerModel(Items.poopickaxe, 0);
		registerModel(Items.pooaxe, 0);
		registerModel(Items.pooshovel, 0);
		registerModel(Items.poohoe, 0);
	}
    private static void registerModel(Item item, int meta) {
		System.out.println("DONE");
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
		System.out.println("DONE");
	}
}

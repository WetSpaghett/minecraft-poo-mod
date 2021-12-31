package WetSpaghett.Mods.PooMod.Client;

import WetSpaghett.Mods.PooMod.PooMod;
import WetSpaghett.Mods.PooMod.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Objects;

@EventBusSubscriber(value = Side.CLIENT, modid = PooMod.MODID)
public class ModelRegistrationHandler {

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerModel(Items.POO);
		registerModel(Items.PEE);
		registerModel(Items.POOAXE);
		registerModel(Items.POOHOE);
		registerModel(Items.POOPICKAXE);
		registerModel(Items.POOSHOVEL);
		registerModel(Items.POOSWORD);

	}

	private static void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
	}

}

package WetSpaghett.Mods.PooMod.Client;

import WetSpaghett.Mods.PooMod.PooMod;
import WetSpaghett.Mods.PooMod.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.*;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

@EventBusSubscriber(value = Side.CLIENT, modid = PooMod.MODID)
public class ModelRegistrationHandler {

	// Register models for all items
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerModel(Items.POOPICKAXE, 0);
		registerModel(Items.POOAXE, 0);
		registerModel(Items.POOHOE, 0);
		registerModel(Items.POO, 0);
		registerModel(Items.PEE, 0);
		registerModel(Items.POOSHOVEL, 0);
		registerModel(Items.POOSWORD, 0);
		registerModel(Items.POOBOW, 0);
		registerModel(Items.POOSHIELD, 0);
	}

	private static void registerModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
	}

}

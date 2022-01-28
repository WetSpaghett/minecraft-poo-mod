package WetSpaghett.Mods.PooMod;

import WetSpaghett.Mods.PooMod.util.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.TConstruct;

@EventBusSubscriber(modid = PooMod.MODID)
public class RegistrationHandler {

	// Tinker's integration
	@SubscribeEvent
	@Optional.Method(modid = "tconstruct")
	public static void registerTinkersFluids(FluidRegistry.FluidRegisterEvent event) {
		TinkerFluids.pooFl.setUnlocalizedName(PooMod.MODID + "." + "poo").setColor(TinkerFluids.pooFl.getColor());
		FluidRegistry.registerFluid(TinkerFluids.pooFl);
	}

	@SubscribeEvent
	@Optional.Method(modid = "tconstruct")
	public static void registerBucket(RegistryEvent.Register<Item> event) {
		if (TConstruct.pulseManager.isPulseLoaded("TinkerSmeltery")) {
			FluidRegistry.addBucketForFluid(TinkerFluids.pooFl);
		}
	}

	// Native poomod registrations
	@SubscribeEvent
	public static void registerItems (RegistryEvent.Register<Item> event) {
		// Set registry names and other variables for items
		final Item[] items = {
				RegistryUtil.setItemName(new ItemPickaxe(PooMod.POOTOOL), "poopickaxe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemAxe(PooMod.POOTOOL, 9f, 10f), "pooaxe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemHoe(PooMod.POOTOOL), "poohoe").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemFood(8, 10f, true), "poo").setCreativeTab(CreativeTabs.FOOD),
				RegistryUtil.setItemName(new ItemFood(4, 10f, true), "pee").setCreativeTab(CreativeTabs.FOOD),
				RegistryUtil.setItemName(new ItemSpade(PooMod.POOTOOL), "pooshovel").setCreativeTab(CreativeTabs.TOOLS),
				RegistryUtil.setItemName(new ItemSword(PooMod.POOTOOL), "poosword").setCreativeTab(CreativeTabs.COMBAT),
				RegistryUtil.setItemName(new ItemBow(), "poobow").setCreativeTab(CreativeTabs.COMBAT).setMaxDamage(512),
				RegistryUtil.setItemName(new ItemShield(), "pooshield").setCreativeTab(CreativeTabs.COMBAT).setMaxDamage(512),
				RegistryUtil.setItemName(new ItemBlock(Blocks.pooblock), "pooblock").setCreativeTab(CreativeTabs.DECORATIONS)
		};
		event.getRegistry().registerAll(items);
	}

	@SubscribeEvent
	public static void registerBlocks (RegistryEvent.Register<Block> event) {
		// Set registry names and other variables for blocks.
		final Block[] blocks = {
				RegistryUtil.setBlockName(new Block(Material.CLAY), "pooblock")
		};
		event.getRegistry().registerAll(blocks);
	}
}

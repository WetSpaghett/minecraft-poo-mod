package WetSpaghett.Mods.PooMod;

import WetSpaghett.Mods.ETILib.TinkerFluid;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.tools.TinkerTraits;

import static WetSpaghett.Mods.ETILib.TinkerFluid.addIngotMeltingRecipe;
import static WetSpaghett.Mods.ETILib.TinkerMaterials.TinkerMaterial.*;
import static slimeknights.tconstruct.library.TinkerRegistry.*;

@Mod(
        modid = PooMod.MODID,
        name = PooMod.NAME,
        version = PooMod.VERSION,
        dependencies = "after:tconstruct@[1.12.2-2.13.0.183,)"
)
public class PooMod {
    public static final String MODID = "poomod";
    public static final String NAME = "Poo Mod";
    public static final String VERSION = "0.4.1";
    public static final Logger LOGGER = LogManager.getLogger(PooMod.MODID);
    public static Item.ToolMaterial POOTOOL = EnumHelper.addToolMaterial("PooMod.POO", 3, 512, 10f, 4f, 32);

    // Tinker's materials
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersPreInit(FMLPreInitializationEvent event) {
        TinkerFluids.poo = new TinkerFluid("poo", 6829056);
        addHeadStats(TinkerMaterials.poo, 512, 10f, 4f, 3);
        addHandleStats(TinkerMaterials.poo, 1f, -128);
        addBowMaterialStats(TinkerMaterials.poo, 2f, 3f, 4f);
        addArrowShaftStats(TinkerMaterials.poo, 2f, 2);
        registerMaterial(TinkerMaterials.poo);
    }
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersInit(FMLInitializationEvent event) {
    TinkerMaterials.poo.addItem("poo", 1, 144);
    TinkerMaterials.poo.setRepresentativeItem(Items.poo);
    TinkerMaterials.poo.setFluid(TinkerFluids.poo);
    TinkerMaterials.poo.addTrait(TinkerTraits.poisonous, "head");
    }
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersPostInit(FMLPostInitializationEvent event) {
        addIngotMeltingRecipe(Items.poo, TinkerFluids.poo, 100);
    }
    // Pre-initialization
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info(PooMod.NAME + " " + PooMod.VERSION + " pre-initialized");
    }
    // Initialization
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        OreDictionary.registerOre("poo", Items.poo);
        LOGGER.info(PooMod.NAME + " " + PooMod.VERSION + " initialized");
    }
}

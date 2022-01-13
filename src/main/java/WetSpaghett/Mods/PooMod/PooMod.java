package WetSpaghett.Mods.PooMod;

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

import static slimeknights.tconstruct.library.TinkerRegistry.*;

@Mod(
        modid = PooMod.MODID,
        name = PooMod.NAME,
        version = PooMod.VERSION,
        dependencies = "required-after:easychatlib@[v0.1.2,);after:tconstruct@[1.12.2-2.13.0.183,)"
)
public class PooMod {
    public static final String MODID = "poomod";
    public static final String NAME = "Poo Mod";
    public static final String VERSION = "0.4.0";
    public static final Logger LOGGER = LogManager.getLogger(PooMod.MODID);
    public static Item.ToolMaterial POOTOOL = EnumHelper.addToolMaterial("PooMod.POO", 3, 512, 10f, 4f, 32);

    // Tinker's materials
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersPreInit(FMLPreInitializationEvent event) {
        TinkerFluids.poo = new FluidMolten("poo", 6829056);
        TinkerRegistry.addMaterialStats(TinkerMaterials.poo, new HeadMaterialStats(512, 10f, 4f, 3), new HandleMaterialStats(2f, -128), new ExtraMaterialStats(64));
        TinkerRegistry.addMaterialStats(TinkerMaterials.poo, new BowMaterialStats(2f, 3f, 4f));
        TinkerRegistry.addMaterialStats(TinkerMaterials.poo, new ArrowShaftMaterialStats(2f, 2));
        addMaterial(TinkerMaterials.poo);
        integrate(TinkerMaterials.poo);
    }
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersInit(FMLInitializationEvent event) {
    TinkerMaterials.poo.addItem("poo", 1, 144);
    TinkerMaterials.poo.setRepresentativeItem(Items.poo);
    TinkerMaterials.poo.setFluid(TinkerFluids.poo);
    TinkerMaterials.poo.addTrait(TinkerTraits.poisonous, "head");
    TinkerMaterials.poo.setCastable(true);
    }
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersPostInit(FMLPostInitializationEvent event) {
        registerMelting(new MeltingRecipe(RecipeMatch.of(Items.poo, 144), TinkerFluids.poo, 100));
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

package WetSpaghett.Mods.PooMod;

import WetSpaghett.Mods.ETILib.CastingRecipe;
import WetSpaghett.Mods.ETILib.TinkerFluid;
import net.minecraft.block.material.Material;
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
import slimeknights.tconstruct.tools.TinkerTraits;

@Mod(
        modid = PooMod.MODID,
        name = PooMod.NAME,
        version = PooMod.VERSION,
        dependencies = "after:tconstruct@[1.12.2-2.13.0.183,)"
)
public class PooMod {
    public static final String MODID = "poomod";
    public static final String NAME = "Poo Mod";
    public static final String VERSION = "1.0.0";
    public static final Logger LOGGER = LogManager.getLogger(PooMod.MODID);
    public static Item.ToolMaterial POOTOOL = EnumHelper.addToolMaterial("PooMod.POO", 3, 512, 10f, 4f, 32);

    // Tinker's Pre-Init
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersPreInit(FMLPreInitializationEvent event) {
        TinkerFluids.poo = new TinkerFluid("poo", 6829056);
        TinkerFluids.pooFl = TinkerFluids.poo.getFluid();
        TinkerMaterials.pooMat.addHeadStats(512, 10f, 4f, 3);
        TinkerMaterials.pooMat.addHandleStats(1f, -128);
        TinkerMaterials.pooMat.addBowMaterialStats(0.4f, 3f, 4f);
        TinkerMaterials.pooMat.addArrowShaftStats(1f, 2);
        TinkerMaterials.pooMat.registerMaterial();
    }

    // Tinker's Init
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersInit(FMLInitializationEvent event) {
    TinkerMaterials.poo.addItem("ingotPoo");
    TinkerMaterials.poo.setRepresentativeItem(Items.poo);
    TinkerMaterials.poo.setFluid(TinkerFluids.pooFl);
    TinkerMaterials.poo.addTrait(TinkerTraits.poisonous, "head");
    }

    // Tinker's Post-Init
    @Mod.EventHandler
    @Optional.Method(modid = "tconstruct")
    public void tinkersPostInit(FMLPostInitializationEvent event) {
        TinkerFluids.poo.addIngotMeltingRecipe(Items.poo, TinkerFluids.pooFl, 100);
        CastingRecipe pooCastingRecipe = new CastingRecipe();
        pooCastingRecipe.addIngotCast(Items.poo, TinkerFluids.poo.getFluid());
        pooCastingRecipe.addBlockCast(Items.pooblock, TinkerFluids.poo.getFluid());
    }

    // Pre-Init
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info(PooMod.NAME + " " + PooMod.VERSION + " pre-initialized");
    }

    // Init
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotPoo", Items.poo);
        OreDictionary.registerOre("pooIngot", Items.poo);
        OreDictionary.registerOre("blockPoo", Items.pooblock);
        OreDictionary.registerOre("pooBlock", Items.pooblock);
        LOGGER.info(PooMod.NAME + " " + PooMod.VERSION + " initialized");
    }
}

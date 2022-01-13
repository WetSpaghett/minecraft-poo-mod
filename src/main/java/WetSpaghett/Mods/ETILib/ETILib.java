package WetSpaghett.Mods.ETILib;

import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = ETILib.MODID,
        name = ETILib.NAME,
        version = ETILib.VERSION,
        dependencies = "required-after:tconstruct@[1.12.2-2.13.0.183,)"
)
public class ETILib {
    public static final String MODID = "etilib";
    public static final String NAME = "Easy Tinker's Integration Library";
    public static final String VERSION = "1.0.0";

    /**
     * Materials can be defined statically in a Materials class like this: <br>
     * public static Material superDiamond = TinkerMaterial("super_diamond", 12345); <br>
     * Methods such as Material.addHeadStats() should be called from Pre-Initialization. <br>
     * Fluids should be defined in Pre-Initialization and registered in FluidRegistryEvent. <br>
     * Methods such as Material.addItem(), Material.addTrait(), Material.setMoltenFluid() etc. should be called from Initialization. <br>
     * Ore Dictionary entries should be created in Initialization. <br>
     * addMeltingRecipe() should be called from Post-Initialization. <br>
     * Many Tinker's Construct events are broken (as of time of writing), and result in either hangs or crashes when the event is used for its seemingly intended purpose. <br>
     * For example, in my experience, MeltingRegisterEvent caused an infinite loop during Post-Initialization when I used it to register melting recipes. <br>
     * Similarly, MaterialRegisterEvent always either caused a crash, or didn't register the material. <br>
     */
    public static final String GENERALSTUFF = "";
}

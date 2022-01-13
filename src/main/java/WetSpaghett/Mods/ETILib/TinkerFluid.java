package WetSpaghett.Mods.ETILib;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

import static slimeknights.tconstruct.library.TinkerRegistry.registerMelting;

public class TinkerFluid extends FluidMolten {

    /**
     * Uses default molten metal textures.
     */
    public TinkerFluid(String name, int colour) {
        super(name, colour);
    }

    /**
     * Uses custom fluid textures.
     */
    public TinkerFluid(String name, int colour, String pathToStill, String pathToFlowing) {
        super(name, colour, new ResourceLocation(pathToStill), new ResourceLocation(pathToFlowing));
    }

    /**
     * Should be called from Post-Initialization.
     */
    public static void addIngotMeltingRecipe(Item item, Fluid fl, int temperature) {
        addMeltingRecipe(item, fl, 144, temperature);
    }

    /**
     * Should be called from Post-Initialization.
     */
    public static void addMeltingRecipe(Item item, Fluid fl, int amount, int temperature) {
        registerMelting(new MeltingRecipe(RecipeMatch.of(item, amount), fl, temperature));
    }
}

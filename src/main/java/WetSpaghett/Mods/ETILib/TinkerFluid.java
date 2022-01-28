package WetSpaghett.Mods.ETILib;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

import static slimeknights.tconstruct.library.TinkerRegistry.registerMelting;

public class TinkerFluid {
    public Fluid fluid;

    /**
     * Creates a Tinker's Construct fluid. Uses default molten metal textures.
     * @param name The name of your fluid.
     * @param colour The colour of your fluid. This is a typical hex colour put through a hex to decimal converter.
     */
    public TinkerFluid(String name, int colour) {
        this.setFluid(new FluidMolten(name, colour));
    }

    /**
     * Creates a Tinker's Construct fluid. Uses custom fluid textures.
     * @param name The name of your fluid.
     * @param colour The colour of your fluid. This is a typical hex colour put through a hex to decimal converter.
     * @param pathToStill The path to the still texture of your fluid.
     * @param pathToFlowing The path to the flowing texture of your fluid.
     */
    public TinkerFluid(String name, int colour, String pathToStill, String pathToFlowing) {
        this.setFluid(new FluidMolten(name, colour, new ResourceLocation(pathToStill), new ResourceLocation(pathToFlowing)));
    }

    /**
     * Adds a melting recipe for ingots. Should be called from Post-Initialization.
     * @param item The Item that will be melted.
     * @param fluid The fluid output of the melting recipe.
     * @param temperature The melting temperature of the Item. Lower temperatures melt faster.
     */
    public void addIngotMeltingRecipe(Item item, Fluid fluid, int temperature) {
        addMeltingRecipe(item, fluid, 144, temperature);
    }

    /**
     * Adds a generic melting recipe. Should be called from Post-Initialization.
     * @param item The Item that will be melted.
     * @param fluid The fluid output of the melting recipe.
     * @param temperature The melting temperature of the Item. Lower temperatures melt faster.
     */
    public void addMeltingRecipe(Item item, Fluid fluid, int amount, int temperature) {
        registerMelting(new MeltingRecipe(RecipeMatch.of(item, amount), fluid, temperature));
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }

    public Fluid getFluid() {
        return this.fluid;
    }
}

package WetSpaghett.Mods.ETILib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import static slimeknights.tconstruct.library.TinkerRegistry.*;

public class CastingRecipe {
    public int ingotValue;
    public int ingotsInBlock;
    public int nuggetsInIngot;

    public CastingRecipe() {
        this.setIngotValue(144);
        this.setIngotsInBlock(9);
        this.setNuggetsInIngot(9);
    }

    /**
     * Constructor for casting recipes. This makes it easier to work with Tinker's Construct.
     * @param ingotValue The value in mB of each ingot. This is usually 144, but some mods may want to change this. Should be divisible by nuggetsInIngot.
     * @param ingotsInBlock The amount of ingots required to cast one block. This is usually 9, but for certain materials (such as seared stone) it's 4.
     * @param nuggetsInIngot The amount of nuggets required to cast one ingot. This is usually 9, but some mods may want to change this.
     */
    public CastingRecipe(int ingotValue, int ingotsInBlock, int nuggetsInIngot) {
        this.setIngotValue(ingotValue);
        this.setIngotsInBlock(ingotsInBlock);
        this.setNuggetsInIngot(nuggetsInIngot);
    }

    /**
     * Registers a casting recipe for ingots. Should be run in Post-Initialization.
     * @param output The Item that should be output.
     * @param fluid The fluid which is cast.
     */
    public void addIngotCast(Item output, Fluid fluid) {
        addTableCast(new ItemStack(output), TinkerSmeltery.castIngot, fluid, this.getIngotValue());
    }

    /**
     * Registers a casting recipe for nuggets. Should be run in Post-Initialization.
     * @param output The Item that should be output.
     * @param fluid The fluid which is cast.
     */
    public void addNuggetCast(Item output, Fluid fluid) {
        addTableCast(new ItemStack(output), TinkerSmeltery.castNugget, fluid, this.getIngotValue()/this.getNuggetsInIngot());
    }

    /**
     * Registers a generic casting table recipe. Should be run in Post-Initialization.
     * @param output The ItemStack that should be output.
     * @param cast The cast that should be used.
     * @param fluid The fluid which is cast.
     * @param amount The amount of fluid used.
     */
    public void addTableCast(ItemStack output, ItemStack cast, Fluid fluid, int amount) {
        registerTableCasting(output, cast, fluid, amount);
    }

    /**
     * Registers a casting recipe for blocks. Should be run in Post-Initialization.
     * @param output The Item that should be output.
     * @param fluid The fluid which is cast.
     */
    public void addBlockCast(Item output, Fluid fluid) {
        addBasinCast(new ItemStack(output), ItemStack.EMPTY, fluid, this.getIngotValue()*this.getIngotsInBlock());
    }

    /**
     * Registers a generic casting basin recipe.
     * @param output The ItemStack that should be output.
     * @param cast The cast that should be used.
     * @param fluid The fluid which is cast.
     * @param amount The amount of fluid used.
     */
    public void addBasinCast(ItemStack output, ItemStack cast, Fluid fluid, int amount) {
        registerBasinCasting(output, cast, fluid, amount);
    }

    public void setIngotValue(int ingotValue) {
        this.ingotValue = ingotValue;
    }

    public int getIngotValue() {
        return ingotValue;
    }

    public void setIngotsInBlock(int ingotsInBlock) {
        this.ingotsInBlock = ingotsInBlock;
    }

    public int getIngotsInBlock() {
        return ingotsInBlock;
    }

    public void setNuggetsInIngot(int nuggetsInIngot) {
        this.nuggetsInIngot = nuggetsInIngot;
    }

    public int getNuggetsInIngot() {
        return nuggetsInIngot;
    }
}

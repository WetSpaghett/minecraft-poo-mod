package WetSpaghett.Mods.ETILib.TinkerMaterials;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

import static slimeknights.tconstruct.library.TinkerRegistry.addMaterial;
import static slimeknights.tconstruct.library.TinkerRegistry.integrate;

public class MeltableMaterial {
    public Material material;

    /**
     * Creates a new material that can be casted, but not crafted.
     * @param identifier The unique name of your Material.
     * @param colour The colour of your material as a tool part. This is a typical hex colour put through a hex to decimal converter.
     */
    public MeltableMaterial(String identifier, int colour) {
        this.setMaterial(new Material(identifier, colour));
        this.getMaterial().setCastable(true);
        this.getMaterial().setCraftable(false);
    }
    /**
     * Adds stats for when the material is used as a tool head. Should be run in Pre-Initialization.
     * @param headDurability How much durability the tool head has.
     * @param miningSpeed How fast the tool will mine.
     * @param attackDamage How much damage the head will do.
     * @param harvestLevel The level of blocks can the tool break. The maximum in vanilla is 3.
     */
    public MeltableMaterial addHeadStats(int headDurability, Float miningSpeed, Float attackDamage, int harvestLevel) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new HeadMaterialStats(headDurability, miningSpeed, attackDamage, harvestLevel));
        return this;
    }

    /**
     * Adds stats for when the material is used as a tool handle. Should be run in Pre-Initialization.
     * @param handleModifier Multiplies durability of the tool. For example, a modifier of 0.5 would half the finished tool's maximum durability.
     * @param handleDurability The durability of the handle.
     */
    public MeltableMaterial addHandleStats(Float handleModifier, int handleDurability) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new HandleMaterialStats(handleModifier, handleDurability));
        return this;
    }

    /**
     * Adds stats for when the material is used as a tool binding or large plate. Should be run in Pre-Initialization.
     * @param extraDurability The durability of the tool part.
     */
    public MeltableMaterial addExtraStats(int extraDurability) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new ExtraMaterialStats(extraDurability));
        return this;
    }

    /**
     * Adds stats for when the material is used as a bowlimb. Should be run in Pre-Initialization.
     * @param drawSpeed The speed at which the bow draws.
     * @param range The distance the arrow will fly.
     * @param bonusDamage The amount of extra damage added by the bow.
     */
    public MeltableMaterial addBowMaterialStats(Float drawSpeed, Float range, Float bonusDamage) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new BowMaterialStats(drawSpeed, range, bonusDamage));
        return this;
    }

    /**
     * Adds stats for when the material is used as a bowstring. Should be run in Pre-Initialization.
     * @param bowstringModifier Multiplies durability of the bow. For example, a modifier of 0.5 would half the finished bow's maximum durability.
     */
    public MeltableMaterial addBowstringStats(Float bowstringModifier) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new BowStringMaterialStats(bowstringModifier));
        return this;
    }

    /**
     * Adds stats for when the material is used as an arrow shaft. Should be run in Pre-Initialization.
     * @param arrowModifier Multiplies durability of the arrow. For example, a modifier of 0.5 would half the finished arrow's maximum durability.
     * @param extraAmmo Extra ammo added by the arrow shaft.
     */
    public MeltableMaterial addArrowShaftStats(Float arrowModifier, int extraAmmo) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new ArrowShaftMaterialStats(arrowModifier, extraAmmo));
        return this;
    }

    /**
     * Adds stats for when the material is used as an arrow's fletching. Should be run in Pre-Initialization.
     * @param accuracy How accurate the arrow will be.
     * @param fletchingModifier Multiplies durability of the arrow. For example, a modifier of 0.5 would half the finished arrow's maximum durability.
     */
    public MeltableMaterial addFletchingStats(Float accuracy, Float fletchingModifier) {
        TinkerRegistry.addMaterialStats(this.getMaterial(), new FletchingMaterialStats(accuracy, fletchingModifier));
        return this;
    }

    /**
     * Registers a material. Should be run in Pre-Initialization.
     */
    public MeltableMaterial registerMaterial() {
        addMaterial(this.getMaterial());
        integrate(this.getMaterial());
        return this;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return this.material;
    }
}

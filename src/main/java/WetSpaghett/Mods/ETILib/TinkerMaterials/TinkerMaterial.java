package WetSpaghett.Mods.ETILib.TinkerMaterials;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

import static slimeknights.tconstruct.library.TinkerRegistry.addMaterial;
import static slimeknights.tconstruct.library.TinkerRegistry.integrate;

public class TinkerMaterial extends Material {

    /**
     * Despite what Tinker's Construct's formal parameters may lead you to believe, colour in this instance is not a text colour, but the colour of your material
     * as a tool part such as a pickaxe head or a tool rod. <br>
     * The colour is just a regular hex colour value, converted to decimal.
     */
    public TinkerMaterial(String identifier, int colour) {
        super(identifier, colour);
        this.setCastable(false);
        this.setCraftable(true);
    }

    /**
     * Adds stats for when the material is used as a tool head. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addHeadStats(Material mat, int headDurability, Float miningSpeed, Float attackDamage, int harvestLevel) {
        TinkerRegistry.addMaterialStats(mat, new HeadMaterialStats(headDurability, miningSpeed, attackDamage, harvestLevel));
    }

    /**
     * Adds stats for when the material is used as a tool handle. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addHandleStats(Material mat, Float handleModifier, int handleDurability) {
        TinkerRegistry.addMaterialStats(mat, new HandleMaterialStats(handleModifier, handleDurability));
    }

    /**
     * Adds stats for when the material is used as a tool binding or large plate. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addExtraStats(Material mat, int extraDurability) {
        TinkerRegistry.addMaterialStats(mat, new ExtraMaterialStats(extraDurability));
    }

    /**
     * Adds stats for when the material is used as a bowlimb. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addBowMaterialStats(Material mat, Float drawSpeed, Float range, Float bonusDamage) {
        TinkerRegistry.addMaterialStats(mat, new BowMaterialStats(drawSpeed, range, bonusDamage));
    }

    /**
     * Adds stats for when the material is used as a bowstring. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addBowstringStats(Material mat, Float bowstringModifier) {
        TinkerRegistry.addMaterialStats(mat, new BowStringMaterialStats(bowstringModifier));
    }

    /**
     * Adds stats for when the material is used as an arrow shaft. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addArrowShaftStats(Material mat, Float arrowModifier, int extraAmmo) {
        TinkerRegistry.addMaterialStats(mat, new ArrowShaftMaterialStats(arrowModifier, extraAmmo));
    }

    /**
     * Adds stats for when the material is used as an arrow's fletching. <br>
     * Should be called from Pre-Initialization.
     */
    public static void addFletchingStats(Material mat, Float accuracy, Float fletchingModifier) {
        TinkerRegistry.addMaterialStats(mat, new FletchingMaterialStats(accuracy, fletchingModifier));
    }

    /**
     * Registers your material. <br>
     * Should be called from Pre-Initialization.
     */
    public static void registerMaterial(Material mat) {
        addMaterial(mat);
        integrate(mat);
    }
}

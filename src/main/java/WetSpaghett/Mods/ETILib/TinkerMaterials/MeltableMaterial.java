package WetSpaghett.Mods.ETILib.TinkerMaterials;

public class MeltableMaterial extends TinkerMaterial {

    /**
     Despite what Tinker's Construct's formal parameters may lead you to believe, colour in this instance is not a text colour, but the colour of your material
     * as a tool part such as a pickaxe head or a tool rod.
     * The colour is just a regular hex colour value in decimal form.
     */
    public MeltableMaterial(String identifier, int colour) {
        super(identifier, colour);
        this.setCastable(true);
        this.setCraftable(false);
    }
}

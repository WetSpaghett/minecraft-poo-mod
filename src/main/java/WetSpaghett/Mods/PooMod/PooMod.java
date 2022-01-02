package WetSpaghett.Mods.PooMod;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = PooMod.MODID, name = PooMod.NAME, version = PooMod.VERSION)
public class PooMod {
    public static final String MODID = "poomod";
    public static final String NAME = "Poo Mod";
    public static final String VERSION = "v0.2.3";
    public static final Logger LOGGER = LogManager.getLogger(PooMod.MODID);
    public static Item.ToolMaterial POO = EnumHelper.addToolMaterial("PooMod.POO", 3, 512, 10f, 4f, 32);

    // Log when mod is pre-initialized and initialized for debugging purposes
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info(PooMod.NAME + " " + PooMod.VERSION + " pre-initialized");
    }
    public void init(FMLInitializationEvent event) {
        LOGGER.info(PooMod.NAME + " " + PooMod.VERSION + " initialized");
    }
}



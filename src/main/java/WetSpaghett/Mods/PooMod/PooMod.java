package WetSpaghett.Mods.PooMod;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = PooMod.MODID, name = PooMod.NAME, version = PooMod.VERSION)
public class PooMod {
    public static final String MODID = "poomod";
    public static final String NAME = "The Poo Mod";
    public static final String VERSION = "0.1.6";
    public static final Logger LOGGER = LogManager.getLogger(PooMod.MODID);
    public static Item.ToolMaterial POO = EnumHelper.addToolMaterial("PooMod.POO", 3, 512, 10f, 4f, 32);

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        LOGGER.info(PooMod.NAME + " says hi!");
    }
}



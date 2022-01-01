package WetSpaghett.Mods.PooMod.Server;

import WetSpaghett.Mods.PooMod.Items;
import WetSpaghett.Mods.PooMod.PooMod;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PooMod.MODID)
public class EventHandler {
    public static float foodEaten = 0f;
    public static float currentFood = 0f;
    public static ItemFood food = null;
    public static boolean canGivePoo = false;

    // Gets all information for PooMaker() as you can't call event.getItemStack() from LivingEntityUseItemEvent.Finish
    @SubscribeEvent
    public static void PooChecker(PlayerInteractEvent.RightClickItem event) {
        World world = event.getEntity().getEntityWorld();
        if (!world.isRemote) {
            if (event.getItemStack().getItemUseAction() == EnumAction.EAT) {
                food = (ItemFood) event.getItemStack().getItem();
                currentFood = food.getHealAmount(event.getItemStack());
                if (!event.getItemStack().getItem().getUnlocalizedName().equals(Items.POO.getUnlocalizedName()) && (!event.getItemStack().getItem().getUnlocalizedName().equals(Items.PEE.getUnlocalizedName()))) {
                    canGivePoo = true;
                }
            }
        }
    }

    // Stops poo being given by starting and stopping eating another food, then eating poo or pee.
    @SubscribeEvent
    public static void PooCheaterChecker(LivingEntityUseItemEvent.Stop event) {
        World world = event.getEntity().getEntityWorld();
        if(!world.isRemote) {
            canGivePoo = false;
        }
    }

    // Gives the player one poo and pee when they've eaten enough food.
    @SubscribeEvent
    public static void PooMaker(LivingEntityUseItemEvent.Finish event) {
        World world = event.getEntity().getEntityWorld();
        if (!world.isRemote && canGivePoo) {
            foodEaten += currentFood;
            if (foodEaten >= 20f) {
                foodEaten -= 20f;
                ItemStack[] stacks = {
                        new ItemStack(Items.POO, 1),
                        new ItemStack(Items.PEE, 1)
                };
                world.spawnEntity(new EntityItem(world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stacks[0]));
                world.spawnEntity(new EntityItem(world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stacks[1]));
            }
        }
    }
}

package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.item.BugPearlFishItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class BugPearlFishWorkProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure BugPearlFishWork!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BugPearlFishWork!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == BugPearlFishItem.block)) {
			if ((((entity.getDisplayName().getString())).equals("\u5C0F\u4E11\u9C7C"))) {
				{
					ItemStack _ist = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if ((Math.random() < 0.2)) {
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(Items.ENDER_PEARL);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
				}
				if ((Math.random() < 0.05)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) 0);
				}
			}
		}
	}
}

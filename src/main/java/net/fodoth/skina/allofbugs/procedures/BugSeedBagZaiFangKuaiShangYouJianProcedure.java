package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.fodoth.skina.allofbugs.block.BugSeedBagBlock;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;
import java.util.HashMap;

public class BugSeedBagZaiFangKuaiShangYouJianProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure BugSeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure BugSeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure BugSeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure BugSeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure BugSeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BugSeedBagBlock.block) && (!(entity.isSneaking())))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.WHEAT_SEEDS);
				_setstack.setCount((int) 4);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
	}
}

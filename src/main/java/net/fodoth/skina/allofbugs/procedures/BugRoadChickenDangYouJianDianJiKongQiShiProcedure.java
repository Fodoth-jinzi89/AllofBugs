package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.fodoth.skina.allofbugs.item.BugRoadChickenItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class BugRoadChickenDangYouJianDianJiKongQiShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure BugRoadChickenDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure BugRoadChickenDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure BugRoadChickenDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure BugRoadChickenDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure BugRoadChickenDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double i = 0;
		double xi = 0;
		double yi = 0;
		double zi = 0;
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(BugRoadChickenItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		while ((i < 50)) {
			xi = (double) (x + (i * ((entity.getHorizontalFacing()).getXOffset())));
			yi = (double) ((y - 1) + (i * ((entity.getHorizontalFacing()).getYOffset())));
			zi = (double) (z + (i * ((entity.getHorizontalFacing()).getZOffset())));
			if ((world.isAirBlock(new BlockPos((int) xi, (int) yi, (int) zi)))) {
				world.setBlockState(new BlockPos((int) xi, (int) yi, (int) zi), Blocks.DIRT.getDefaultState(), 3);
			}
		}
	}
}

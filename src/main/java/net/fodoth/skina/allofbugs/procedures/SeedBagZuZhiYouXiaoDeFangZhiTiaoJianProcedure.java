package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class SeedBagZuZhiYouXiaoDeFangZhiTiaoJianProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure SeedBagZuZhiYouXiaoDeFangZhiTiaoJian!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure SeedBagZuZhiYouXiaoDeFangZhiTiaoJian!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure SeedBagZuZhiYouXiaoDeFangZhiTiaoJian!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure SeedBagZuZhiYouXiaoDeFangZhiTiaoJian!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolidSide(world, new BlockPos((int) x, (int) (y - 1), (int) z),
				Direction.UP));
	}
}

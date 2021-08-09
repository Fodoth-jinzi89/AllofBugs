package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class BubbleStoneKeHuDuanXianShiSuiJiKeProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure BubbleStoneKeHuDuanXianShiSuiJiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure BubbleStoneKeHuDuanXianShiSuiJiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure BubbleStoneKeHuDuanXianShiSuiJiKe!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure BubbleStoneKeHuDuanXianShiSuiJiKe!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (10); index0++) {
			world.addParticle(ParticleTypes.BUBBLE, (x + Math.random()), (y + 1.1), (z + Math.random()), (Math.random() - 0.5), (Math.random() * 0.3),
					(Math.random() - 0.5));
		}
	}
}

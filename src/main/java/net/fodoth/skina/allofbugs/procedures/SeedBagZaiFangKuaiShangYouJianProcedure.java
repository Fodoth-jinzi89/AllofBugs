package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class SeedBagZaiFangKuaiShangYouJianProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure SeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure SeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure SeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure SeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure SeedBagZaiFangKuaiShangYouJian!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Items.WHEAT_SEEDS);
			_setstack.setCount((int) 4);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if ((Math.random() < 0.2)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}

package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import net.fodoth.skina.allofbugs.item.RecallCompassItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Random;
import java.util.Map;
import java.util.Collections;

public class RecallCompassDangYouJianDianJiKongQiShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure RecallCompassDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure RecallCompassDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure RecallCompassDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure RecallCompassDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure RecallCompassDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure RecallCompassDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((itemstack).getOrCreateTag().getBoolean("Noted")))) {
			(itemstack).getOrCreateTag().putBoolean("Noted", (true));
			(itemstack).getOrCreateTag().putDouble("Rx", x);
			(itemstack).getOrCreateTag().putDouble("Ry", y);
			(itemstack).getOrCreateTag().putDouble("Rz", z);
		} else {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(((itemstack).getOrCreateTag().getDouble("Rx")), ((itemstack).getOrCreateTag().getDouble("Ry")),
						((itemstack).getOrCreateTag().getDouble("Rz")));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(((itemstack).getOrCreateTag().getDouble("Rx")),
							((itemstack).getOrCreateTag().getDouble("Ry")), ((itemstack).getOrCreateTag().getDouble("Rz")), _ent.rotationYaw,
							_ent.rotationPitch, Collections.emptySet());
				}
			}
			if (world.isRemote()) {
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(RecallCompassItem.block));
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown((itemstack).getItem(), (int) 20);
	}
}

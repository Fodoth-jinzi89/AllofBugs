package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.item.BugGoldenArmorSummonerItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class BugGoldenArmorSummonerDangYouJianDianJiKongQiShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure BugGoldenArmorSummonerDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure BugGoldenArmorSummonerDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure BugGoldenArmorSummonerDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure BugGoldenArmorSummonerDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure BugGoldenArmorSummonerDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double i = 0;
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(BugGoldenArmorSummonerItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		i = (double) 1;
		while ((i < 5)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) i))
								: ItemStack.EMPTY));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
			i = (double) (i + 1);
		}
		if (entity instanceof LivingEntity) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.GOLDEN_BOOTS));
			else
				((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
						new ItemStack(Items.GOLDEN_BOOTS));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		if (entity instanceof LivingEntity) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.GOLDEN_LEGGINGS));
			else
				((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
						new ItemStack(Items.GOLDEN_LEGGINGS));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		if (entity instanceof LivingEntity) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.GOLDEN_CHESTPLATE));
			else
				((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
						new ItemStack(Items.GOLDEN_CHESTPLATE));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		if (entity instanceof LivingEntity) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.armorInventory.set((int) 4, new ItemStack(Items.GOLDEN_HELMET));
			else
				((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 4),
						new ItemStack(Items.GOLDEN_HELMET));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
	}
}

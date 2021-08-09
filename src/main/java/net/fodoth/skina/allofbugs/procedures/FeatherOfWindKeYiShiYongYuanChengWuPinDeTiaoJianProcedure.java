package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.item.FeatherOfWindItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

public class FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJianProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onUseItemStart(LivingEntityUseItemEvent.Stop event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double duration = event.getDuration();
				ItemStack itemstack = event.getItem();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("itemstack", itemstack);
				dependencies.put("duration", duration);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJian!");
			return false;
		}
		if (dependencies.get("duration") == null) {
			if (!dependencies.containsKey("duration"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency duration for procedure FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJian!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJian!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJian!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJian!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure FeatherOfWindKeYiShiYongYuanChengWuPinDeTiaoJian!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double duration = dependencies.get("duration") instanceof Integer
				? (int) dependencies.get("duration")
				: (double) dependencies.get("duration");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double vx = 0;
		double vy = 0;
		double vz = 0;
		double r = 0;
		double strength = 0;
		if (((itemstack).getItem() == FeatherOfWindItem.block)) {
			if ((!((itemstack).getOrCreateTag().getBoolean("isOn")))) {
				if (((duration) < 71970)) {
					(itemstack).getOrCreateTag().putBoolean("isOn", (true));
				}
			} else {
				(itemstack).getOrCreateTag().putBoolean("isOn", (false));
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (12 / 2d), y - (12 / 2d), z - (12 / 2d), x + (12 / 2d), y + (12 / 2d), z + (12 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((entityiterator instanceof MonsterEntity)) {
							vx = (double) ((entityiterator.getPosX()) - x);
							vy = (double) (((entityiterator.getPosY()) - y) + 1);
							vz = (double) ((entityiterator.getPosZ()) - z);
							r = (double) Math.sqrt(((Math.pow(vx, 2) + Math.pow(vy, 2)) + Math.pow(vz, 2)));
							strength = (double) Math.min(((72000 - (duration)) / 5), 10);
							vx = (double) ((vx / r) * strength);
							vy = (double) ((vy / r) * strength);
							vz = (double) ((vz / r) * strength);
							entityiterator.setMotion(((entityiterator.getMotion().getX()) + vx), ((entityiterator.getMotion().getY()) + vy),
									((entityiterator.getMotion().getZ()) + vz));
						}
					}
				}
			}
		}
		return (false);
	}
}

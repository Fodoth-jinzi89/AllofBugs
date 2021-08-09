package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class GodSlayerThunderDangShiTiHuiDongWuPinShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure GodSlayerThunderDangShiTiHuiDongWuPinShi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure GodSlayerThunderDangShiTiHuiDongWuPinShi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure GodSlayerThunderDangShiTiHuiDongWuPinShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure GodSlayerThunderDangShiTiHuiDongWuPinShi!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
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
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(
								new BlockPos((int) (entityiterator.getPosX()), (int) (entityiterator.getPosY()), (int) (entityiterator.getPosZ()))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
				}
			}
		}
	}
}

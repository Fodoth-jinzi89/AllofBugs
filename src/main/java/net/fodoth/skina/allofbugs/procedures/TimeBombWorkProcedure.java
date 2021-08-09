package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;
import java.util.HashMap;

public class TimeBombWorkProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure TimeBombWork!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure TimeBombWork!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure TimeBombWork!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure TimeBombWork!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure TimeBombWork!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack oitem = ItemStack.EMPTY;
		boolean found = false;
		if ((entity.isAlive())) {
			oitem = (new Object() {
				public ItemStack entityToItem(Entity _ent) {
					if (_ent instanceof ItemEntity) {
						return ((ItemEntity) _ent).getItem();
					}
					return ItemStack.EMPTY;
				}
			}.entityToItem(entity));
			(oitem).getOrCreateTag().putDouble("CountDown", (((oitem).getOrCreateTag().getDouble("CountDown")) - 20));
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent((("\u5728 x:") + ""
							+ ((new java.text.DecimalFormat("##.##").format((entity.getPosX())))) + "" + (" y:") + ""
							+ ((new java.text.DecimalFormat("##.##").format((entity.getPosY())))) + "" + (" z:") + ""
							+ ((new java.text.DecimalFormat("##.##").format((entity.getPosZ())))) + ""
							+ (" \u7684\u5B9A\u65F6\u70B8\u5F39\u8FD8\u6709") + ""
							+ ((new java.text.DecimalFormat("##.##").format(Math.floor((((oitem).getOrCreateTag().getDouble("CountDown")) / 20)))))
							+ "" + ("\u79D2\u7206\u70B8"))), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			if ((((oitem).getOrCreateTag().getDouble("CountDown")) <= 0)) {
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 5,
							Explosion.Mode.BREAK);
				}
				if (!entity.world.isRemote())
					entity.remove();
			} else {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;
					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							$_dependencies.put("world", world);
							TimeBombWorkProcedure.executeProcedure($_dependencies);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			}
		}
	}
}

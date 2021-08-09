package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.item.TimeBombItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;
import java.util.HashMap;

public class TimeBombDangWuPinYouWanJiaDiaoLuoProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onGemDropped(ItemTossEvent event) {
			PlayerEntity entity = event.getPlayer();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			ItemStack itemstack = event.getEntityItem().getItem();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("itemstack", itemstack);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure TimeBombDangWuPinYouWanJiaDiaoLuo!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure TimeBombDangWuPinYouWanJiaDiaoLuo!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency x for procedure TimeBombDangWuPinYouWanJiaDiaoLuo!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency y for procedure TimeBombDangWuPinYouWanJiaDiaoLuo!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency z for procedure TimeBombDangWuPinYouWanJiaDiaoLuo!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure TimeBombDangWuPinYouWanJiaDiaoLuo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		Entity itemEntity = ((ItemTossEvent) dependencies.get("event")).getEntityItem();
		if (((itemstack).getItem() == TimeBombItem.block)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent(
									(((entity.getDisplayName().getString())) + "" + ("\u6254\u51FA\u4E86\u5B9A\u65F6\u70B8\u5F39\u3002"))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			(itemstack).getOrCreateTag().putDouble("CountDown", 200);
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
					$_dependencies.put("entity", itemEntity);
					$_dependencies.put("world", world);
					$_dependencies.put("x", itemEntity.getPosX());
					$_dependencies.put("y", itemEntity.getPosY());
					$_dependencies.put("z", itemEntity.getPosZ());
						TimeBombWorkProcedure.executeProcedure($_dependencies);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		}
	}
}

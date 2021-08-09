package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.item.BugHelloSpiritItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;
import java.util.HashMap;

public class BugHelloSpiritEnterWorldProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure BugHelloSpiritEnterWorld!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure BugHelloSpiritEnterWorld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(BugHelloSpiritItem.block)) : false)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent(
							(((entity.getDisplayName().getString())) + "" + ("\u7684\u95EE\u5019\u7CBE\u7075\u5411\u5927\u5BB6\u95EE\u597D\u3002"))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}
}

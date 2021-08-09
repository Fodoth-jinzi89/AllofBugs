package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class BugTorchCounterDangYouJianDianJiKongQiShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure BugTorchCounterDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure BugTorchCounterDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double torchCount = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (((itemstackiterator).getItem() == Blocks.TORCH.asItem())) {
						torchCount = (double) (((itemstackiterator)).getCount());
					}
				}
			}
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent((((entity.getDisplayName().getString())) + "" + ("\u7684\u80CC\u5305\u4E2D\u6709") + ""
								+ ((new java.text.DecimalFormat("##.##").format(torchCount))) + "" + ("\u4E2A\u706B\u628A"))),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if ((torchCount > 128)) {
			entity.rotationYaw = (float) (((entity.rotationYaw) + Math.toRadians(180)));
			entity.setRenderYawOffset(entity.rotationYaw);
			entity.prevRotationYaw = entity.rotationYaw;
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
				((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
				((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
			}
			entity.rotationPitch = (float) (0);
		}
	}
}

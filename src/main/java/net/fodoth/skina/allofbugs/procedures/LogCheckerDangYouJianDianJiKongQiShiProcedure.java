package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class LogCheckerDangYouJianDianJiKongQiShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure LogCheckerDangYouJianDianJiKongQiShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency world for procedure LogCheckerDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("minecraft:logs").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((new Object() {
								public BlockState toBlock(ItemStack _stk) {
									if (_stk.getItem() instanceof BlockItem) {
										return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
									}
									return Blocks.AIR.getDefaultState();
								}
							}.toBlock((itemstackiterator))).getBlock()))) {
						if (!world.isRemote()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList()
										.func_232641_a_(new StringTextComponent((("\u68C0\u6D4B\u5230") + "" + ((entity.getDisplayName().getString()))
												+ "" + ("\u7684\u80CC\u5305\u4E2D\u6709\u539F\u6728\u6807\u7B7E\u7269\u54C1\uFF1A") + ""
												+ (((itemstackiterator).getDisplayName().getString())))), ChatType.SYSTEM, Util.DUMMY_UUID);
						}
					}
				}
			}
		}
	}
}

package net.fodoth.skina.allofbugs.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.fodoth.skina.allofbugs.item.LuckyLeafItem;
import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class LuckyLeafDangYouJianDianJiKongQiShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency entity for procedure LuckyLeafDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(LuckyLeafItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		if ((Math.random() < 0.5)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.DIAMOND);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}

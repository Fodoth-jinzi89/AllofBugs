package net.fodoth.skina.allofbugs.procedures;

import net.minecraft.item.ItemStack;

import net.fodoth.skina.allofbugs.AllOfBugsMod;

import java.util.Map;

public class BugRecallCompassShiWuPinFaGuangProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AllOfBugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure BugRecallCompassShiWuPinFaGuang!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		return ((itemstack).getOrCreateTag().getBoolean("tagName"));
	}
}

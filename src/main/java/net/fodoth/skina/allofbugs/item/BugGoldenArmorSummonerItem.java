
package net.fodoth.skina.allofbugs.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.fodoth.skina.allofbugs.procedures.BugGoldenArmorSummonerDangYouJianDianJiKongQiShiProcedure;
import net.fodoth.skina.allofbugs.itemgroup.AllOfBugsItemGroup;
import net.fodoth.skina.allofbugs.AllOfBugsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@AllOfBugsModElements.ModElement.Tag
public class BugGoldenArmorSummonerItem extends AllOfBugsModElements.ModElement {
	@ObjectHolder("all_of_bugs:bug_golden_armor_summoner")
	public static final Item block = null;
	public BugGoldenArmorSummonerItem(AllOfBugsModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AllOfBugsItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bug_golden_armor_summoner");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Bug.\u00A7c007"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BugGoldenArmorSummonerDangYouJianDianJiKongQiShiProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}

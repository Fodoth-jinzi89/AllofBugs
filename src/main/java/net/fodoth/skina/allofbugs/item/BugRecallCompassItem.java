
package net.fodoth.skina.allofbugs.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import net.fodoth.skina.allofbugs.procedures.BugRecallCompassShiWuPinFaGuangProcedure;
import net.fodoth.skina.allofbugs.procedures.BugRecallCompassDangYouJianDianJiKongQiShiProcedure;
import net.fodoth.skina.allofbugs.itemgroup.AllOfBugsItemGroup;
import net.fodoth.skina.allofbugs.AllOfBugsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@AllOfBugsModElements.ModElement.Tag
public class BugRecallCompassItem extends AllOfBugsModElements.ModElement {
	@ObjectHolder("all_of_bugs:bug_recall_compass")
	public static final Item block = null;
	public BugRecallCompassItem(AllOfBugsModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AllOfBugsItemGroup.tab).maxDamage(10).rarity(Rarity.RARE));
			setRegistryName("bug_recall_compass");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (!(BugRecallCompassShiWuPinFaGuangProcedure.executeProcedure(ImmutableMap.of("itemstack", itemstack)))) {
				return false;
			}
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Bug.\u00A7c005"));
			if (itemstack.getOrCreateTag().getBoolean("tagName")) {
				list.add(new StringTextComponent("\u00A7e\u5df2\u8bb0\u5f55"));
				list.add(new StringTextComponent("x:\u00A7b"+(new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Rx")))));
				list.add(new StringTextComponent("y:\u00A7b"+(new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Ry")))));
				list.add(new StringTextComponent("z:\u00A7b"+(new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Rz")))));
			}
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
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BugRecallCompassDangYouJianDianJiKongQiShiProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}

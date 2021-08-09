
package net.fodoth.skina.allofbugs.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.fodoth.skina.allofbugs.item.AllOfBugsIconItem;
import net.fodoth.skina.allofbugs.AllOfBugsModElements;

@AllOfBugsModElements.ModElement.Tag
public class AllOfBugsItemGroup extends AllOfBugsModElements.ModElement {
	public AllOfBugsItemGroup(AllOfBugsModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("taball_of_bugs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AllOfBugsIconItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

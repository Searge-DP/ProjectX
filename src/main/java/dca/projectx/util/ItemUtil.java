package dca.projectx.util;

/**
 * Generic Item Util Class. Most code provided by CoFHLib !
 * All rights go to TeamCoFH !!!
 * @author KingLemming
 */

import java.util.Random;
import com.google.common.base.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemUtil {
	
	public static ItemStack cloneStack(Item item, int stackSize) {

		if (item == null) {
			return null;
		}
		ItemStack stack = new ItemStack(item, stackSize);

		return stack;
	}
	
	public static ItemStack cloneStack(Block item, int stackSize) {

		if (item == null) {
			return null;
		}
		ItemStack stack = new ItemStack(item, stackSize);

		return stack;
	}
	
	public static ItemStack cloneStack(ItemStack stack, int stackSize) {

		if (stack == null) {
			return null;
		}
		ItemStack retStack = stack.copy();
		retStack.stackSize = stackSize;

		return retStack;
	}
	
	public static ItemStack cloneStack(ItemStack stack) {

		if (stack == null) {
			return null;
		}
		ItemStack retStack = stack.copy();

		return retStack;
	}
	
	public static ItemStack copyTag(ItemStack container, ItemStack other) {

		if (other != null && other.stackTagCompound != null) {
			container.stackTagCompound = (NBTTagCompound) other.stackTagCompound.copy();
		}
		return container;
	}
	
	public static NBTTagCompound setItemStackTagName(NBTTagCompound tag, String name) {

		if (Strings.isNullOrEmpty(name)) {
			return null;
		}
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		if (!tag.hasKey("display")) {
			tag.setTag("display", new NBTTagCompound());
		}
		tag.getCompoundTag("display").setString("Name", name);

		return tag;
	}
	
	public static String getNameFromItemStack(ItemStack stack) {

		if (stack == null || stack.stackTagCompound == null || !stack.stackTagCompound.hasKey("display")) {
			return "";
		}
		return stack.stackTagCompound.getCompoundTag("display").getString("Name");
	}
	
	public static ItemStack damageItem(ItemStack stack, int amt, Random rand) {

		if (stack != null && stack.isItemStackDamageable()) {
			if (stack.attemptDamageItem(amt, rand)) {
				if (--stack.stackSize <= 0) {
					stack = null;
				} else {
					stack.setItemDamage(0);
				}
			}
		}

		return stack;
	}
	
	public static ItemStack consumeItem(ItemStack stack) {

		if (stack == null) {
			return null;
		}

		Item item = stack.getItem();
		boolean largerStack = stack.stackSize > 1;
		// vanilla only alters the stack passed to hasContainerItem/etc. when the size is >1

		if (largerStack) {
			stack.stackSize -= 1;
		}
		if (item.hasContainerItem(stack)) {
			ItemStack ret = item.getContainerItem(stack);

			if (ret == null) {
				return null;
			}
			if (ret.isItemStackDamageable() && ret.getItemDamage() > ret.getMaxDamage()) {
				ret = null;
			}
			return ret;
		}

		return largerStack ? stack : null;
	}
	
	public static Item getItemFromStack(ItemStack theStack) {

		return theStack == null ? null : theStack.getItem();
	}

}

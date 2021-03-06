package vectorwing.farmersdelight.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import vectorwing.farmersdelight.FarmersDelight;

/**
 * References to tags under the Farmer's Delight namespace.
 * These tags are used for mod mechanics, which aren't always useful outside of it.
 */
public class ModTags
{
	// Blocks that can heat up a Cooking Pot.
	public static final Tag<Block> HEAT_SOURCES = modBlockTag("heat_sources");

	// Blocks to which a Cooking Pot will render a tray over. Use HEAT_SOURCES for heat logic.
	public static final Tag<Block> TRAY_HEAT_SOURCES = modBlockTag("tray_heat_sources");

	// Blocks that accelerate decomposition of Organic Compost if placed adjacent to it.
	public static final Tag<Block> COMPOST_ACTIVATORS = modBlockTag("compost_activators");

	// Foods that drop from mobs that wolves prey upon (currently, just sheep and chicken).
	public static final Tag<Item> WOLF_PREY = modItemTag("wolf_prey");

	// Knife items for game logic.
	public static final Tag<Item> KNIVES = modItemTag("tools/knife");

	private static Tag<Item> modItemTag(String path) {
		return new ItemTags.Wrapper(new ResourceLocation(FarmersDelight.MODID, path));
	}
	private static Tag<Block> modBlockTag(String path) {
		return new BlockTags.Wrapper(new ResourceLocation(FarmersDelight.MODID, path));
	}
}

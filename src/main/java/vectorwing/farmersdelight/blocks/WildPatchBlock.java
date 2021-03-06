package vectorwing.farmersdelight.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class WildPatchBlock extends BushBlock implements IGrowable
{
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public WildPatchBlock(Properties properties)
	{
		super(properties);
	}

	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.RED_SAND;
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	public Block.OffsetType getOffsetType() {
		return OffsetType.XZ;
	}

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		if (worldIn.getRandom().nextFloat() <= 0.3F) {
			spawnAsEntity(worldIn, pos, new ItemStack(this));
		}
	}
}

package org.twittercity.twittercitymod.util;

import net.minecraft.block.*;
import net.minecraft.block.BlockLever.EnumOrientation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.twittercity.twittercitymod.TwitterCity;
import org.twittercity.twittercitymod.blocks.*;
import org.twittercity.twittercitymod.tileentity.TileEntityTwitter;

import java.util.List;

public class BlockHelper {

    public static EnumFacing cardinalRotation(EnumFacing facing, int rotation) {
        switch (rotation) {
            case 1:
                switch (facing) {
                    case UP:
                    case DOWN:
                        return facing;
                    case NORTH:
                        return EnumFacing.WEST;
                    case EAST:
                        return EnumFacing.NORTH;
                    case SOUTH:
                        return EnumFacing.EAST;
                    case WEST:
                        return EnumFacing.SOUTH;
                    default:
                        TwitterCity.logger.error("Invalid facing in switch statement.");
                        return facing;
                }
            case 2:
                switch (facing) {
                    case UP:
                    case DOWN:
                        return facing;
                    case NORTH:
                        return EnumFacing.EAST;
                    case EAST:
                        return EnumFacing.SOUTH;
                    case SOUTH:
                        return EnumFacing.WEST;
                    case WEST:
                        return EnumFacing.NORTH;
                    default:
                        TwitterCity.logger.error("Invalid facing in switch statement.");
                }
            case 3:
                switch (facing) {
                    case UP:
                    case DOWN:
                        return facing;
                    case NORTH:
                        return EnumFacing.SOUTH;
                    case EAST:
                        return EnumFacing.WEST;
                    case SOUTH:
                        return EnumFacing.NORTH;
                    case WEST:
                        return EnumFacing.EAST;
                    default:
                        TwitterCity.logger.error("Invalid facing in switch statement.");
                }
            default:
                return facing;
        }
    }

    public static EnumOrientation rotateLever(EnumOrientation orientation, int rotation) {
        switch (rotation) {
            case 1:
                switch (orientation) {
                    case NORTH:
                        return EnumOrientation.WEST;
                    case EAST:
                        return EnumOrientation.NORTH;
                    case SOUTH:
                        return EnumOrientation.EAST;
                    case WEST:
                        return EnumOrientation.SOUTH;
                    default:
                        TwitterCity.logger.error("Invalid facing in switch statement.");
                }
                break;
            case 2:
                switch (orientation) {
                    case NORTH:
                        return EnumOrientation.EAST;
                    case EAST:
                        return EnumOrientation.SOUTH;
                    case SOUTH:
                        return EnumOrientation.WEST;
                    case WEST:
                        return EnumOrientation.NORTH;
                    default:
                        TwitterCity.logger.error("Invalid facing in switch statement.");
                }
                break;
            case 3:
                switch (orientation) {
                    case NORTH:
                        return EnumOrientation.SOUTH;
                    case EAST:
                        return EnumOrientation.WEST;
                    case SOUTH:
                        return EnumOrientation.NORTH;
                    case WEST:
                        return EnumOrientation.EAST;
                    default:
                        TwitterCity.logger.error("Invalid facing in switch statement.");
                }
                break;
            default:
                TwitterCity.logger.error("Invalid facing in switch statement.");
                return orientation;
        }
        return orientation;
    }

    public static boolean needsToBeBuildedLast(Block block) {
        return block == Blocks.UNLIT_REDSTONE_TORCH || block == Blocks.REDSTONE_TORCH || block == Blocks.TORCH || block == Blocks.LEVER
                || block == Blocks.WALL_SIGN || block == Blocks.LADDER || block == Blocks.DISPENSER || block == Blocks.CHEST
                || block == Blocks.FURNACE || block == Blocks.LIT_FURNACE || block == Blocks.STONE_BUTTON;

    }

    public static boolean isStairs(Block block) {
        return block == Blocks.STONE_BRICK_STAIRS || block == Blocks.BRICK_STAIRS || block == Blocks.NETHER_BRICK_STAIRS
                || block == Blocks.STONE_STAIRS || block == Blocks.BIRCH_STAIRS || block == Blocks.ACACIA_STAIRS
                || block == Blocks.DARK_OAK_STAIRS || block == Blocks.JUNGLE_STAIRS || block == Blocks.OAK_STAIRS
                || block == Blocks.PURPUR_STAIRS || block == Blocks.QUARTZ_STAIRS || block == Blocks.RED_SANDSTONE_STAIRS
                || block == Blocks.SANDSTONE_STAIRS || block == Blocks.SPRUCE_STAIRS;
    }

    public static boolean isFenceGate(Block block) {
        return block == Blocks.ACACIA_FENCE_GATE || block == Blocks.BIRCH_FENCE_GATE || block == Blocks.DARK_OAK_FENCE_GATE
                || block == Blocks.JUNGLE_FENCE_GATE || block == Blocks.OAK_FENCE_GATE || block == Blocks.SPRUCE_FENCE_GATE;
    }

    public static boolean isPistonPart(Block block) {
        return block == Blocks.PISTON_HEAD || block == Blocks.PISTON_EXTENSION;
    }

    public static boolean isPistonBasePart(Block block) {
        return block == Blocks.PISTON || block == Blocks.STICKY_PISTON;
    }

    public static boolean isTorch(Block block) {
        return block == Blocks.UNLIT_REDSTONE_TORCH || block == Blocks.REDSTONE_TORCH || block == Blocks.TORCH;
    }

    public static boolean isDoor(Block block) {
        return block == Blocks.IRON_DOOR || block == Blocks.DARK_OAK_DOOR || block == Blocks.ACACIA_DOOR || block == Blocks.BIRCH_DOOR
                || block == Blocks.JUNGLE_DOOR || block == Blocks.OAK_DOOR || block == Blocks.SPRUCE_DOOR;
    }

    public static boolean isMushroom(Block block) {
        return block == Blocks.BROWN_MUSHROOM || block == Blocks.RED_MUSHROOM;
    }

    public static boolean isPumpkin(Block block) {
        return block == Blocks.PUMPKIN || block == Blocks.LIT_PUMPKIN;
    }

    public static boolean isRepeater(Block block) {
        return block == Blocks.POWERED_REPEATER || block == Blocks.UNPOWERED_REPEATER;
    }

    public static int rotateStandingSign(int value, int rotate) {
        switch (rotate) {
            case 1: //COUNTERCLOCKWISE_90:
                return (value + 16 * 3 / 4) % 16;
            case 2: //CLOCKWISE_90:
                return (value + 16 / 4) % 16;
            case 3: //CLOCKWISE_180:
                return (value + 16 / 2) % 16;
            default:
                return value;
        }
    }

    public static boolean isBlockToIgnore(Block block) {
        return block == Blocks.VINE || BlockHelper.isRepeater(block) || block == Blocks.RAIL || BlockHelper.isMushroom(block);
    }


    public static void spawnRotatedBed(World world, BlockPos currentPos, IBlockState blockState, int rotation) {
        if (blockState.getValue(BlockBed.PART).equals(BlockBed.EnumPartType.HEAD)) {
            return;
        }

        EnumFacing enumFacing = BlockHelper.cardinalRotation(blockState.getValue(BlockBed.FACING), rotation);
        IBlockState iBlockState2 = Blocks.BED.getDefaultState().withProperty(BlockBed.OCCUPIED, Boolean.FALSE).withProperty(BlockBed.FACING, enumFacing).withProperty(BlockBed.PART, BlockBed.EnumPartType.FOOT);
        BlockPos blockPos = currentPos.offset(enumFacing);
        world.setBlockState(currentPos, iBlockState2, 10);
        world.setBlockState(blockPos, iBlockState2.withProperty(BlockBed.PART, BlockBed.EnumPartType.HEAD), 10);

        world.notifyNeighborsRespectDebug(currentPos, Blocks.BED, false);
        world.notifyNeighborsRespectDebug(blockPos, blockState.getBlock(), false);
    }

    public static IBlockState replaceWithTCBlockState(IBlockState vanillaBlockState) {
        Block vanillaBlock = vanillaBlockState.getBlock();
        IBlockState tcBlockState = vanillaBlockState;
        if (vanillaBlock == Blocks.STONE) {
            tcBlockState = TCBlocks.STONE.getDefaultState().withProperty(TCBlockStone.VARIANT, TCBlockStone.EnumType.byMetadata(vanillaBlockState.getValue(BlockStone.VARIANT).getMetadata()));
        } else if (vanillaBlock == Blocks.WOOL) {
            tcBlockState = TCBlocks.WOOL.getDefaultState().withProperty(TCBlockColored.COLOR, EnumDyeColor.byMetadata(vanillaBlockState.getValue(BlockColored.COLOR).getMetadata()));
        } else if (vanillaBlock == Blocks.PLANKS) {
            tcBlockState = TCBlocks.PLANKS.getDefaultState().withProperty(TCBlockPlanks.VARIANT, TCBlockPlanks.EnumType.byMetadata(vanillaBlockState.getValue(BlockPlanks.VARIANT).getMetadata()));
        } else if (vanillaBlock == Blocks.LOG) {
            tcBlockState = TCBlocks.LOG.getDefaultState().withProperty(TCBlockOldLog.VARIANT, TCBlockPlanks.EnumType.byMetadata(vanillaBlockState.getValue(BlockOldLog.VARIANT).getMetadata()));
        } else if (vanillaBlock == Blocks.LOG2) {
            tcBlockState = TCBlocks.LOG2.getDefaultState().withProperty(TCBlockNewLog.VARIANT, TCBlockPlanks.EnumType.byMetadata(vanillaBlockState.getValue(BlockNewLog.VARIANT).getMetadata()));
        } else if (vanillaBlock == Blocks.COBBLESTONE) {
            tcBlockState = TCBlocks.COBBLESTONE.getDefaultState();
        } else if (vanillaBlock == Blocks.MOSSY_COBBLESTONE) {
            tcBlockState = TCBlocks.MOSSY_COBBLESTONE.getDefaultState();
        } else if (vanillaBlock == Blocks.STONEBRICK) {
            tcBlockState = TCBlocks.STONEBRICK.getDefaultState()
                    .withProperty(TCBlockStoneBrick.VARIANT, TCBlockStoneBrick.EnumType.byMetadata(vanillaBlockState.getValue(BlockStoneBrick.VARIANT).getMetadata()));
        } else if (vanillaBlock == Blocks.BRICK_BLOCK) {
            tcBlockState = TCBlocks.BRICK_BLOCK.getDefaultState();
        } else if (vanillaBlock == Blocks.SANDSTONE) {
            tcBlockState = TCBlocks.SANDSTONE.getDefaultState().withProperty(TCBlockSandStone.TYPE, TCBlockSandStone.EnumType.byMetadata(vanillaBlockState.getValue(BlockSandStone.TYPE).getMetadata()));
        }
        return tcBlockState;
    }

    /**
     * Checks if block's neighbors are instance of TCBlock (or it's children)
     *
     * @param world world instance
     * @param pos   position of the block
     *
     * @return true if neighbor block is instance of TCBlock
     */
    public static boolean isTCBlockNeighbor(World world, BlockPos pos) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 1; y++) {
                    BlockPos nextPos = new BlockPos(x, y, z).add(pos);
                    if (!nextPos.equals(pos) && (world.getBlockState(nextPos).getBlock() instanceof TCBlock)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Spawns or enqueue a block for spawning
     */
    public static void spawn(BlockData blockData, World world) {
        if (blockData.getBlockState().getBlock() != Blocks.BED) {
            world.setBlockState(blockData.getPos(), blockData.getBlockState(), blockData.getFlags());
            if (blockData.getBlockState().getBlock() instanceof TCBlock) {
                setBlockTileData(blockData, world);
            }
        }
    }

    public static void destroy(BlockData blockData, World world) {
        world.setBlockState(blockData.getPos(), Blocks.AIR.getDefaultState(), 3);
    }

    public static void setBlockTileData(BlockData blockData, World world) {
        if (blockData.getTweet() == null) {
            return;
        }
        TileEntity ent = world.getTileEntity(blockData.getPos());
        if (ent instanceof TileEntityTwitter && blockData.getTweet().getID() > 0) {
            ((TileEntityTwitter) ent).setTileData(blockData.getTweet().getID(), blockData.getTweet().getFeeling());
        }
    }

    public static void spawn(List<BlockData> blocksToBuildLastForBuildings, World world) {
        blocksToBuildLastForBuildings.forEach(blockData -> spawn(blockData, world));
    }
}

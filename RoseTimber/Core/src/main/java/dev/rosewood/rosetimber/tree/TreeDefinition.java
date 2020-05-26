package dev.rosewood.rosetimber.tree;

import dev.rosewood.rosetimber.tree.loot.TreeLoot;
import dev.rosewood.rosetimber.tree.loot.TreeLootEntry;
import dev.rosewood.rosetimber.tree.loot.TreeLootPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TreeDefinition {

    private final String key;
    private final List<Material> logBlockTypes, leafBlockTypes, plantableSoilBlockTypes;
    private final Material saplingBlockType;
    private final double maxLogDistanceFromTrunk;
    private final double maxLeafDistanceFromLog;
    private final boolean detectLeavesDiagonally;
    private final boolean dropOriginalLog, dropOriginalLeaf;
    private final TreeLoot logLoot, leafLoot, entireTreeLoot;
    private final List<ItemStack> requiredTools;

    public TreeDefinition(String key, List<Material> logBlockTypes, List<Material> leafBlockTypes, Material saplingBlockTypes,
                          List<Material> plantableSoilBlockTypes, double maxLogDistanceFromTrunk, double maxLeafDistanceFromLog,
                          boolean detectLeavesDiagonally, boolean dropOriginalLog, boolean dropOriginalLeaf, TreeLoot logLoot,
                          TreeLoot leafLoot, TreeLoot entireTreeLoot, List<ItemStack> requiredTools) {
        this.key = key;
        this.logBlockTypes = logBlockTypes;
        this.leafBlockTypes = leafBlockTypes;
        this.saplingBlockType = saplingBlockTypes;
        this.plantableSoilBlockTypes = plantableSoilBlockTypes;
        this.maxLogDistanceFromTrunk = maxLogDistanceFromTrunk;
        this.maxLeafDistanceFromLog = maxLeafDistanceFromLog;
        this.detectLeavesDiagonally = detectLeavesDiagonally;
        this.dropOriginalLog = dropOriginalLog;
        this.dropOriginalLeaf = dropOriginalLeaf;
        this.logLoot = logLoot;
        this.leafLoot = leafLoot;
        this.entireTreeLoot = entireTreeLoot;
        this.requiredTools = requiredTools;
    }

    /**
     * Gets the key of this TreeDefinition in the config
     *
     * @return The key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Gets a list of valid log block data for this TreeDefinition
     *
     * @return A List of Material
     */
    public List<Material> getLogBlockTypes() {
        return Collections.unmodifiableList(this.logBlockTypes);
    }

    /**
     * Gets a list of valid leaf block data for this TreeDefinition
     *
     * @return A List of Material
     */
    public List<Material> getLeafBlockTypes() {
        return Collections.unmodifiableList(this.leafBlockTypes);
    }

    /**
     * Gets the sapling block data of this TreeDefinition
     *
     * @return A Material type for the sapling
     */
    public Material getSaplingBlockType() {
        return this.saplingBlockType;
    }

    /**
     * Gets a list of plantable soil block data for this TreeDefinition
     *
     * @return A List of Material
     */
    public List<Material> getPlantableSoilBlockTypes() {
        return Collections.unmodifiableList(this.plantableSoilBlockTypes);
    }

    /**
     * Gets the max distance away a log can be from the tree trunk in order to be part of the tree
     *
     * @return The max distance a log can be from the tree trunk
     */
    public double getMaxLogDistanceFromTrunk() {
        return this.maxLogDistanceFromTrunk;
    }

    /**
     * Gets the max distance away a leaf can be from a log in order to be part of the tree
     *
     * @return The max distance a leaf can be from a log
     */
    public double getMaxLeafDistanceFromLog() {
        return this.maxLeafDistanceFromLog;
    }

    /**
     * Gets if tree detection should check for leaves diagonally
     *
     * @return True if leaves should be searched for diagonally, otherwise false
     */
    public boolean shouldDetectLeavesDiagonally() {
        return this.detectLeavesDiagonally;
    }

    /**
     * Gets if the logs of this tree should drop their original block
     *
     * @return True if the original log block should be dropped, otherwise false
     */
    public boolean shouldDropOriginalLog() {
        return this.dropOriginalLog;
    }

    /**
     * Gets if the leaves of this tree should drop their original block
     *
     * @return True if the original leaf block should be dropped, otherwise false
     */
    public boolean shouldDropOriginalLeaf() {
        return this.dropOriginalLeaf;
    }

    /**
     * @return A TreeLoot entry for the log loot
     */
    public TreeLoot getLogLoot() {
        return this.logLoot;
    }

    /**
     * @return a TreeLoot entry for the leaf loot
     */
    public TreeLoot getLeafLoot() {
        return this.leafLoot;
    }

    /**
     * @return a TreeLoot entry for the entire tree loot
     */
    public TreeLoot getEntireTreeLoot() {
        return this.entireTreeLoot;
    }

    /**
     * Gets the tools that can be used to activate this tree topple
     *
     * @return A List of ItemStacks
     */
    public List<ItemStack> getRequiredTools() {
        return Collections.unmodifiableList(this.requiredTools);
    }

    /**
     * @return a List of default TreeDefinitions
     */
    public static List<TreeDefinition> getDefaultTreeDefinitions() {
        TreeDefinition oak = new TreeDefinition(
                "oak",
                Arrays.asList(Material.OAK_LOG, Material.STRIPPED_OAK_LOG, Material.OAK_WOOD, Material.STRIPPED_OAK_WOOD),
                Collections.singletonList(Material.OAK_LEAVES),
                Material.OAK_SAPLING,
                new ArrayList<>(),
                6,
                6,
                false,
                true,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(5, new ItemStack(Material.OAK_SAPLING), null),
                        new TreeLootEntry(2, new ItemStack(Material.STICK), null, 1, 2),
                        new TreeLootEntry(0.5, new ItemStack(Material.APPLE), null)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition spruce = new TreeDefinition(
                "spruce",
                Arrays.asList(Material.SPRUCE_LOG, Material.STRIPPED_SPRUCE_LOG, Material.SPRUCE_WOOD, Material.STRIPPED_SPRUCE_WOOD),
                Collections.singletonList(Material.SPRUCE_LEAVES),
                Material.SPRUCE_SAPLING,
                new ArrayList<>(),
                2,
                6,
                false,
                true,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(5, new ItemStack(Material.SPRUCE_SAPLING), null),
                        new TreeLootEntry(2, new ItemStack(Material.STICK), null, 1, 2)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition birch = new TreeDefinition(
                "birch",
                Arrays.asList(Material.BIRCH_LOG, Material.STRIPPED_BIRCH_LOG, Material.BIRCH_WOOD, Material.STRIPPED_BIRCH_WOOD),
                Collections.singletonList(Material.BIRCH_LEAVES),
                Material.BIRCH_SAPLING,
                new ArrayList<>(),
                1,
                4,
                false,
                true,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(5, new ItemStack(Material.BIRCH_SAPLING), null),
                        new TreeLootEntry(2, new ItemStack(Material.STICK), null, 1, 2)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition jungle = new TreeDefinition(
                "jungle",
                Arrays.asList(Material.JUNGLE_LOG, Material.STRIPPED_JUNGLE_LOG, Material.JUNGLE_WOOD, Material.STRIPPED_JUNGLE_WOOD),
                Collections.singletonList(Material.JUNGLE_LEAVES),
                Material.JUNGLE_SAPLING,
                new ArrayList<>(),
                6,
                6,
                false,
                true,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(2.5, new ItemStack(Material.JUNGLE_SAPLING), null),
                        new TreeLootEntry(2, new ItemStack(Material.STICK), null, 1, 2)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition acacia = new TreeDefinition(
                "acacia",
                Arrays.asList(Material.ACACIA_LOG, Material.STRIPPED_ACACIA_LOG, Material.ACACIA_WOOD, Material.STRIPPED_ACACIA_WOOD),
                Collections.singletonList(Material.ACACIA_LEAVES),
                Material.ACACIA_SAPLING,
                new ArrayList<>(),
                4,
                5,
                false,
                true,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(5, new ItemStack(Material.ACACIA_SAPLING), null),
                        new TreeLootEntry(2, new ItemStack(Material.STICK), null)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition darkOak = new TreeDefinition(
                "dark_oak",
                Arrays.asList(Material.DARK_OAK_LOG, Material.STRIPPED_DARK_OAK_LOG, Material.DARK_OAK_WOOD, Material.STRIPPED_DARK_OAK_WOOD),
                Collections.singletonList(Material.DARK_OAK_LEAVES),
                Material.DARK_OAK_SAPLING,
                new ArrayList<>(),
                3,
                5,
                false,
                true,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(5, new ItemStack(Material.DARK_OAK_SAPLING), null),
                        new TreeLootEntry(2, new ItemStack(Material.STICK), null),
                        new TreeLootEntry(0.5, new ItemStack(Material.APPLE), null)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition brownMushroom = new TreeDefinition(
                "brown_mushroom",
                Collections.singletonList(Material.MUSHROOM_STEM),
                Collections.singletonList(Material.BROWN_MUSHROOM_BLOCK),
                Material.BROWN_MUSHROOM,
                Collections.singletonList(Material.MYCELIUM),
                4,
                4,
                false,
                false,
                false,
                TreeLootPool.empty(),
                new TreeLootPool(
                        new TreeLootEntry(100, new ItemStack(Material.BROWN_MUSHROOM), null, -6, 2)
                ),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        TreeDefinition redMushroom = new TreeDefinition(
                "red_mushroom",
                Collections.singletonList(Material.MUSHROOM_STEM),
                Collections.singletonList(Material.RED_MUSHROOM_BLOCK),
                Material.RED_MUSHROOM,
                Collections.singletonList(Material.MYCELIUM),
                4,
                4,
                true,
                false,
                false,
                TreeLootPool.empty(),
                new TreeLootEntry(100, new ItemStack(Material.RED_MUSHROOM), null, -6, 2),
                TreeLootPool.empty(),
                new ArrayList<>()
        );

        return Arrays.asList(oak, spruce, birch, jungle, acacia, darkOak, brownMushroom, redMushroom);
    }

    /**
     * @return the default plantable soils for all tree definitions
     */
    public static List<Material> getDefaultGlobalPlantableSoils() {
        return Arrays.asList(Material.GRASS_BLOCK, Material.DIRT, Material.COARSE_DIRT, Material.PODZOL);
    }

    /**
     * @return the default log TreeLoot for all tree definitions
     */
    public static TreeLoot getDefaultGlobalLogLoot() {
        return new TreeLootPool(
                new TreeLootEntry(0, new ItemStack(Material.DIAMOND), null),
                new TreeLootEntry(0, null, "eco give %player% 5"),
                new TreeLootEntry(0, new ItemStack(Material.GOLDEN_APPLE), "broadcast %player% found a golden apple in a %type% tree at %xPos% %yPos% %zPos%!")
        );
    }

    /**
     * @return the default leaf TreeLoot for all tree definitions
     */
    public static TreeLoot getDefaultGlobalLeafLoot() {
        return new TreeLootEntry(0.01, new ItemStack(Material.GOLDEN_APPLE), null);
    }

    /**
     * @return the default entire tree loot for all tree definitions
     */
    public static TreeLoot getDefaultGlobalEntireTreeLoot() {
        return new TreeLootEntry(0, new ItemStack(Material.DIAMOND), null);
    }

    /**
     * @return the default required tools for all tree definitions
     */
    public static List<Material> getDefaultGlobalRequiredTools() {
        return Arrays.asList(Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLDEN_AXE, Material.DIAMOND_AXE);
    }

}

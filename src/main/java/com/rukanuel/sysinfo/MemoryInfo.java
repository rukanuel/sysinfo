package com.rukanuel.sysinfo;

/**
 * The {@code MemoryInfo} class provides methods to retrieve information about the memory allocated
 * to the Java Virtual Machine (JVM), including total, free, used, and maximum memory.
 * <p>
 * This class uses the {@link Runtime} class to access JVM memory properties.
 * </p>
 */
public class MemoryInfo {

    /**
     * Returns the total memory currently allocated to the JVM in bytes.
     *
     * @return the total memory allocated to the JVM in bytes.
     */
    public long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    /**
     * Returns the free memory available within the JVM in bytes.
     * This memory is part of the currently allocated memory that has not been used yet.
     *
     * @return the free memory within the JVM in bytes.
     */
    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    /**
     * Returns the maximum memory that can be allocated to the JVM in bytes.
     * This represents the upper limit for memory allocation if the JVM needs more.
     *
     * @return the maximum memory that can be allocated to the JVM in bytes.
     */
    public long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    /**
     * Returns the amount of memory currently in use by the JVM in bytes.
     *
     * @return the memory currently in use by the JVM in bytes.
     */
    public long getUsedMemory() {
        return getTotalMemory() - getFreeMemory();
    }

    /**
     * Returns the percentage of memory currently in use by the JVM.
     *
     * @return the percentage of memory used by the JVM.
     */
    public double getUsedMemoryPercentage() {
        long totalMemory = getTotalMemory();
        return totalMemory == 0 ? 0 : ((double) getUsedMemory() / totalMemory) * 100;
    }

    /**
     * Returns a human-readable formatted string of the specified size in bytes.
     *
     * @param size the size in bytes
     * @return the formatted size in KB, MB, or GB
     */
    public String formatSize(long size) {
        if (size >= 1_073_741_824) {
            return String.format("%.2f GB", size / 1_073_741_824.0);
        } else if (size >= 1_048_576) {
            return String.format("%.2f MB", size / 1_048_576.0);
        } else if (size >= 1024) {
            return String.format("%.2f KB", size / 1024.0);
        } else {
            return size + " bytes";
        }
    }

    /**
     * Provides a summary of the current memory status in a human-readable format.
     *
     * @return a string summarizing total, used, free, and max memory.
     */
    public String getMemoryOverview() {
        return String.format("Total Memory: %s, Used Memory: %s, Free Memory: %s, Max Memory: %s",
                formatSize(getTotalMemory()),
                formatSize(getUsedMemory()),
                formatSize(getFreeMemory()),
                formatSize(getMaxMemory()));
    }

    /**
     * Suggests running garbage collection if the used memory exceeds the specified threshold (in bytes).
     *
     * @param threshold the memory usage threshold in bytes above which to suggest garbage collection
     */
    public void suggestGarbageCollection(long threshold) {
        if (getUsedMemory() > threshold) {
            System.out.println("Warning: Used memory exceeds the threshold. Suggesting garbage collection...");
            System.gc(); // Suggest garbage collection
        }
    }
}

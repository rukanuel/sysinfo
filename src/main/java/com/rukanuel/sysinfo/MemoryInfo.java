package com.rukanuel.sysinfo;

public class MemoryInfo {
    // Method to get the total memory available to the JVM
    public long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    // Method to get the free memory available to the JVM
    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    // Method to get the maximum memory that can be allocated to the JVM
    public long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }
}

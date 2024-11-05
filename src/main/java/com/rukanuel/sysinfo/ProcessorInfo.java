package com.rukanuel.sysinfo;

import java.lang.management.ManagementFactory;

public class ProcessorInfo {
    // Method to get the number of available processors
    public int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    // Method to get the CPU load (Java 8+ required)
    public double getSystemLoadAverage() {
        return ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
    }
}

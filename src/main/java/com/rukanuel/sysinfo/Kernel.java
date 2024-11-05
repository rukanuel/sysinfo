package com.rukanuel.sysinfo;

public class Kernel {
    public static void main(String[] args) {
        System.out.println("System Information:");
        System.out.println("-------------------");

        OSInfo osInfo = new OSInfo();
        System.out.printf("Operating System Name: %s%n", osInfo.getOSName());
        System.out.printf("Operating System Version: %s%n", osInfo.getOSVersion());
        System.out.printf("Is 64-bit OS: %b%n", osInfo.is64BitOS());
        System.out.printf("Operating System Family: %s%n", osInfo.getOSFamily());

        ProcessorInfo processorInfo = new ProcessorInfo();
        System.out.printf("Available Processors: %d%n", processorInfo.getAvailableProcessors());
        System.out.println(processorInfo.getProcessorSummary());

        MemoryInfo memoryInfo = new MemoryInfo();
        System.out.printf("Total Memory: %s%n", memoryInfo.formatSize(memoryInfo.getTotalMemory()));
        System.out.printf("Free Memory: %s%n", memoryInfo.formatSize(memoryInfo.getFreeMemory()));
        System.out.printf("Max Memory: %s%n", memoryInfo.formatSize(memoryInfo.getMaxMemory()));
        System.out.printf("Used Memory: %s%n", memoryInfo.formatSize(memoryInfo.getUsedMemory()));
        System.out.printf("Used Memory Percentage: %.2f%%%n", memoryInfo.getUsedMemoryPercentage());

        FileSystemInfo fileSystemInfo = new FileSystemInfo();
        System.out.printf("Total Disk Space: %s%n", fileSystemInfo.formatSize(fileSystemInfo.getTotalDiskSpace()));
        System.out.printf("Usable Disk Space: %s%n", fileSystemInfo.formatSize(fileSystemInfo.getUsableDiskSpace()));
        System.out.printf("Free Disk Space: %s%n", fileSystemInfo.formatSize(fileSystemInfo.getFreeDiskSpace()));
    }
}

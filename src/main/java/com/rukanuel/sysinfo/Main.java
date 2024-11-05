package com.rukanuel.sysinfo;

public class Main {
    public static void main(String[] args) {
        System.out.println("System Information:");
        System.out.println("-------------------");

        OSInfo osInfo = new OSInfo();
        System.out.printf("Operating System Name: %s%n", osInfo.getOSName());
        System.out.printf("Operating System Version: %s%n", osInfo.getOSVersion());
        System.out.printf("Is 64-bit OS: %b%n", osInfo.is64BitOS());

        ProcessorInfo processorInfo = new ProcessorInfo();
        System.out.printf("Available Processors: %d%n", processorInfo.getAvailableProcessors());

        MemoryInfo memoryInfo = new MemoryInfo();
        System.out.printf("Total Memory (bytes): %d%n", memoryInfo.getTotalMemory());
        System.out.printf("Free Memory (bytes): %d%n", memoryInfo.getFreeMemory());
        System.out.printf("Max Memory (bytes): %d%n", memoryInfo.getMaxMemory());

        FileSystemInfo fileSystemInfo = new FileSystemInfo();
        System.out.printf("Total Disk Space (bytes): %d%n", fileSystemInfo.getTotalDiskSpace());
        System.out.printf("Usable Disk Space (bytes): %d%n", fileSystemInfo.getUsableDiskSpace());
        System.out.printf("Free Disk Space (bytes): %d%n", fileSystemInfo.getFreeDiskSpace());

    }
}

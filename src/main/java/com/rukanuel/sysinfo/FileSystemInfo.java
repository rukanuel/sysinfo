package com.rukanuel.sysinfo;

import java.io.File;

public class FileSystemInfo {
    // Method to get the total disk space
    public long getTotalDiskSpace() {
        return File.listRoots()[0].getTotalSpace(); // Example for first root
    }

    // Method to get the usable disk space
    public long getUsableDiskSpace() {
        return File.listRoots()[0].getUsableSpace(); // Example for first root
    }

    // Method to get the free disk space
    public long getFreeDiskSpace() {
        return File.listRoots()[0].getFreeSpace(); // Example for first root
    }
}

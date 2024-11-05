package com.rukanuel.sysinfo;

import java.io.File;

/**
 * The {@code FileSystemInfo} class provides methods to retrieve information about the file system,
 * including total disk space, usable disk space, and free disk space on the primary root directory.
 * <p>
 * This class utilizes the Java {@link File} class to access system file properties.
 * </p>
 */
public class FileSystemInfo {

    /**
     * Returns the total disk space in bytes for the primary root directory.
     *
     * @return the total disk space available on the primary root directory.
     */
    public long getTotalDiskSpace() {
        return File.listRoots()[0].getTotalSpace(); // Example for first root
    }

    /**
     * Returns the usable disk space in bytes for the primary root directory.
     *
     * @return the usable disk space available on the primary root directory.
     */
    public long getUsableDiskSpace() {
        return File.listRoots()[0].getUsableSpace(); // Example for first root
    }

    /**
     * Returns the free disk space in bytes for the primary root directory.
     *
     * @return the free disk space available on the primary root directory.
     */
    public long getFreeDiskSpace() {
        return File.listRoots()[0].getFreeSpace(); // Example for first root
    }

    /**
     * Formats the given size in bytes into a human-readable string (e.g., KB, MB, GB).
     *
     * @param sizeInBytes the size in bytes to format.
     * @return a human-readable string representation of the size.
     */
    public String formatSize(long sizeInBytes) {
        if (sizeInBytes <= 0) {
            return "0 bytes";
        }
        String[] units = new String[]{"bytes", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        double size = (double) sizeInBytes;

        while (size >= 1024 && unitIndex < units.length - 1) {
            size /= 1024;
            unitIndex++;
        }

        return String.format("%.2f %s", size, units[unitIndex]);
    }
}

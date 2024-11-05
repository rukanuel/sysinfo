package com.rukanuel.sysinfo;

public class OSInfo {
    // Method to get the operating system name
    public String getOSName() {
        return System.getProperty("os.name");
    }

    // Method to get the operating system version
    public String getOSVersion() {
        return System.getProperty("os.version");
    }

    // Method to check if the operating system is 64-bit
    public boolean is64BitOS() {
        String arch = System.getProperty("os.arch");
        return arch.contains("64");
    }
}

package com.rukanuel.sysinfo;

/**
 * The {@code OSInfo} class provides methods to retrieve information about the operating system,
 * including its name, version, architecture, and whether it is a 64-bit operating system.
 * <p>
 * This class utilizes system properties to access information about the OS.
 * </p>
 */
public class OSInfo {

    /**
     * Returns the name of the operating system.
     *
     * @return the operating system name.
     */
    public String getOSName() {
        return System.getProperty("os.name");
    }

    /**
     * Returns the version of the operating system.
     *
     * @return the operating system version.
     */
    public String getOSVersion() {
        return System.getProperty("os.version");
    }

    /**
     * Checks if the operating system is 64-bit.
     *
     * @return {@code true} if the operating system is 64-bit, {@code false} otherwise.
     */
    public boolean is64BitOS() {
        String arch = System.getProperty("os.arch");
        return arch.contains("64");
    }

    /**
     * Returns the architecture of the operating system.
     *
     * @return the operating system architecture (e.g., x86, x64, ARM).
     */
    public String getOSArchitecture() {
        return System.getProperty("os.arch");
    }

    /**
     * Returns a summary of the operating system information in a human-readable format.
     *
     * @return a string containing the OS name, version, architecture, and 64-bit status.
     */
    public String getOSInfo() {
        return String.format("Operating System: %s%nVersion: %s%nArchitecture: %s%nIs 64-bit: %s",
                getOSName(),
                getOSVersion(),
                getOSArchitecture(),
                is64BitOS() ? "Yes" : "No");
    }

    /**
     * Returns the family of the operating system based on its name.
     *
     * @return the operating system family (e.g., Windows, macOS, Linux).
     */
    public String getOSFamily() {
        String osName = getOSName().toLowerCase();
        if (osName.contains("win")) {
            return "Windows";
        } else if (osName.contains("mac")) {
            return "macOS";
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return "Linux";
        } else {
            return "Unknown OS Family";
        }
    }
}

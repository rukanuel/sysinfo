package com.rukanuel.sysinfo;

import java.lang.management.ManagementFactory;

/**
 * The {@code ProcessorInfo} class provides methods to retrieve information about the system's processors,
 * including the number of available processors and system load averages.
 * <p>
 * This class utilizes the {@link ManagementFactory} to access operating system metrics.
 * </p>
 */
public class ProcessorInfo {

    /**
     * Returns the number of available processors to the Java virtual machine.
     *
     * @return the number of available processors.
     */
    public int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Returns the system load average for the last minute.
     * <p>
     * Note: This value may not be available on all operating systems. Returns -1 if the value is not available.
     * </p>
     *
     * @return the system load average for the last minute.
     */
    public double getSystemLoadAverage() {
        return ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
    }

    /**
     * Returns a formatted string with the number of available processors and the current system load average.
     *
     * @return a string summarizing processor availability and load average.
     */
    public String getProcessorSummary() {
        return String.format("Available Processors: %d%nSystem Load Average (Last Minute): %.2f",
                getAvailableProcessors(),
                getSystemLoadAverage());
    }

    /**
     * Calculates the CPU usage percentage over a specified interval.
     *
     * @param intervalMillis the interval in milliseconds to measure CPU usage
     * @return the CPU usage percentage, or -1 if the value cannot be calculated
     */
    public double getCpuUsagePercentage(long intervalMillis) {
        // Measure load average over the specified interval
        double initialLoad = getSystemLoadAverage();
        try {
            Thread.sleep(intervalMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1; // Return -1 on interruption
        }
        double finalLoad = getSystemLoadAverage();

        return (finalLoad - initialLoad) / intervalMillis * 100;
    }
}

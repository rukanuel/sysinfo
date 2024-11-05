# Sysinfo
A system information library for Java 21 and above.

[![](https://jitpack.io/v/rukanuel/sysinfo.svg)](https://jitpack.io/#rukanuel/sysinfo)

## Installation
#### Add the repository to your build file:

For Maven, add the following repository to your ```pom.xml```:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

For Gradle, add the following to your ```build.gradle```:
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

#### Add the dependency:
For Maven, add the following dependency inside the ```<dependencies>``` section of your ```pom.xml```:
```xml
<dependency>
    <groupId>com.rukanuel</groupId>
    <artifactId>sysinfo</artifactId>
    <version>1.0.0</version> <!-- Use the latest version available -->
</dependency>
```

For Gradle, add the following line to the ```dependencies``` section of your ```build.gradle```:
```groovy
implementation 'com.rukanuel:sysinfo:1.0.0' // Use the latest version available
```

#### Refresh your project dependencies:
- In Maven, you can run ```mvn clean install```.
- In Gradle, run ```gradle build``` or refresh your Gradle project in your IDE.

## Notes
- Make sure to check for the latest version of ```sysinfo``` on JitPack and update the version number in your build file accordingly.
- Ensure that your Java version is 21 or higher as specified for compatibility.

### Example usage of the ```FileSystemInfo```
This example demonstrates how to create an instance of the ```FileSystemInfo``` class and call its methods to get total, usable, and free disk space.
```java
package com.example;

import com.rukanuel.sysinfo.FileSystemInfo;

public class Main {
    public static void main(String[] args) {
        // Create an instance of FileSystemInfo
        FileSystemInfo fileSystemInfo = new FileSystemInfo();

        // Get total disk space
        long totalDiskSpace = fileSystemInfo.getTotalDiskSpace();
        System.out.println("Total Disk Space: " + formatBytes(totalDiskSpace));

        // Get usable disk space
        long usableDiskSpace = fileSystemInfo.getUsableDiskSpace();
        System.out.println("Usable Disk Space: " + formatBytes(usableDiskSpace));

        // Get free disk space
        long freeDiskSpace = fileSystemInfo.getFreeDiskSpace();
        System.out.println("Free Disk Space: " + formatBytes(freeDiskSpace));
    }

    // Helper method to format bytes into a more readable format
    private static String formatBytes(long bytes) {
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;

        double convertedValue = bytes;
        while (convertedValue >= 1024 && unitIndex < units.length - 1) {
            convertedValue /= 1024;
            unitIndex++;
        }

        return String.format("%.2f %s", convertedValue, units[unitIndex]);
    }
}
```
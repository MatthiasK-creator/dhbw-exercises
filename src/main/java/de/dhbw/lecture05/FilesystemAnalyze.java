package de.dhbw.lecture05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FilesystemAnalyze {
    static void main() {
        FilesystemAnalyze analyze = new FilesystemAnalyze();
        analyze.findLogs();
    }

    public void findLogs() {
        // Paths.get("")-Parameter ist automatisch die Root-Ebene des Projekts, genau das, was wir brauchen.
        // Standardmäßig werden keinen Links gefolgt, weshalb hier keinerlei Option als Parameter gesetzt wird, um das zu erreichen.
        try (Stream<Path> stream = Files.walk(Paths.get("").toAbsolutePath(), 100)) {
            // Vorsicht 'Path' bietet auch eine 'endsWith' Methode, welches sich auf das Ende Pfads bezieht und nicht der Dateiendung.
            stream.filter(file -> file.getFileName().toString().endsWith(".log"))
                    .forEach(logFile -> {
                        try {
                            BasicFileAttributes fileAttributes = Files.readAttributes(logFile, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
                            System.out.println("Path: " + logFile.toAbsolutePath());
                            System.out.println("Size: " + fileAttributes.size());
                            System.out.println("Last modified: " + fileAttributes.lastModifiedTime());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

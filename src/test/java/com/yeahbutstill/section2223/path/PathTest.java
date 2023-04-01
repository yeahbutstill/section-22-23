package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class PathTest {

    @Test
    void createPath() {
        // NAH SEKARANG PAKENYA INI AJA
        Path path = Path.of("application.properties");

        Assertions.assertEquals("application.properties", path.getFileName().toString());
        Assertions.assertFalse(path.isAbsolute());
    }

    @Test
    void usingFiles() {
        Path path = Path.of("pom.xml");

        Assertions.assertEquals("pom.xml", path.toString());
        Assertions.assertFalse(path.isAbsolute());
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    void fileManipulation() throws IOException {
        Path path = Path.of("file.txt");
        Files.createFile(path);

        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }

    @Test
    void directoryManipulation() throws IOException {
        Path path = Path.of("contoh");
        Files.createDirectory(path);
        Assertions.assertTrue(Files.isDirectory(path));
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }

}

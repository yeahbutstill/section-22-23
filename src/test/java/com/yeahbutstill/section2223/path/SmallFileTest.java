package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class SmallFileTest {

    @Test
    void writeSmallFile() throws IOException {

        Path path = Path.of("small.txt");
        byte[] bytes = "small".getBytes();
        Files.write(path, bytes);
        Assertions.assertTrue(Files.exists(path));

        Path path1 = Path.of("small1.txt");
        Files.writeString(path1, "Hello World");
        Assertions.assertTrue(Files.exists(path1));

    }

    @Test
    void readSmallFile() throws IOException {

        Path path = Path.of("small.txt");
        byte[] bytes = Files.readAllBytes(path);
        String content1 = new String(bytes);
        Assertions.assertEquals("small", content1);

        Path path1 = Path.of("small1.txt");
        String content2 = Files.readString(path1);
        Assertions.assertEquals("Hello World", content2);

    }

}

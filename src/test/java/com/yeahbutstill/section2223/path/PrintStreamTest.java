package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

class PrintStreamTest {

    @Test
    void testConsole() {
        PrintStream stream = System.out;
        stream.println("Hello World");
        Assertions.assertEquals(stream.toString(), stream.toString());
    }

    @Test
    void testPrintStreamFile() {
        Path path = Path.of("print.txt");
        try (OutputStream outputStream = Files.newOutputStream(path);
             PrintStream printStream = new PrintStream(outputStream)) {
            printStream.println("Hello World");
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

}

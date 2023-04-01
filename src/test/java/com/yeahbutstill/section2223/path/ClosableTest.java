package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class ClosableTest {

    @Test
    void closeIO() {
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;

        // JANGAN DIPAKE LAGI
        try {
            inputStream = Files.newInputStream(path);
            // lakukan apapun dengan input stream
        } catch (IOException ioException) {
            Assertions.fail("Error: " + ioException.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioException) {
                    Assertions.fail("Error: " + ioException.getMessage());
                }
            }
        }
    }

    @Test
    void closeIOWithTryResource() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path)) {
            // lakukan apapun dengan input stream
        } catch (IOException ioException) {
            Assertions.fail("Error: " + ioException.getMessage());
        }
    }

}

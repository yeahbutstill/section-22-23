package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

class InputStreamTest {

    private static final Logger LOGGER = Logger.getLogger(InputStreamTest.class.getName());

    @Test
    void read() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int data;
            while ((data = inputStream.read()) != -1) {
                stringBuilder.append((char) data);
            }
            LOGGER.info("ISI DI DATA INI: " + stringBuilder.toString());
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void readByte() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            byte[] bytes = new byte[1300];
            int length;
            int count = 0;
            while ((length = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, length));
                count++;
            }
            LOGGER.info("ISI DI DATA INI: " + stringBuilder.toString());
            LOGGER.info("JUMLAH PERULANGAN: " + count);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }

}

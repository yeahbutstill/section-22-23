package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.logging.Logger;

class MemoryStreamTest {

    private static final Logger LOGGER = Logger.getLogger(MemoryStreamTest.class.getName());

    @Test
    void testMemoryStream() {
        StringWriter writer = new StringWriter();
        for (int i = 0; i < 10; i++) {
            writer.write("Hello World\n");
        }

        String content = writer.getBuffer().toString();
        Assertions.assertTrue(content.contains("Hello World"));
        LOGGER.info(content);
    }

}

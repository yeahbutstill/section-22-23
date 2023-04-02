package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

class WriterTest {

    @Test
    void testWriter() {

        Path path = Path.of("writer.txt");
        try(Writer stream = Files.newBufferedWriter(path)) {
            for(int i = 0; i < 100; i++) {
                stream.write("Hello World\n");
                stream.flush();
            }
        } catch(IOException ioException) {
            Assertions.fail(ioException);
        }
    }

}

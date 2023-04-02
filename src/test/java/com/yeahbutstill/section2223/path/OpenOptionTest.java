package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class OpenOptionTest {

    @Test
    void appendWithOpenOption() {
        Path path = Path.of("append.txt");
        try(Writer stream = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            stream.write("Hello World\n");
            stream.flush();
        } catch(IOException exception) {
            Assertions.fail(exception);
        }
    }

}

package com.yeahbutstill.section2223.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

class ReaderTest {

    @Test
    void read() {

        Path path = Path.of("output.txt");
        try(Reader reader = Files.newBufferedReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int data;
            int count = 0;
            while ((data = reader.read()) != -1) {
                stringBuilder.append((char) data);
                count++;
            }
            System.out.println(stringBuilder);
            System.out.println(count);
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    void readChars() {

        Path path = Path.of("output.txt");
        try(Reader reader = Files.newBufferedReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = new char[1300];
            int length;
            int count = 0;
            while ((length = reader.read(chars)) != -1) {
                stringBuilder.append(chars, 0, length);
                count++;
            }
            System.out.println(stringBuilder);
            System.out.println(count);
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }

    }

}

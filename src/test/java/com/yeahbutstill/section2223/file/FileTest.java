package com.yeahbutstill.section2223.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class FileTest {

    @Test
    void createRelativeFIle() {
        // JANGAN DIPAKE LAGI
        File file = new File("test.txt");

        Assertions.assertEquals("test.txt", file.getName());
        Assertions.assertFalse(file.exists());
    }

    @Test
    void createAbsoluteFIle() {
        // JANGAN DIPAKE LAGI
        File file = new File("/home/yeahbutstill/IdeaProjects/section-2223/src/test/resources/test.txt");

        Assertions.assertEquals("/home/yeahbutstill/IdeaProjects/section-2223/src/test/resources/test.txt", file.getAbsoluteFile().getPath());
        Assertions.assertTrue(file.exists());
    }

}

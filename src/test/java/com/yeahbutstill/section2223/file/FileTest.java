package com.yeahbutstill.section2223.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;


class FileTest {

    @Test
    void createRelativeFIle() {
        // JANGAN DIPAKE LAGI
        File file = new File("application.properties");

        Assertions.assertEquals("application.properties", file.getName());
        Assertions.assertFalse(file.exists());
    }

    @Test
    void createAbsoluteFIle() {
        // JANGAN DIPAKE LAGI
        File file = new File("/home/yeahbutstill/IdeaProjects/section-2223/src/main/resources/application.properties");

        Assertions.assertEquals("application.properties", file.getName());
        Assertions.assertEquals("/home/yeahbutstill/IdeaProjects/section-2223/src/main/resources/application.properties", file.getAbsolutePath());
    }

}

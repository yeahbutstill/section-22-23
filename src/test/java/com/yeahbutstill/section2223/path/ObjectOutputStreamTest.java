package com.yeahbutstill.section2223.path;

import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

class ObjectOutputStreamTest {

    @Test
    void savePerson() {

        Person p1 = new Person();
        p1.setId(1L);
        p1.setName("Dani");
        p1.setAddress("Depok");
        Path path = Path.of("dani.person");

        try (OutputStream stream = Files.newOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {
            objectOutputStream.writeObject(p1);
            objectOutputStream.flush();
        } catch (IOException ioException) {
            Assertions.fail(ioException);
        }

    }

    @Test
    void getPerson() {
        Path path = Path.of("dani.person");
        try (InputStream stream = Files.newInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(stream)) {
            Person p1 = (Person) objectInputStream.readObject();
            Assertions.assertEquals(1L, p1.getId());
            Assertions.assertEquals("Dani", p1.getName());
            Assertions.assertEquals("Depok", p1.getAddress());

        } catch (IOException | ClassNotFoundException exception) {
            Assertions.fail(exception);
        }
    }

}

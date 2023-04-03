package com.yeahbutstill.section2223.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeahbutstill.section2223.domain.dao.Address;
import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

class ObjectMapperTest {

    private static final Logger LOGGER = Logger.getLogger(ObjectMapperTest.class.getName());

    @Test
    void testCreateObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        Assertions.assertNotNull(objectMapper);
    }

    @Test
    void testCreateJSON() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "name", "John",
                "age", 30,
                "address", Map.of(
                        "street", "123 Main Street",
                        "city", "New York"
                ),
                "merried", true
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(json);
        LOGGER.info(json);
    }

    // JSON Object
    @Test
    void testReadJSON() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = """
                {
                  "name": "John",
                  "age": 30,
                  "address": {
                    "street": "123 Main Street",
                    "city": "New York"
                  },
                  "merried": true
                }
                """;
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<>() {
        });
        Assertions.assertNotNull(person);
        Assertions.assertEquals("John", person.get("name"));
        Assertions.assertEquals(30, person.get("age"));
        Assertions.assertEquals("{street=123 Main Street, city=New York}", person.get("address").toString());
    }

    //JSON Array
    @Test
    void testCreateJSONArray() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> hobbies = List.of("Reading", "Coding", "Cooking");
        Map<String, Object> person = Map.of(
                "name", "John",
                "age", 30,
                "hobbies", hobbies
        );
        String jsonPerson = objectMapper.writeValueAsString(person);
        String jsonHobbies = objectMapper.writeValueAsString(hobbies);
        Assertions.assertNotNull(jsonHobbies);
        LOGGER.info(jsonHobbies);
        Assertions.assertNotNull(jsonPerson);
        LOGGER.info(jsonPerson);
    }

    @Test
    void testReadJSONArray() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = """
                [
                  "Reading",
                  "Coding",
                  "Cooking"
                ]
                """;
        List<String> hobbies = objectMapper.readValue(json, new TypeReference<>() {
        });
        Assertions.assertNotNull(hobbies);
        Assertions.assertEquals(List.of("Reading", "Coding", "Cooking"), hobbies);
    }

    @Test
    void testCreateJsonFromObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.setId(1L);
        person.setName("Dani");
        person.setHobbies(List.of("Reading", "Coding", "Cooking"));

        Address address = new Address();
        address.setCity("New York");
        address.setStreet("123 Main Street");
        address.setCountry("USA");
        person.setAddress(address);

        String json = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(json);
        LOGGER.info(json);
    }

}

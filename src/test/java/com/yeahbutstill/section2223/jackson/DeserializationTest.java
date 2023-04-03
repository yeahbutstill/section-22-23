package com.yeahbutstill.section2223.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DeserializationTest {

    @Test
    void testDeserialization() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String json = """
                {
                    "id": 1,
                    "name": "John",
                    "address": {
                        "street": "123 Main Street",
                        "city": "New York"
                    },
                    "hobbies": "Coding",
                    "merried": true,
                    "children": [
                        {
                            "name": "Mary"
                        }
                    ]
                }
                """;

        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertNotNull(person);
        Assertions.assertEquals(1L, person.getId());
        Assertions.assertEquals("John", person.getName());
        Assertions.assertEquals("123 Main Street", person.getAddress().getStreet());
        Assertions.assertEquals("New York", person.getAddress().getCity());
        Assertions.assertEquals(List.of("Coding"), person.getHobbies());
    }

}

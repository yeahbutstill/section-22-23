package com.yeahbutstill.section2223.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapperFeatureTest {

    @Test
    void testMapperFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        String json = """
                {
                    "ID": 1,
                    "firstName": "John"
                }
                """;

        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertNotNull(person);
        Assertions.assertEquals(1L, person.getId());
        Assertions.assertEquals("John", person.getFirstName());
    }

}

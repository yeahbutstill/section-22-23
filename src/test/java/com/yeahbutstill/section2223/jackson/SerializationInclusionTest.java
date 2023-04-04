package com.yeahbutstill.section2223.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class SerializationInclusionTest {

    private static final Logger LOGGER = Logger.getLogger(SerializationInclusionTest.class.getName());

    @Test
    void testSerializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");

        String json = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(json);
        LOGGER.info(json);
    }

}

package com.yeahbutstill.section2223.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

class JacksonAnnotationTest {

    private static final Logger logger = Logger.getLogger(JacksonAnnotationTest.class.getName());

    @Test
    void annotationTest() throws JsonProcessingException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setFullName("John Doe");
        person.setPassword("passwordSangatRahasia");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(json);
        logger.info(json);

    }

}

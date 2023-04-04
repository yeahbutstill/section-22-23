package com.yeahbutstill.section2223.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yeahbutstill.section2223.domain.dao.Address;
import com.yeahbutstill.section2223.domain.dao.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

class DateTimeTest {

    private static final Logger LOGGER = Logger.getLogger(DateTimeTest.class.getName());

    @Test
    void testDateTimeInMilis() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Dani");
        person.setLastName("Setiawan");
        person.setFullName("Dani Setiawan");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(json);
        LOGGER.info(json);

    }

    @Test
    void testDateTimeNonMilis() throws JsonProcessingException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper().
                configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(simpleDateFormat);

        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Dani");
        person.setLastName("Setiawan");
        person.setFullName("Dani Setiawan");
        Address address = new Address();
        address.setStreet("123 Main Street");
        address.setCity("New York");
        address.setCountry("NY");
        person.setAddress(address);
        person.setHobbies(List.of("Reading", "Coding"));
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(json);
        LOGGER.info(json);
    }

}

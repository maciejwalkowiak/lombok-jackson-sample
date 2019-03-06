package com.maciejwalkowiak.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonSerializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void serializesToJson() throws JsonProcessingException {
        Person person = Person.builder()
                              .firstName("John")
                              .lastName("Doe")
                              .age(44)
                              .build();

        String json = objectMapper.writeValueAsString(person);

        assertEquals("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":44}",
                     json);
    }

    @Test
    public void deserializesFromJson() throws IOException {
        String json = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":44}";

        Person person = objectMapper.readValue(json, Person.class);

        assertEquals(new Person("John", "Doe", 44), person);
    }

}

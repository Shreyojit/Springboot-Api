package com.sdas.databse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdas.databse.domain.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JacksonTest {

    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book =
                Book.builder()
                        .isbn("978-0-13-478627-5")
                        .title("The Enigma of Eternity")
                        .author("Aria Montgomery")
                        .yearPublished("2005")
                        .build();



        String result = objectMapper.writeValueAsString(book);
        assertThat(result)
                .isEqualTo(
                        "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria"
                                + " Montgomery\",\"year\":\"2005\"}");

    }
    }


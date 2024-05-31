//package com.sdas.databse;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sdas.databse.domain.entities.BookEntity;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//public class JacksonTest {
//
//    @Test
//    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        BookEntity bookEntity =
//                BookEntity.builder()
//                        .isbn("978-0-13-478627-5")
//                        .title("The Enigma of Eternity")
//                        .author("Aria Montgomery")
//                        .yearPublished("2005")
//                        .build();
//
//
//
//        String result = objectMapper.writeValueAsString(bookEntity);
//        assertThat(result)
//                .isEqualTo(
//                        "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria"
//                                + " Montgomery\",\"year\":\"2005\"}");
//
//    }
//
//    @Test
//    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject()
//            throws JsonProcessingException {
//        BookEntity bookEntity =
//                BookEntity.builder()
//                        .isbn("978-0-13-478627-5")
//                        .title("The Enigma of Eternity")
//                        .author("Aria Montgomery")
//                        .yearPublished("2005")
//                        .build();
//        String json =
//                "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of"
//                        + " Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}";
//
//        final ObjectMapper objectMapper = new ObjectMapper();
//
//        BookEntity result = objectMapper.readValue(json, BookEntity.class);
//        assertThat(result).isEqualTo(bookEntity);
//    }
//    }
//

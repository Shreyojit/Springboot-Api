package com.sdas.databse.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdas.databse.TestDataUtil;
import com.sdas.databse.domain.dto.AuthorDto;
import com.sdas.databse.domain.entities.AuthorEntity;
import com.sdas.databse.services.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTests {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testThatCreateAuthorSuccessfullyReturnsHttp201Created() throws Exception {
        AuthorEntity testAuthorA = TestDataUtil.createTestAuthorEntityA();
        testAuthorA.setId(null);

        String authorJson = objectMapper.writeValueAsString(testAuthorA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }
        @Test
        public void testThatCreateAuthorSuccessfullyReturnsSavedAuthor() throws Exception {
            AuthorDto testAuthorA = TestDataUtil.createTestAuthorDtoA();
            testAuthorA.setId(null);
            String authorJson = objectMapper.writeValueAsString(testAuthorA);

            mockMvc.perform(
                    MockMvcRequestBuilders.post("/authors")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(authorJson)
            ).andExpect(
                    MockMvcResultMatchers.jsonPath("$.id").isNumber()
            ).andExpect(
                    MockMvcResultMatchers.jsonPath("$.name").value("Abigail Rose")
            ).andExpect(
                    MockMvcResultMatchers.jsonPath("$.age").value(80)
            );
        }
    }






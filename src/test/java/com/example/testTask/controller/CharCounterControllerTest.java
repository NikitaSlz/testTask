package com.example.testTask.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharCounterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //Тесты на обработку Post запроса
    @Test
    public void charCounterPost_InputValidString_OkStatusReturn() throws Exception {
        String string = "asasas";
        mockMvc.perform(post("/message")
                        .content(string))
                .andExpect(status().isOk());
    }

    @Test
    public void charCounterPost_InputInvalidString_OkStatusReturn() throws Exception {
        String string = "123";
        mockMvc.perform(post("/message")
                        .content(string))
                .andExpect(status().isOk());
    }
}

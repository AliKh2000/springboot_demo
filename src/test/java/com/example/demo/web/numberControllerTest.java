package com.example.demo.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@ActiveProfiles("test")
public class numberControllerTest {
    MockMvc mockMvc;

    @Autowired
    NumberController numberController;

    @BeforeEach
    public void setup() {
        this.mockMvc = standaloneSetup(this.numberController).build();// Standalone context
    }

    @Test
    @DisplayName("Test getRandomNumber")
    void testGetRandomNumber() throws Exception {

        mockMvc.perform(get("/api/number/random").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test getSum success")
    void testGetSumSuccess() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/number/sum?num_1=2&num_2=3")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());
        assertEquals(response.getContentAsString(), "5");
    }

    @Test
    @DisplayName("Test getMul success")
    void testGetMulSuccess() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/number/mul?num_1=2&num_2=3")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());
        assertEquals(response.getContentAsString(), "6");
    }
}

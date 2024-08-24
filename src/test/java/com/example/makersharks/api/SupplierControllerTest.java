package com.example.makersharks.api;

import com.example.makersharks.model.SCALE;
import com.example.makersharks.model.SERVICE;
import com.example.makersharks.model.Supplier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test1_add_controller_should_success() throws Exception {
        Supplier supplier = new Supplier("Test company", "www.test.com", "India", SCALE.small, SERVICE.casting);

        mockMvc.perform(
                post("/api/supplier")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(supplier)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test2_get_suppliers_should_success() throws Exception {
        mockMvc.perform(get("/api/supplier"))
                .andExpect(status().isOk());
    }

    @Test
    public void test3_post_suppliers_filter_should_success() throws Exception {
        mockMvc.perform(post("/api/supplier/query")
                .contentType("application/json")
                .queryParam("location", "India"))
                .andExpect(status().isOk());
    }
}
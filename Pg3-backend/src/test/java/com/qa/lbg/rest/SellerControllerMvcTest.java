package com.qa.lbg.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.lbg.entities.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:seller-schema.sql","classpath:seller-data.sql"})
@ActiveProfiles(profiles="test")
public class SellerControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateSeller() throws Exception {

        Seller newSeller = new Seller(null, "Kier", "Starmer");
        String newSellerAsJson = this.mapper.writeValueAsString(newSeller);
        RequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/sellers/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newSellerAsJson);
        Seller createdSeller = new Seller(2, "Kier", "Starmer");
        String createdSellerAsJson = this.mapper.writeValueAsString(createdSeller);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdSellerAsJson);
        this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
    }
        @Test
        void testGetAllSeller() throws Exception {

            RequestBuilder mockRequest = MockMvcRequestBuilders.get("/sellers/getAll");
            ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
            Seller existing = new Seller (1, "Rishi","Sunak");
            List<Seller> existings = new ArrayList<>();
            existings.add(existing);
            String existingsAsJSON = this.mapper.writeValueAsString(existings);
            ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingsAsJSON);
            this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
        }
}


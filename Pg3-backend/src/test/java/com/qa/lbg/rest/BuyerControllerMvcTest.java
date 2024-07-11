package com.qa.lbg.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.lbg.entities.Buyer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:buyer-schema.sql","classpath:buyer-data.sql"})
@ActiveProfiles(profiles="test")
public class BuyerControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateBuyer() throws Exception {

        Buyer newBuyer = new Buyer(null, "Kier", "Starmer");
        String newBuyerAsJson = this.mapper.writeValueAsString(newBuyer);
        RequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/buyers/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newBuyerAsJson);
        Buyer createdBuyer = new Buyer(2, "Kier", "Starmer");
        String createdBuyerAsJson = this.mapper.writeValueAsString(createdBuyer);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdBuyerAsJson);
        this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
    }
        @Test
        void testGetAllBuyer() throws Exception {

            RequestBuilder mockRequest = MockMvcRequestBuilders.get("/buyers/getAll");
            ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
            Buyer existing = new Buyer (1, "Rishi","Sunak");
            List<Buyer> existings = new ArrayList<>();
            existings.add(existing);
            String existingsAsJSON = this.mapper.writeValueAsString(existings);
            ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingsAsJSON);
            this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
        }
}


package com.qa.lbg.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.lbg.entities.Properties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
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
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:properties-schema.sql","classpath:properties-data.sql"})
@ActiveProfiles(profiles="test")
public class PropertiesControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateProperties() throws Exception {

        Properties newProperty = new Properties(null, "Flat", "London", 4, 2, 200000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");
        String newPropertyAsJson = this.mapper.writeValueAsString(newProperty);
        RequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/properties/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPropertyAsJson);
        Properties createdProperty = new Properties(2, "Flat", "London", 4, 2, 200000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");
        String createdPropertyAsJson = this.mapper.writeValueAsString(createdProperty);
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdPropertyAsJson);
        this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
    }
        @Test
        void testGetAllProperties() throws Exception {

            RequestBuilder mockRequest = MockMvcRequestBuilders.get("/properties/getAll");
            ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
            Properties existing = new Properties (1, "Flat", "Manchester", 4, 2, 200000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");
            List<Properties> existings = new ArrayList<>();
            existings.add(existing);
            String existingsAsJSON = this.mapper.writeValueAsString(existings);
            ResultMatcher checkBody = MockMvcResultMatchers.content().json(existingsAsJSON);
            this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
        }
}


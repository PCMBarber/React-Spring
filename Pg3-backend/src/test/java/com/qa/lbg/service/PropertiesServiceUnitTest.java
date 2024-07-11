package com.qa.lbg.service;

import com.qa.lbg.entities.Buyer;
import com.qa.lbg.entities.Properties;
import com.qa.lbg.repos.BuyerRepo;
import com.qa.lbg.repos.PropertiesRepo;
import com.qa.lbg.services.BuyerService;
import com.qa.lbg.services.PropertiesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PropertiesServiceUnitTest {

    @Autowired
    private PropertiesService service;

    @MockBean
    private PropertiesRepo repo;

    @Test
    void testCreateProperties() {
        Properties newProperties = new Properties(1, "Flat", "London", 4, 2, 700000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");
        Properties savedProperties = new Properties(1, "Flat", "London", 4, 2, 700000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");

        when(this.repo.save(newProperties)).thenReturn(savedProperties);

        assertEquals(savedProperties, this.service.createProperties(newProperties));

    }
    @Test
    void testGetAllProperties() {
        Properties Properties1 = new Properties(1, "Flat", "London", 4, 2, 700000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");
        Properties Properties2 = new Properties(2, "Terraced", "Manchester", 3, 2, 200000, "https://t4.ftcdn.net/jpg/02/79/95/39/360_F_279953994_TmVqT7CQhWQJRLXev4oFmv8GIZTgJF1d.jpg");

        List<Properties> expectedPropertiess = Arrays.asList(Properties1, Properties2);

        when(repo.findAll()).thenReturn(expectedPropertiess);

        List<Properties> actualPropertiess = service.getAll();

        assertEquals(expectedPropertiess, actualPropertiess);
        verify(repo, times(1)).findAll();

    }
}

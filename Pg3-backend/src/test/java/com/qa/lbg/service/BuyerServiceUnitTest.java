package com.qa.lbg.service;

import com.qa.lbg.entities.Buyer;
import com.qa.lbg.repos.BuyerRepo;
import com.qa.lbg.services.BuyerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BuyerServiceUnitTest {

    @Autowired
    private BuyerService service;

    @MockBean
    private BuyerRepo repo;

    @Test
    void testCreateBuyer() {
        Buyer newBuyer = new Buyer(1, "Bill", "Taylor");
        Buyer savedBuyer = new Buyer(1, "Bill", "Taylor");

        when(this.repo.save(newBuyer)).thenReturn(savedBuyer);

        assertEquals(savedBuyer, this.service.createBuyer(newBuyer));

    }
    @Test
    void testGetAllBuyer() {
        Buyer buyer1 = new Buyer(1, "Bill", "Taylor");
        Buyer buyer2 = new Buyer(2, "James", "Taylor");

        List<Buyer> expectedBuyers = Arrays.asList(buyer1, buyer2);

        when(repo.findAll()).thenReturn(expectedBuyers);

        List<Buyer> actualBuyers = service.getAll();

        assertEquals(expectedBuyers, actualBuyers);
        verify(repo, times(1)).findAll();

    }
}

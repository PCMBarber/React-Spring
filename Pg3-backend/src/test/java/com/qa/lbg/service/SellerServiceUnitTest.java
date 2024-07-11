package com.qa.lbg.service;

import com.qa.lbg.entities.Seller;
import com.qa.lbg.repos.SellerRepo;
import com.qa.lbg.services.SellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SellerServiceUnitTest {

    @Autowired
    private SellerService service;

    @MockBean
    private SellerRepo repo;

    @Test
    void testCreateSeller() {
        Seller newSeller = new Seller(1, "Bill", "Taylor");
        Seller savedSeller = new Seller(1, "Bill", "Taylor");

        when(this.repo.save(newSeller)).thenReturn(savedSeller);

        assertEquals(savedSeller, this.service.createSeller(newSeller));

    }
    @Test
    void testGetAllSeller() {
        Seller Seller1 = new Seller(1, "Bill", "Taylor");
        Seller Seller2 = new Seller(2, "James", "Taylor");

        List<Seller> expectedSellers = Arrays.asList(Seller1, Seller2);

        when(repo.findAll()).thenReturn(expectedSellers);

        List<Seller> actualSellers = service.getAll();

        assertEquals(expectedSellers, actualSellers);
        verify(repo, times(1)).findAll();

    }
}

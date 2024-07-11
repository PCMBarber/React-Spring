package com.qa.lbg.repos;

import com.qa.lbg.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Integer> {
}

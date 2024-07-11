package com.qa.lbg.repos;

import com.qa.lbg.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Integer> {
}

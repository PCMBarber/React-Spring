package com.qa.lbg.services;

import com.qa.lbg.entities.Bookings;
import com.qa.lbg.repos.BookingsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingsService {

    private BookingsRepo repo;

    public BookingsService(BookingsRepo repo) {
        this.repo = repo;
    }

    public List<Bookings> getAll() {
        return this.repo.findAll();
    }

    public Bookings createBookings(Bookings bookings) {
          return this.repo.save(bookings);
    }

//    public Bookings removeBookings(int bookingId) {
//
//        Bookings remove = this.repo.findById(bookingId).get();
//        this.repo.deleteById(bookingId);
//          return remove;
//    }
//
//    public Bookings updateBookings(int bookingId,
//                                Integer propertyId,
//                                Integer buyerId,
//                                LocalDateTime date) {
//
//        Bookings toUpdate = this.repo.findById(bookingId).get();
//
//        if (propertyId != null) toUpdate.setPropertyId(propertyId);
//        if (buyerId != null) toUpdate.setBuyerId(buyerId);
//        if (date != null) toUpdate.setDate(date);
//
//        return this.repo.save(toUpdate);
//    }

}

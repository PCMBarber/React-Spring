package com.qa.lbg.rest;

import com.qa.lbg.entities.Bookings;
import com.qa.lbg.services.BookingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="bookings")
@CrossOrigin
public class BookingsController {

    private BookingsService service;

    public BookingsController(BookingsService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Bookings> getAll() {
        return this.service.getAll();
    }


    @PostMapping("/create")
    public Bookings createBookings(@RequestBody Bookings bookings) {
        return this.service.createBookings(bookings);
    }

//    @DeleteMapping("/remove/{buyerId}")
//    public Buyer removeBuyer(@PathVariable int buyerId) {
//        return this.service.removeBuyer(buyerId);
//    }
//
//    @PatchMapping("/update/{buyerId}")
//    public Buyer updateBuyer(@PathVariable int buyerId,
//                               @RequestParam(required = false) String first,
//                               @RequestParam(required = false) String last) {
//        return this.service.updateBuyer(buyerId, first, last);
//    }

//    @GetMapping("/person/{id}")
//    public ResponseEntity<?> getPerson(@PathVariable Integer id) {
//        if (id == null || id < 0 || id >= this.person.size())
//            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
//        else return ResponseEntity.ok(this.people.get(id));
//    }


}

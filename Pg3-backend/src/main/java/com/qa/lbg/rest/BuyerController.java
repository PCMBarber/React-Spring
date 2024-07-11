package com.qa.lbg.rest;

import com.qa.lbg.entities.Buyer;
import com.qa.lbg.services.BuyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="buyers")
@CrossOrigin
public class BuyerController {

    private BuyerService service;

    public BuyerController(BuyerService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Buyer> getAll() {
        return this.service.getAll();
    }


    @PostMapping("/create")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return this.service.createBuyer(buyer);
    }

    @DeleteMapping("/remove/{buyerId}")
    public Buyer removeBuyer(@PathVariable int buyerId) {
        return this.service.removeBuyer(buyerId);
    }

    @PatchMapping("/update/{buyerId}")
    public Buyer updateBuyer(@PathVariable int buyerId,
                               @RequestParam(required = false) String first,
                               @RequestParam(required = false) String last) {
        return this.service.updateBuyer(buyerId, first, last);
    }

//    @GetMapping("/person/{id}")
//    public ResponseEntity<?> getPerson(@PathVariable Integer id) {
//        if (id == null || id < 0 || id >= this.person.size())
//            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
//        else return ResponseEntity.ok(this.people.get(id));
//    }





}

package com.qa.lbg.rest;

import com.qa.lbg.entities.Seller;
import com.qa.lbg.services.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@CrossOrigin
public class SellerController {

    private SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Seller> getAll() {
        return this.service.getAll();
    }


    @PostMapping("/create")
    public Seller createSeller(@RequestBody Seller seller) {
        return this.service.createSeller(seller);
    }

//    @DeleteMapping("/remove/{sellerId}")
//    public Seller removeSeller(@PathVariable int sellerId) {
//        return this.service.removeSeller(sellerId);
//    }
//
//    @PatchMapping("/update/{sellerId}")
//    public Seller updateSeller(@PathVariable int sellerId,
//                               @RequestParam(required = false) String first,
//                               @RequestParam(required = false) String last) {
//        return this.service.updateSeller(sellerId, first, last);
//    }

//    @GetMapping("/person/{id}")
//    public ResponseEntity<?> getPerson(@PathVariable Integer id) {
//        if (id == null || id < 0 || id >= this.person.size())
//            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
//        else return ResponseEntity.ok(this.people.get(id));
//    }





}

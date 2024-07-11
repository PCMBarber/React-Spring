package com.qa.lbg.services;

import com.qa.lbg.entities.Seller;
import com.qa.lbg.repos.SellerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private SellerRepo repo;

    public SellerService(SellerRepo repo) {
        this.repo = repo;
    }


    public List<Seller> getAll() {
        return this.repo.findAll();
    }

    public Seller createSeller(Seller seller) {
          return this.repo.save(seller);
    }

//    public Seller removeSeller(int sellerId) {
//
//        Seller remove = this.repo.findById(sellerId).get();
//        this.repo.deleteById(sellerId);
//          return remove;
//    }
//
//    public Seller updateSeller(int sellerId,
//                               String first,
//                               String last) {
//
//        Seller toUpdate = this.repo.findById(sellerId).get();
//
//        if (first != null) toUpdate.setFirst(first);
//        if (last != null) toUpdate.setLast(last);
//        return this.repo.save(toUpdate);
//    }



}

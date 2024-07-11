package com.qa.lbg.services;

import com.qa.lbg.entities.Buyer;
import com.qa.lbg.repos.BuyerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    private BuyerRepo repo;

    public BuyerService(BuyerRepo repo) {
        this.repo = repo;
    }


    public List<Buyer> getAll() {
        return this.repo.findAll();
    }

    public Buyer createBuyer(Buyer buyer) {
          return this.repo.save(buyer);
    }

    public Buyer removeBuyer(int buyerId) {

        Buyer remove = this.repo.findById(buyerId).get();
        this.repo.deleteById(buyerId);
          return remove;
    }

    public Buyer updateBuyer(int buyerId,
                               String first,
                               String last) {

        Buyer toUpdate = this.repo.findById(buyerId).get();

        if (first != null) toUpdate.setFirst(first);
        if (last != null) toUpdate.setLast(last);
        return this.repo.save(toUpdate);
    }



}

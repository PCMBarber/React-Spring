package com.qa.lbg.entities;

import jakarta.persistence.*;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellerId;

//    @Column(name = "first_name", nullable = false, unique = true)
    private String first;

    private String last;

    public Seller() {}

    public Seller(Integer sellerId, String first, String last) {
        this.sellerId = sellerId;
        this.first = first;
        this.last = last;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "Seller Id=" + sellerId +
                ", First Name='" + first + '\'' +
                ", Last Name='" + last + '\'' +
                '}';
    }
}

package com.qa.lbg.entities;

import jakarta.persistence.*;

@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer buyerId;

//    @Column(name = "full_name", nullable = false, unique = true)
    private String first;

    private String last;

    public Buyer() {}

    public Buyer(Integer buyerId, String first, String last) {
        this.buyerId = buyerId;
        this.first = first;
        this.last = last;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
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
        return "Buyer{" +
                "Buyer Id=" + buyerId +
                ", First Name='" + first + '\'' +
                ", Last Name ='" + last + '\'' +
                '}';
    }
}

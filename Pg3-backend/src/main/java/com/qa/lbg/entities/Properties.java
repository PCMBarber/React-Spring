package com.qa.lbg.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer propertyId;

    private String type;

    private String location;

    private int bedrooms;

    private int bathrooms;

    private int price;

    private String imageUrl;

    @ManyToOne
    private Seller seller;

    public Properties() {
    }

    public Properties(Integer propertyId, String type, String location, int bedrooms, int bathrooms, int price, String imageUrl) {
        this.propertyId = propertyId;
        this.type = type;
        this.location = location;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Integer getpropertyId() {
        return propertyId;
    }

    public void setpropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


//    public List<Bookings> getBookings() {
//        return bookings;
//    }
//
//    public void setPets(List<Bookings> pets) {
//        this.bookings = bookings;
//    }



}

//package com.qa.lbg.dtos;
//
//import com.qa.lbg.entities.Properties;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PropertyDto {
//
//    private Integer propertyid;
//
//    private int bedrooms;
//
//    private int bathrooms;
//
//    private int price;
//
//    private List<BookingsDto> buyers = new ArrayList<>();
//
//    public PropertyDto(){
//        super();
//    }
//
//    public PropertyDto(Properties properties) {
//        this.propertyid = properties.getpropertyId();
//        this.bedrooms = properties.getBedrooms();
//        this.bathrooms = properties.getBathrooms();
//        this.price = properties.getPrice();
//        if (properties.getBookings() != null) {
//            for (Bookings booking : properties.getBookings()) {
//                this.buyers.add(new BookingsDto(Bookings));
//            }
//        }
//
//    }
//
//    public PropertyDto(Integer propertyid, int bedrooms, int bathrooms, int price) {
//        this.propertyid = propertyid;
//        this.bedrooms = bedrooms;
//        this.bathrooms = bathrooms;
//        this.price = price;
//    }
//
//    public Integer getPropertyid() {
//        return propertyid;
//    }
//
//    public void setPropertyid(Integer propertyid) {
//        this.propertyid = propertyid;
//    }
//
//    public int getBedrooms() {
//        return bedrooms;
//    }
//
//    public void setBedrooms(int bedrooms) {
//        this.bedrooms = bedrooms;
//    }
//
//    public int getBathrooms() {
//        return bathrooms;
//    }
//
//    public void setBathrooms(int bathrooms) {
//        this.bathrooms = bathrooms;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public List<BookingsDto> getBuyers() {
//        return buyers;
//    }
//
//    public void setBuyers(List<BookingsDto> buyers) {
//        this.buyers = buyers;
//    }
//}

package com.example.tourit;

public class RegisterObject {

    String uid, name, phone, noOfPeople, noOfDays,restaurant,date;

    public RegisterObject(String uid, String name, String phone, String noOfPeople, String noOfDays, String restaurant, String date) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.noOfPeople = noOfPeople;
        this.noOfDays = noOfDays;
        this.restaurant = restaurant;
        this.date = date;
    }

    public RegisterObject() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(String noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}


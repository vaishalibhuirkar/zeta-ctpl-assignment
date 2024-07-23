package org.example;

public class Address {
    private int id;
    private String city;
    private String pincode;

    public Address(int id, String city, String pincode) {
        this.id = id;
        this.city = city;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Address{id=" + id + ", city='" + city + "', pincode='" + pincode + "'}";
    }
}

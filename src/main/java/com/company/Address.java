package com.company;

import java.util.Objects;

public class Address {

    private String street;
    private String zip;
    private String city;

    public Address(String street, String zip, String city) {

        this.street = street;
        this.zip = zip;
        this.city = city;

    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                zip.equals(address.zip) &&
                city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, zip, city);
    }
}

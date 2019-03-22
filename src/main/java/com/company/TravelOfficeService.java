package com.company;

import java.time.LocalDate;

public class TravelOfficeService {


    private TravelOffice travelOffice;

    public TravelOfficeService() {
        this.travelOffice = new TravelOffice();
    }


    public Customer addCustomer(String name, String street, String zip, String city) {
        Address address = new Address(street, zip, city);
        Customer customer = new Customer(name);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);
        return customer;
    }

    public Trip addTrip(String destination, LocalDate begDate, LocalDate endDate, int price, String type) {
        return travelOffice.addTrip(destination, trip);
    }

    public void assign(Customer customer, Trip trip) {
        customer.setTrip(trip);
    }

    public Customer getCustomerToAssign(String name) {
        Customer customer;
        try {
            customer = travelOffice.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            System.out.println("brak podanego klienta \n");
            return null;
        }
        return customer;

    }

    public Trip getTripToAssign(String destination) {
        Trip trip = travelOffice.getTrips().get(destination);
        if(trip == null)
            System.out.println("brak takiej wycieczki");
        return trip;
    }



    public boolean removeTrip(String destination) {

        try {
            travelOffice.removeTrip(destination);
        } catch (NoSuchTripException e) {
            System.out.println(e);
            return false;
        }
        return true;

    }

    public boolean removeCustomer(String name) {
        travelOffice.getCustomers().removeIf(c -> c.getName().equals(name));
        return true;
    }

    public void showCustomers() {
        travelOffice.getCustomers().forEach((c -> System.out.println(c)));
    }

    public void showTrips() {
        travelOffice.getTrips().values().forEach((v -> System.out.println(v)));
    }





}


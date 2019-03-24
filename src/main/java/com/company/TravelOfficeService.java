package com.company;

import java.time.LocalDate;

public class TravelOfficeService {


    private TravelOffice travelOffice;



    public TravelOfficeService(TravelOffice travelOffice) {
       // this.travelOffice = new TravelOffice();
        this.travelOffice = travelOffice;
    }



    public Customer addCustomer(String name, String street, String zip, String city) {
        Address address = new Address(street, zip, city);
        Customer customer = new Customer(name);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);

        return customer;
    }

    public Trip addAbroadTrip(LocalDate begDate, LocalDate endDate, String destination, int insurence, int price){
        Trip trip = new AbroadTrip(begDate, endDate, destination);
        trip.setPrice(price);
        System.out.println("ubezpiecznie");
        ((AbroadTrip) trip).setInsurence(insurence);
        travelOffice.addTrip(destination, trip);
        return trip;
    }

    public Trip addDomesticTrip(LocalDate begDate, LocalDate endDate, String destination, int discount, int price){
        Trip trip = new DomesticTrip(begDate, endDate, destination);
        trip.setPrice(price);
        System.out.println("znizka");
        ((DomesticTrip) trip).setOwnArrivalDiscount(discount);
        travelOffice.addTrip(destination, trip);
        return trip;
    }






    public void assign(Customer customer, Trip trip) {
        customer.setTrip(trip);
    }

    public Customer getCustomerToAssign(String name) {
        Customer customer;
        try {
            customer = travelOffice.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            MainHandler.log.warning("Brak podanego klienta: " + name);
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
        return travelOffice.getCustomers().removeIf(c -> c.getName().equals(name));
    }

    public void showCustomers() {
        travelOffice.getCustomers().forEach((c -> System.out.println(c)));
    }

    public void showTrips() {
        travelOffice.getTrips().values().forEach((v -> System.out.println(v)));
    }



}


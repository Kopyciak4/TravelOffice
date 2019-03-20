package com.company;

import java.util.Scanner;

public class MainHandler implements UserInterface {

    private TravelOffice travelOffice;
    private static Scanner sc = null;

    public MainHandler(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }

    @Override
    public Customer addCustomer() {
        System.out.println("nazwa klienta");
        String name = sc.next();

        System.out.println("ulica");
        String street = sc.next();

        System.out.println("kod pocztowy");
        String zip = sc.next();

        System.out.println("miasto");
        String city = sc.next();

        Address address = new Address(street, zip, city);
        Customer customer = new Customer(name);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);

        System.out.println("utworzony" + customer);
        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.println("miejsce wycieczki");
        String destination = sc.next();

        System.out.println("data wylotu");
        String start = sc.next();
        Date begDate = Date.of(start);

        System.out.println("data przylotu");
        String end = sc.next();
        Date endDate = Date.of(end);

        System.out.println("cena");
        int price = sc.nextInt();

        System.out.println("typ wycieczki (L / Z)");
        String type;
        do {
            type =  sc.next().toUpperCase();
        }while(!type.equals("Z") && !type.equals("L"));


        Trip trip = null;
        if (type.startsWith("L")) {
            trip = new DomesticTrip(begDate, endDate, destination);
            trip.setPrice(price);

            System.out.println("znizka");
            int discount = sc.nextInt();
            ((DomesticTrip) trip).setOwnArrivalDiscount(discount);
        } else {
            trip = new AbroadTrip(begDate, endDate, destination);
            trip.setPrice(price);

            System.out.println("ubezpiecznie");
            int insurence = sc.nextInt();
            ((AbroadTrip) trip).setInsurence(insurence);
        }

        travelOffice.addTrip(destination, trip);
        System.out.println(trip);
        return trip;

    }

    @Override
    public void asssign() {
        System.out.println("nazwa klienta");
        String name = sc.next();

        Customer customer = travelOffice.findCustomerByName(name);
        if(customer== null){
            System.out.println("brak podanego klienta \n");
        }

        System.out.println("miejsce wycieczki");
        String destination = sc.next();

        Trip trip = travelOffice.getTrips().get(destination);
        if(trip == null)
            System.out.println("brak takiej wycieczki");

        System.out.println("Wycieczka: " + destination + "przypisana do: " + name);
        customer.setTrip(trip);

    }

    @Override
    public boolean removeTrip() {

        System.out.println("miejsce wycieczki");
        String destination = sc.next();

        return travelOffice.removeTrip(destination);

    }

    @Override
    public boolean removeCustomer() {
        System.out.println("nazwa klienta");
        String name = sc.next();

        return travelOffice.removeCustomer(travelOffice.findCustomerByName(name));
    }

    @Override
    public void showTrips() {
        System.out.println("lista wycieczek");
        for(Trip t : travelOffice.getTrips().values()){
            System.out.println(t);
        }
    }

    @Override
    public void showCustomers() {
        System.out.println("lista klientow");
        for(Customer c: travelOffice.getCustomers()){
            System.out.println(c);
        }

    }
}

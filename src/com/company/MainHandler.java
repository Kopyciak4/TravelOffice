package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainHandler implements UserInterface {

    private TravelOffice travelOffice;
    private static Scanner sc = null;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
        LocalDate begDate = LocalDate.parse(start, format);

        System.out.println("data przylotu");
        String end = sc.next();
        LocalDate endDate = LocalDate.parse(start, format);

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
        Customer customer;
        try {
             customer = travelOffice.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            System.out.println("brak podanego klienta \n");
            return;
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

        try {
            travelOffice.removeTrip(destination);
        } catch (NoSuchTripException e) {
            System.out.println(e);
            return false;
        }

        return true;

    }

    @Override
    public boolean removeCustomer() {
        System.out.println("nazwa klienta");
        String name = sc.next();
//        try {
//            travelOffice.removeCustomer(travelOffice.findCustomerByName(name));
//        } catch (NoSuchCustomerException e) {
//            System.out.println("brak takiego klienta");
//            return false;
//        }
//        return true;

        return travelOffice.getCustomers().removeIf(c -> c.getName().equals(name));

    }

    @Override
    public void showTrips() {
        System.out.println("lista wycieczek");
//        for(Trip t : travelOffice.getTrips().values()){
//            System.out.println(t);
//        }
        travelOffice.getTrips().values().forEach((v -> System.out.println(v)));
    }

    @Override
    public void showCustomers() {
        System.out.println("lista klientow");
//        for(Customer c: travelOffice.getCustomers()){
//            System.out.println(c);
//        }
        travelOffice.getCustomers().forEach((c -> System.out.println(c)));

    }
}

package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainHandler implements UserInterface {

    public static Logger log;
    private TravelOfficeService travelOfficeService;
    private static Scanner sc = null;



    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MainHandler(TravelOfficeService travelOfficeService, Logger log) {
        this.travelOfficeService = travelOfficeService;
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        this.log = log;
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

        System.out.println("utworzony");
        Customer customer = travelOfficeService.addCustomer(name, street, zip, city);
        log.info("Klient" + customer + "zostal dodany");
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
        LocalDate endDate = LocalDate.parse(end, format);

        System.out.println("cena");
        int price = sc.nextInt();

        System.out.println("typ wycieczki (L / Z)");
        String type;
        do {
            type =  sc.next().toUpperCase();
        }while(!type.equals("Z") && !type.equals("L"));

        Trip trip;
        if (type.startsWith("L")) {
            int discount = sc.nextInt();
            trip = travelOfficeService.addDomesticTrip(begDate, endDate, destination, discount, price);
        } else {
            int insurence = sc.nextInt();
            trip = travelOfficeService.addAbroadTrip(begDate, endDate, destination, insurence, price);
        }
        log.fine(trip.toString());
        return trip;

    }

    @Override
    public void assign() {

        System.out.println("nazwa klienta");
        String name = sc.next();
        Customer customer= travelOfficeService.getCustomerToAssign(name);

        System.out.println("miejsce wycieczki");
        String destination = sc.next();
        Trip trip = travelOfficeService.getTripToAssign(destination);


        travelOfficeService.assign(customer,trip);
        System.out.println("Wycieczka: " + destination + "przypisana do: " + name);



    }

    @Override
    public boolean removeTrip() {

        System.out.println("miejsce wycieczki");
        String destination = sc.next();

        return travelOfficeService.removeTrip(destination);

    }

    @Override
    public boolean removeCustomer() {
        System.out.println("nazwa klienta");
        String name = sc.next();


        return travelOfficeService.removeCustomer(name);

    }

    @Override
    public void showTrips() {
        System.out.println("lista wycieczek");


        travelOfficeService.showTrips();
    }

    @Override
    public void showCustomers() {
        System.out.println("lista klientow");

        travelOfficeService.showCustomers();


    }
}

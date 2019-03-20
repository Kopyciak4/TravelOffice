package com.company;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Address address = new Address("Wroclawska","41-902" ,"Bytom");
        Customer customer = new Customer("Grzegorz");

        Customer customer1 = new Customer("Bob");
        Customer customer2 = new Customer("Bob2");
        Customer customer3 = new Customer("Bob3");

        TravelOffice travelOffice = new TravelOffice();
        travelOffice.addCustomer(customer1);
        travelOffice.addCustomer(customer2);
        travelOffice.addCustomer(customer3);


        Trip domesticTrip = new DomesticTrip(new Date(2019, 7, 24), new Date(2019, 8, 25), "Bangladesz");
        Trip abroadTrip = new AbroadTrip(new Date(2019, 8, 9), new Date(2019, 9, 10), "Iran");
        ((DomesticTrip) domesticTrip).setOwnArrivalDiscount(250);
        domesticTrip.setPrice(400);
        abroadTrip.setPrice(400);
        ((AbroadTrip) abroadTrip).setInsurence(350);

        customer1.setTrip(domesticTrip);
        customer2.setTrip(abroadTrip);


        Date date = Date.of("2019-5-11");
        System.out.println(travelOffice.getTrips());

        MainHandler mainHandler = new MainHandler(travelOffice);

        System.out.println("Podaj numer akcji" + "\n" +
        "1. Dodaj klienta" + "\n"
        + "2. Dodaj wycieczke" + "\n"
        + "3. Przypisz wycieczke do klienta" + "\n"
        + "4. Usun klienta" + "\n"
        + "5. Usun wycieczke" + "\n"
        + "6. Pokaz klientow" + "\n"
        + "7. Pokaz wycieczki" + "\n"
        + "8. Wyjdz");
        Scanner sc = new Scanner(System.in);
        int action;
        action = sc.nextInt();
        switch (action) {
            case 1:
                mainHandler.addCustomer();
                break;
            case 2:
                mainHandler.addTrip();
                break;
            case 3:
                mainHandler.asssign();
                break;
            case 4:
                mainHandler.removeCustomer();
                break;
            case 5:
                mainHandler.removeTrip();
                break;
            case 6:
                mainHandler.showCustomers();
                break;
            case 7:
                mainHandler.showTrips();
                break;
            case 8:
                break;
            default:
                System.out.println("zly numer");
                break;

        }

    }
}

package com.company;

public class Test {

    public static void main(String[] args) {

        Address address = new Address("Wroclawska","41-902" ,"Bytom");
        Customer customer = new Customer("Grzegorz");
        Trip trip = new Trip(new Date(2019, 6, 15), new Date(2019, 6, 30), "Uzbekistan");
        trip.setPrice(400);

        customer.setTrip(trip);
        // System.out.println(customer);

        Customer customer1 = new Customer("Bob");
        Customer customer2 = new Customer("Bob2");
        Customer customer3 = new Customer("Bob3");

        TravelOffice travelOffice = new TravelOffice();
        travelOffice.addCustomer(customer1);
        travelOffice.addCustomer(customer2);
        travelOffice.addCustomer(customer3);
        System.out.println(travelOffice.getInfo());

        Trip domesticTrip = new DomesticTrip(new Date(2019, 7, 24), new Date(2019, 8, 25), "Bangladesz");
        Trip abroadTrip = new AbroadTrip(new Date(2019, 8, 9), new Date(2019, 9, 10), "Iran");
        ((DomesticTrip) domesticTrip).setOwnArrivalDiscount(250);
        domesticTrip.setPrice(400);
        abroadTrip.setPrice(400);
        ((AbroadTrip) abroadTrip).setInsurence(350);

        customer1.setTrip(domesticTrip);
        customer2.setTrip(abroadTrip);
        System.out.println(travelOffice.getInfo());

        Date date = Date.of("2019-5-11");
        System.out.println(date);





    }
}

package com.company;

public interface UserInterface {

    Customer addCustomer();

    Trip addTrip();

    void assign();

    boolean removeTrip();

    boolean removeCustomer();

    void showTrips();

    void showCustomers();
}

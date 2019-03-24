package com.company;


import java.util.*;

public class TravelOffice {
    public Set<Customer> customers = new HashSet<>();
    public Map<String, Trip> trips = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTrip(String destination, Trip trip) {
        trips.put(destination, trip);
    }

    public void removeTrip(String destination) throws NoSuchTripException {

        Trip checkTrip =  trips.remove(destination);
        for(Customer c : customers){
            if(c.getTrip().equals(checkTrip)){
                c.setTrip(null);
            }
        }
        if (checkTrip == null) {
            throw new NoSuchTripException("wycieczka nie zostala usunieta");
        }
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException{
        for (Customer c : customers){
            if(c.getName().equals(name)){
                return c;
            }
        }
        throw new NoSuchCustomerException("klent nie zostal usuniety");
    }

    public boolean removeCustomer(Customer customer) {
        return customers.remove(customer);
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }






}

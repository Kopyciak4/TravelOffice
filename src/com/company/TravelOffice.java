package com.company;


import java.util.*;

public class TravelOffice {
   // public static int customerCount = 0;
    public Set<Customer> customers = new HashSet<>();
    public Map<String, Trip> trips = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTrip(String destination, Trip trip) {
        trips.put(destination, trip);
    }

    public boolean removeTrip(String destination) {
       if(trips.containsKey(destination)){
           trips.remove(destination);
           return true;
       }
       return false;
    }

    public Customer findCustomerByName(String name){
        for (Customer c : customers){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public boolean removeCustomer(Customer customer) {
        if(customers.contains(customer)){
            customers.remove(customer);
            return true;
        }
        return false;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }



//    public int getCustomerCount() {
//        return customerCount;
//    }



}

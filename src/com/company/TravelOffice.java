package com.company;

import java.util.Arrays;

public class TravelOffice {
    public static int customerCount = 0;
    public static Customer[] customers = new Customer[2];

    public void addCustomer(Customer customer) {

        if(isCustomersArrayFull()){
            customers = Arrays.copyOf(customers,customerCount + 1);
        }
        customers[customerCount] = customer;
        customerCount++;

    }

    public boolean isCustomersArrayFull() {
        return (customers.length) <= getCustomerCount();
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public String getInfo() {
        String allCustomers = "";
        for(Customer cu : customers){
          allCustomers += cu.toString() + "\n";
        }
        return allCustomers;
    }


}

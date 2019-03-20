package com.company;

public class AbroadTrip extends Trip {

    private int insurence;

    public AbroadTrip(Date start, Date end, String destination) {
       setStart(start);
       setEnd(end);
       setDestination(destination);

    }


    public int getPrice(){
        return super.getPrice() + getInsurence();
    }

    public int getInsurence() {
        return insurence;
    }

    public void setInsurence(int insurence) {
        this.insurence = insurence;
    }
}

package com.company;

public class DomesticTrip extends Trip {

    private int ownArrivalDiscount;

    public DomesticTrip (Date start, Date end, String destination){
        super(start, end, destination);
    }


    public int getPrice(){
        return super.getPrice() - getOwnArrivalDiscount();
    }

    public int getOwnArrivalDiscount() {
        return ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(int ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}

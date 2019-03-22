package com.company;

import java.time.LocalDate;

public class DomesticTrip extends Trip {

    private int ownArrivalDiscount;

    public DomesticTrip (LocalDate start, LocalDate end, String destination){
        setStart(start);
        setEnd(end);
        setDestination(destination);
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

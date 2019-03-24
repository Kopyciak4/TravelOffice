package com.company;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Trip {
    private LocalDate start;
    private LocalDate end;
    private String destination;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return price == trip.price &&
                start.equals(trip.start) &&
                end.equals(trip.end) &&
                destination.equals(trip.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, destination, price);
    }
}

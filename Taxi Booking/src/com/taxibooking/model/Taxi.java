package com.taxibooking.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    static int taxicount = 0;
    private int id;
    private boolean booked;
    private char currentSpot;
    private int freeTime;
    private int totalEarnings;
    private List<String> trips;

    public int getId() {
        return id;
    }

    public boolean isBooked() {
        return booked;
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public List<String> getTrips() {
        return trips;
    }

    public Taxi()
    {
        this.booked = false;
        this.currentSpot = 'A';
       this. freeTime = 6;
        this.totalEarnings = 0;
        this.trips = new ArrayList<>();
        this.taxicount = taxicount + 1;
        this.id = taxicount;
    }

    public void setDetails(boolean booked,char currentSpot,int freeTime,int totalEarnings,String tripDetail)
    {
        this.booked = booked;
        this.currentSpot = currentSpot;
        this.freeTime = freeTime;
        this.totalEarnings = totalEarnings;
        this.trips.add(tripDetail);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", booked=" + booked +
                ", currentSpot=" + currentSpot +
                ", freeTime=" + freeTime +
                ", totalEarnings=" + totalEarnings +
                ", trips=" + trips +
                '}';
    }
}

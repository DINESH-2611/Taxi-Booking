package com.taxibooking.model;

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
        booked = false;
        currentSpot = 'A';
        freeTime = 6;
        totalEarnings = 0;
        trips = new ArrayList<String>();
        taxicount = taxicount + 1;
        id = taxicount;
    }

    public void setDetails(boolean booked,char currentSpot,int freeTime,int totalEarnings,String tripDetail)
    {
        this.booked = booked;
        this.currentSpot = currentSpot;
        this.freeTime = freeTime;
        this.totalEarnings = totalEarnings;
        this.trips.add(tripDetail);
    }




}

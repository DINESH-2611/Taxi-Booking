package com.taxibooking.datalayer;

import com.taxibooking.model.Taxi;

public class TaxiBookingDatabase {
    private List<Taxi> taxiList =new ArrayList();
    public static TaxiBookingDatabase getInstance(){
        return new TaxiBookingDatabase();
    }

    public void createTaxi(int n) {
            List<Taxi> taxis=new ArrayList<Taxi>();
            for (int i = 1; i <=n; i++) {
                Taxi t = new Taxi();
                taxiList.add(t);
            }
        }
        public List<Taxi> getTaxis(){
        return taxiList;
        }
    }


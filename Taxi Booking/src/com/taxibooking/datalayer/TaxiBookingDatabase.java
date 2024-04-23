package com.taxibooking.datalayer;

import com.taxibooking.model.Taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiBookingDatabase {
    private static TaxiBookingDatabase taxiBookingDatabase;
    private List<Taxi> taxiList =new ArrayList<>();
    public static TaxiBookingDatabase getInstance(){
        if(taxiBookingDatabase==null){
            taxiBookingDatabase=new TaxiBookingDatabase();
        }
        return taxiBookingDatabase;
    }

    public void createTaxi(int n) {
            for (int i = 1; i <=n; i++) {
                Taxi t = new Taxi();
                taxiList.add(t);
            }
//        System.out.println(taxiList.size());
//            for(Taxi taxi:taxiList)
//                System.out.println(taxi);
        }
        public List<Taxi> getTaxis(){
//            System.out.println(taxiList.size());
        return taxiList;
        }
    }


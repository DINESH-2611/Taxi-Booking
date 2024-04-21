package com.taxibooking.booktaxi;

import com.taxibooking.datalayer.TaxiBookingDatabase;
import com.taxibooking.model.Taxi;

class BookTaxiModel {
    private BookTaxiView bookTaxiView;
    public BookTaxiModel(BookTaxiView bookTaxiView){
        this.bookTaxiView=bookTaxiView;
    }

    public  void validateDetails(char pickupPoint, char dropPoint, int pickup_time, int customer_id) {
        if(pickupPoint<'A' || dropPoint<'A' ||pickupPoint>'F' ||dropPoint>'F') {
            bookTaxiView.showAlert("valid pickup and drops are A,B,C,D,E,F");
        }else{
            List<Taxi> freeTaxis=getFreeTaxis(TaxiBookingDatabase.getInstance().getTaxis(),pickup_time, pickupPoint);
            if(freeTaxis.size()==0) {
                bookTaxiView.showAlert("No taxis are free please try again after some time");
                return;
            }

            Collections.sort(freeTaxis,(a,b)->a.getTotalEarnings-b.totalEarnings);

            booktaxi(customer_id, pickupPoint, dropPoint, pickup_time, freeTaxis);
            bookTaxiView.id++;
        }
    }

    public void createTaxi(int n) {
        TaxiBookingDatabase.getInstance().createTaxi(n);
        }
    public  List<Taxi> getFreeTaxis(List<Taxi> taxis, int pickup_time, char pickup_point){
        List<Taxi> freeTaxis=new  ArrayList<Taxi>();
        for(Taxi t:taxis) {
            if(t.getFreeTime()<=pickup_time&&(Math.abs((t.getCurrentSpot()-'0')-(pickup_point-'0'))<=pickup_time-t.getFreeTime())) {
                freeTaxis.add(t);
            }
        }
        return freeTaxis;
    }
    public void booktaxi(int customer_id,char pickup_point,char drop_point,int pickup_time,List<Taxi> freeTaxis) {
        int min=999;

        int dis_bet_pick_drop=0;

        int earning=0;

        int next_freetime=0;

        char next_spot='Z';

        Taxi bookedtaxi=null;

        String trip_detail="";

        for(Taxi t:freeTaxis) {
            int dis_bet_cus_taxi=Math.abs((t.getCurrentSpot()-'0')-(pickup_point-'0'))*15;

            if(dis_bet_cus_taxi<min) {
                bookedtaxi=t;

                dis_bet_pick_drop=Math.abs((drop_point-'0')-(pickup_point-'0'))*15;

                earning=(dis_bet_pick_drop-5)*10+100;

                int drop_time=pickup_time+dis_bet_pick_drop/15;

                next_freetime=drop_time;

                next_spot=drop_point;

                trip_detail=customer_id+"               "+customer_id+"         "+pickup_point+"        "+drop_point+"        "+pickup_time+"            "+drop_time+"         "+earning;
                min=dis_bet_cus_taxi;
            }
        }
        bookedtaxi.setDetails(true,next_spot,next_freetime,bookedtaxi.getTotalEarnings()+earning,trip_detail);
        System.out.println("Taxi "+customer_id+"  booked succesfully");
    }

    public void showDetails() {
        List<Taxi> taxiList=TaxiBookingDatabase.getInstance().getTaxis();
        bookTaxiView.printTaxiDetails(taxiList);
        bookTaxiView.printDetails(taxiList);
    }
}


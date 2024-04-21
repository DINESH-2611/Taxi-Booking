package com.taxibooking.booktaxi;

import com.taxibooking.model.Taxi;

public class BookTaxiView {
    private BookTaxiModel bookTaxiModel;

    public BookTaxiView() {
        this.bookTaxiModel = new BookTaxiModel(this);
    }

    public int id = 1;

    public void init() {
        bookTaxiModel.createTaxi(4);
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;
        do {
            System.out.println("Please Select the option");
            System.out.println("1-->Book Taxi\n2-->Print Taxi Details\n3-->Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    getDetails(id);
                    break;
                }
                case 2:{
                    bookTaxiModel.showDetails();
                    break;
                }
                case 3:{
                    showAlert("Thank you for using Taxi booking application");
                    repeat=false;
                    break;
                }
                default:
                    showAlert("Please select valid option");
                    break;
            }
        }

        while (repeat);
    }

    private void getDetails(int id) {
        int customer_id = id;
        System.out.println("Enter Pickup point");
        char pickup_point = sc.next().charAt(0);
        System.out.println("Enter Drop point");
        char drop_point = sc.next().charAt(0);
        System.out.println("Enter Pickup time");
        int pickup_time = sc.nextInt();
        bookTaxiModel.validateDetails(pickup_point, drop_point, pickup_time, customer_id);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
    public void printDetails(List<Taxi> taxiList)
    {
        for (Taxi taxi:taxiList){
            System.out.println("Taxi - "+ taxi.getId() + " Total Earnings - " + taxi.getTotalEarnings());
            System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
            for(String trip : taxi.getTrips())
            {
                System.out.println(id + "          " + trip);
            }
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }

    public void printTaxiDetails(List<Taxi> taxiList)
    {
       for (Taxi taxi:taxiList){
           System.out.println("Taxi - "+ taxi.getId() + " Total Earnings - " + taxi.getTotalEarnings() + " Current spot - " + taxi.getCurrentSpot()+" Free Time - " +taxi.getFreeTime());
       }
    }
}

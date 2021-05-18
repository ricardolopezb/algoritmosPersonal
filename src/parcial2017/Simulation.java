package parcial2017;

import util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        /*int ffwMinutes = Scanner.getInt("Enter deltaT interval (min): ");
        int regPrice = Scanner.getInt("Enter Regular Ticket Price: ");
        int fpPrice = Scanner.getInt("Enter FastPass Ticket Price: ");
        int openRides = Scanner.getInt("Enter Open Rides (4-8): ");
        int visitorInput = Scanner.getInt("Enter how many visitors enter in one interval: ");


         */
        int ffwMinutes = 1;
        int regPrice = 35;
        int fpPrice = 60;
        int openRides = 5;
        int visitorInput = 5;
        Park park = new Park(ffwMinutes, regPrice, fpPrice, openRides, visitorInput);

        while(true){
            simulate(park);
        }




    }

    public static void printMenu(){
        System.out.println("-------------- Southernlands --------------");
        System.out.println("1. Advance 1 deltaT");
        System.out.println("2. Show how many tickets have been purchased by type");
        System.out.println("3. Show ticket revenue by type");
        System.out.println("4. Show exit time percentages");
        System.out.println("5. Show average wait time ranking in Rides");

    }

    public static void simulate(Park park){
        printMenu();
        int choice = Scanner.getInt("--> ");
        switch (choice){
            case 1: park.fastFoward();
                    break;
            case 2: park.showPurchasedTicketTypes();
                    break;
            case 3: park.showRevenueByTicketType();
                break;
            case 4: park.showExitPercentages();
                break;
            case 5: park.showRideRankingByAverage();
                break;
            default: System.exit(0);
        }

        System.out.println("*********************************************");

    }

}

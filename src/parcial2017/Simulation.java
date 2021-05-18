package parcial2017;

import util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        int ffwMinutes = Scanner.getInt("Enter deltaT interval (min): ");
        int regPrice = Scanner.getInt("Enter Regular Ticket Price: ");
        int fpPrice = Scanner.getInt("Enter FastPass Ticket Price: ");
        int openRides = Scanner.getInt("Enter Open Rides (4-8): ");
        int visitorInput = Scanner.getInt("Enter how many visitors enter in one interval: ");

        Park park = new Park(ffwMinutes, regPrice, fpPrice, openRides, visitorInput);
        System.out.println("*********************************************");


    }

}

package parcial2017;

import lists.OrderedDynamicList;

import java.sql.SQLOutput;
import java.util.Random;

public class Park {
    private int openTime;
    private boolean open;
    private Hub hub;
    private Ride[] rides;
    private int regTicketPrice;
    private int fpTicketPrice;
    private TicketOffice ticketOffice;
    private int ffwMinutes; //Fast-foward time interval.
    private Ride[] openRides;
    private int visitorInput;
    private int totalVisitors;


    public Park(int ffwMinutes, int regTicketPrice, int fpTicketPrice, int openRidesNum, int visitorInput){
        this.openTime = 0;
        this.open = true;
        this.totalVisitors = 0;

        this.ticketOffice = new TicketOffice(regTicketPrice, fpTicketPrice, this);
        this.regTicketPrice = regTicketPrice;
        this.fpTicketPrice = fpTicketPrice;
        this.ffwMinutes = ffwMinutes;
        this.rides = new Ride[8];
        this.visitorInput = visitorInput;

        rides[0] = new Ride("Chipmunk Treasure", 8);
        rides[1] = new Ride("Munchkin Island", 4);
        rides[2] = new Ride("Dinosaur Land", 6);
        rides[3] = new Ride("Go Go Karts", 6);
        rides[4] = new Ride("Rock n Roller", 15);
        rides[5] = new Ride("Princess Castle", 9);
        rides[6] = new Ride("Splash Mount", 12);
        rides[7] = new Ride("Space	Xtreme", 12);

        this.openRides = new Ride[openRidesNum];
        selectOpenRides(openRidesNum);
        this.hub = new Hub(this);


    }

    public int getOpenTime(){
        return this.openTime;
    }

    public void fastFoward(){
        openTime++;
        if(openTime > 600){
            System.out.println("Park is closed for today! Come back tomorrow!");
            System.exit(0);
        }
        this.totalVisitors += visitorInput;
        Visitor[] visitors = new Visitor[visitorInput];
        for (int i = 0; i < visitorInput; i++) {
            visitors[i] = new Visitor();
        }
        ticketOffice.receiveNewVisitors(visitors);
        hub.receiveVisitors(visitors);
        hub.distributeVisitors();
        if(openTime%5 == 0){
            for (int i = 0; i < openRides.length; i++) {
                openRides[i].cycle(hub);
            }
        }

    }

    public Ride[] getOpenRides(){
        return openRides;
    }

    private void selectOpenRides(int openRidesNum) {
        Integer[] indexesToSelect = AuxMethods.generateUnsortedIntegerArray(8);
        for (int i = 0; i < openRidesNum; i++) {
            this.openRides[i] = rides[indexesToSelect[i]];
        }

    }

    public void showPurchasedTicketTypes(){
        System.out.println("*********************************************");
        System.out.println("Regular Tickets purchased: "+ ticketOffice.getRegularTicketCounter());
        System.out.println("FastPass Tickets purchased: "+ ticketOffice.getFpTicketCounter());
        System.out.println("*********************************************");
    }

    public void showRevenueByTicketType(){
        System.out.println("*********************************************");
        System.out.println("Regular Tickets revenue: "+ ticketOffice.getRegularRevenue());
        System.out.println("FastPass Tickets revenue: "+ ticketOffice.getFpRevenue());
        System.out.println("*********************************************");
    }

    public void showExitPercentages(){

        float p1 =((float)hub.getExitBefore18()/totalVisitors)*100;
        float p2 = ((float)hub.getExitBetween18and19()/totalVisitors)*100;
        float p3 = ((float)hub.getExitAt19()/totalVisitors)*100;


        System.out.println("*********************************************");
        System.out.println("% before 18hs: "+ p1 + "%");
        System.out.println("% between 18hs and 19hs: "+ p2 + "%");
        System.out.println("% at 19hs: "+ p3 + "%");
        System.out.println("*********************************************");
    }

    public void showRideRankingByAverage() {
        OrderedDynamicList<Ride> rides = new OrderedDynamicList<>();
        for (int i = 0; i < openRides.length; i++) {
            openRides[i].computeAverageWaitTime();
        }
        System.out.println("*********************************************");
        for (int i = 0; i < openRides.length; i++) {
            System.out.println((i + 1)+". " + openRides[i].getName() + " - Average Wait Time: " + openRides[i].getAverageWaitTime());
        }
        System.out.println("*********************************************");
    }








}

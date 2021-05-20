package parcial2017;

import lists.DynamicList;
import lists.StaticList;

public class Hub {
    private Park park;
    private Ride[] openRides;
    private StaticList<Visitor> visitorsInHub;
    private int exitBefore18;
    private int exitBetween18and19;
    private int exitAt19;

    public Hub(Park park){
        this.park = park;
        this.openRides = park.getOpenRides();
        this.visitorsInHub = new StaticList<>();
        this.exitAt19 = 0;
        this.exitBefore18 = 0;
        this.exitAt19 = 0;
    }


    public void distributeVisitors(){
        for (int i = 0; i < visitorsInHub.size(); i++) {
            Visitor visitor = visitorsInHub.getActual();

            int probNum = AuxMethods.randomNumberInRange100();

            if(park.getOpenTime() < 540){
                if(probNum <= 60){
                    sendVisitorToRide(visitor);
                    visitorsInHub.remove();
                }
                else if(probNum <=80){
                    this.exitBefore18++;
                    visitorsInHub.remove();
                }

            }
            else if(park.getOpenTime() >= 540 && park.getOpenTime()<600){
                if(probNum <= 50){
                    sendVisitorToRide(visitor);
                }
                else {
                    this.exitBetween18and19++;
                }
                visitorsInHub.remove();
            } else {
                visitorsInHub.remove();
                this.exitAt19++;
            }
            if(!visitorsInHub.endList()) visitorsInHub.goNext();

        }


    }

    public void receiveVisitors(Visitor[] visitors){
        for (int i = 0; i < visitors.length; i++) {
            visitorsInHub.insertNext(visitors[i]);
        }
    }

    public void sendVisitorToRide(Visitor visitor){
        Ride maxPopRide = new Ride("x", 3);
        for (int i = 0; i < openRides.length; i++) {
            if(openRides[i].compareTo(maxPopRide) > 0){
                maxPopRide = openRides[i];
            }
        }
        maxPopRide.addVisitor(visitor);
        visitor.setRideEntranceTime(park.getOpenTime());
    }

    public int getExitBefore18() {
        return exitBefore18;
    }

    public int getExitBetween18and19() {
        return exitBetween18and19;
    }

    public int getExitAt19() {
        return exitAt19;
    }

    public int getOpenTime(){
        return park.getOpenTime();
    }
}

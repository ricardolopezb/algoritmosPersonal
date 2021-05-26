package parcial2020;

import java.util.Random;

public class Simulator {
    private GasStation station;

    public Simulator(int pumpsQuantity, int parkingSpace, int pumpServiceTime){
        this.station = new GasStation(pumpsQuantity, parkingSpace, pumpServiceTime);
    }

    public void action1(){
        station.fastFoward1Min();
    }
    public void action2(){
        station.printWaitTimesInPump();
    }
    public void action3(){
        station.end();
    }





    public static int randomNumberInRange(int start, int end){
        Random r = new Random();
        int low = start;
        int high = end;
        return r.nextInt(high-low) + low;
    }
}

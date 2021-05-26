package parcial2020;

import java.util.Random;

public class GasStation {
    private int simTime;
    private Pump[] pumps;
    private Parking parking;
    private int awayCars;
    private int pumpServiceTime;

    public GasStation(int pumpsQuantity, int parkingSpace, int pumpServiceTime){
        this.simTime = 0;
        this.pumps = new Pump[pumpsQuantity];
        for (int i = 0; i < pumpsQuantity; i++) {
            pumps[i] = new Pump(this);
        }
        this.pumpServiceTime = pumpServiceTime;
        this.parking = new Parking(this,50);
    }
    public int getCurrentMin(){
        return simTime;
    }

    public int getPumpServiceTime() {
        return pumpServiceTime;
    }

    public void distributeCar(){
        Car car = new Car(this);
        int probNum = Simulator.randomNumberInRange(1,101);
        if(probNum >= 10){
            int condProbNum = Simulator.randomNumberInRange(1,101);
            if(condProbNum <= 50){
                awayCars++;
            } else{
                parking.receiveCar(car);
            }
        } else{
            int pumpNumber = Simulator.randomNumberInRange(0,pumps.length);
            pumps[pumpNumber].receiveCar(car);

        }
    }

    public void fastFoward1Min(){
        this.simTime++;
        distributeCar();
        checkPumpActivity();
        parking.checkDepartures();

    }

    private void checkPumpActivity() {
        for (int i = 0; i < pumps.length; i++) {
            pumps[i].check();
        }
    }

    public void printWaitTimesInPump(){
        int num = 1;
        for (int i = 0; i < pumps.length; i++) {
            if(pumps[i].isBusy()){
                System.out.println("Pump "+num+": "+ pumps[i].getCurrentCarWaitingTime());
                num++;
            }
        }
    }

    public void end(){
        System.out.println("Cars that didn't stop:" + awayCars);
        getPumpRevenue();
        getPumpMeanSize();
        System.out.println("Mean parked time: "+parking.getMeanParkingTime());
        System.exit(2);
    }

    private void getPumpMeanSize() {
        for (int i = 0; i < pumps.length; i++) {
            System.out.println("Pump No. " + (i+1) + " - Mean Size: "+pumps[i].getMeanSize());
        }
    }

    private void getPumpRevenue(){
        for (int i = 0; i < pumps.length; i++) {
            System.out.println("Pump No. " + (i+1) + " - Revenue: "+pumps[i].getRevenue());
        }
    }


}

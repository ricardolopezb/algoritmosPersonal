package parcial2020;

import queue.DynamicQueue;
import util.IsEmptyException;

public class Pump {
    private DynamicQueue<Car> queue;
    private boolean busy;
    private int revenue;
    private Car carInService;
    private int cumSize;
    private GasStation station;
    private int minuteCounter;

    public Pump(GasStation station){
        this.station = station;
        this.queue = new DynamicQueue<>();
        this.busy = false;
        this.revenue = 0;
        this.carInService = null;
        this.cumSize = 0;
        this.minuteCounter = 0;
    }

    public void dispatchCar(){
        //revenue added car in service null
        this.revenue += Simulator.randomNumberInRange(1500, 2501);
        this.carInService = null;
        this.busy = false;
        serveCar();
    }

    public void saveCurrentSize(){
        cumSize += queue.size();
    }

    public int getCurrentCarWaitingTime(){
        return carInService.getTimeInQueue();
    }

    public void serveCar(){
        if(!queue.isEmpty()) {
            try {
                Car firstInLine = queue.dequeue();
                firstInLine.getInPump();
                this.carInService = firstInLine;
                this.busy = true;

            } catch (IsEmptyException e) {
                e.getMessage();
            }
        }
    }

    public void receiveCar(Car car) {
        car.getInQueue();
        queue.enqueue(car);
    }

    public void check() {
        if(this.minuteCounter == station.getPumpServiceTime()){
            dispatchCar();
            this.minuteCounter = 0;
        } else{
            minuteCounter++;

        }
        saveCurrentSize();
    }

    public int getRevenue() {
        return revenue;
    }

    public boolean isBusy() {
        return busy;
    }

    public double getMeanSize() {
        return ((double)cumSize)/station.getCurrentMin();
    }
}

package parcial2020;

public class Car {
    private int initialEnqueuedTime;
    private int parkedTime;
    private int departureTime;
    private GasStation station;
    private int timeInQueue;

    public Car(GasStation station){
        this.initialEnqueuedTime = 0;
        this.parkedTime = 0;
        this.departureTime = 0;
        this.station = station;
        this.timeInQueue = 0;
    }
    
    public void getInQueue(){
        this.initialEnqueuedTime = station.getCurrentMin();
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void park(){
        int time = Simulator.randomNumberInRange(20, 121);
        this.parkedTime = time;
        setDepartureTime();
    }

    private void setDepartureTime() {
        this.departureTime = station.getCurrentMin() + parkedTime;
    }

    public int getParkedTime() {
        return parkedTime;
    }


    public void getInPump() {
        this.timeInQueue = station.getCurrentMin() - this.initialEnqueuedTime;
    }

    public int getTimeInQueue() {
        return timeInQueue;
    }
}

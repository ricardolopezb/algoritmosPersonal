package parcial2020;

public class Parking {
    private Car[] parkedCars;
    private int totalStayTimes;
    private int totalCarsParked;
    private GasStation station;

    public Parking(GasStation station, int size) {
        this.parkedCars = new Car[size];
        this.totalStayTimes = 0;
        this.station = station;
    }

    public void receiveCar(Car car) {
        int result = checkSpace();
        if(checkSpace() != -1){
            parkedCars[result] = car;
            car.park();
            totalStayTimes += car.getParkedTime();
            totalCarsParked++;
        }
    }

    public void checkDepartures(){
        if(checkSpace() >0) {
            for (int i = 0; i < checkSpace(); i++) {
                if (station.getCurrentMin() == parkedCars[i].getDepartureTime()) {
                    parkedCars[i] = null;
                    //ver si el tiempo de parkeo se suma una vez que se va o una vez que entra
                }
            }
        }
    }



    private int checkSpace() {
        for (int i = 0; i < parkedCars.length; i++) {
            if(parkedCars[i] == null) return i;
        }
        return -1;
    }

    public double getMeanParkingTime() {
        return (double)totalStayTimes/totalCarsParked;
    }
}

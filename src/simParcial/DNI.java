package simParcial;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class DNI {
    private static int generalNumber = 10000000;

    private LocalTime initialTime;
    private String number;
    private String chosenPub;
    private String givenCopy;
    private int timeUsingPub;

    public DNI(String chosenPub, String givenCopy) {
        if(generalNumber < 100000000){
            generalNumber++;
        } else{
            generalNumber = 10000000;
        }
        this.number = String.valueOf(generalNumber);
        this.chosenPub = chosenPub;
        this.givenCopy = givenCopy;
        this.initialTime = LocalTime.now();
        this.timeUsingPub = 0;
    }

    public String getChosenPub() {
        return chosenPub;
    }

    public String getGivenCopy() {
        return givenCopy;
    }

    public int getTimeUsingPub() {
        return timeUsingPub;
    }

    public void checkOut(){
        LocalTime finalTime = LocalTime.now();
        this.timeUsingPub = (int) MINUTES.between(finalTime, initialTime);

    }
}

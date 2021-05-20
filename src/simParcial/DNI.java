package simParcial;

import java.time.LocalTime;

public class DNI {
    private static int generalNumber = 10000000;

    private LocalTime initialTime;
    private int number;
    private String chosenPub;
    private String givenCopy;
    private int timeUsingPub;

    public DNI(String chosenPub, String givenCopy) {
        this.chosenPub = chosenPub;
        this.givenCopy = givenCopy;
    }
}

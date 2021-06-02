package practicaParcial2.modeloCampus;

public class Call {
    private int countryCode;
    private int minutes;
    private int seconds;

    public Call(int countryCode, int minutes, int seconds) {
        this.countryCode = countryCode;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}

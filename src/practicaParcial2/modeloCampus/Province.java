package practicaParcial2.modeloCampus;

public class Province implements Comparable<Province>{
    private int code;
    private int totalRain;

    public Province(int code, int totalRain) {
        this.code = code;
        this.totalRain = totalRain;
    }

    public int getCode() {
        return code;
    }

    public int getTotalRain() {
        return totalRain;
    }

    @Override
    public int compareTo(Province o) {
        return this.totalRain - ((Province)o).getTotalRain();
    }

    public String toString(){
        return "Province No. " + this.code + " - Rain: " + this.totalRain;
    }


}

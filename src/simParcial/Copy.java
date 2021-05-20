package simParcial;

public class Copy {
    private static int generalCode = 100;
    private String copyCode;
    private boolean inUse;
    private int totalTimeInUse;

    public Copy() {
        if(generalCode < 1000){
            generalCode++;
        } else{
            generalCode = 100;
        }
        this.copyCode = String.valueOf(generalCode);
        this.inUse = false;
        this.totalTimeInUse = 0;
    }

    public String getCopyCode() {
        return copyCode;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}

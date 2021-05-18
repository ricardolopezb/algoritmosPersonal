package parcial2017;

public class Visitor {
    private int rideEntranceTime;
    private boolean fastPass;
    private int fpUses;

    public Visitor(){
        this.rideEntranceTime = 0;
        this.fastPass = false;
        this.fpUses = 8;
    }

    public void setFastPass(boolean value){
        this.fastPass = value;
    }

    public void useFastPass(){
        this.fpUses--;
        if(this.fpUses == 0) this.fastPass = false;
    }

    public boolean isFastPass() {
        return fastPass;
    }

    public void setRideEntranceTime(int rideEntranceTime) {
        this.rideEntranceTime = rideEntranceTime;
    }

    public int getRideEntranceTime() {
        return rideEntranceTime;
    }
}

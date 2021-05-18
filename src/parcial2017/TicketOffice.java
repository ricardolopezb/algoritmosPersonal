package parcial2017;

public class TicketOffice {
    private int regTicketPrice;
    private int fpTicketPrice;
    private Park park;
    private int fpTicketCounter;
    private int regularTicketCounter;

    public TicketOffice(int regTicketPrice, int fpTicketPrice, Park park) {
        this.regTicketPrice = regTicketPrice;
        this.fpTicketPrice = fpTicketPrice;
        this.park = park;
        this.fpTicketCounter = 0;
        this.regularTicketCounter = 0;
    }

    public void receiveNewVisitors(Visitor[] visitors) {
        for (int i = 0; i < visitors.length; i++) {
            int probInt = AuxMethods.randomNumberInRange100();
            if(probInt <=30){
                visitors[i].setFastPass(true);
                fpTicketCounter++;
            } else{
                regularTicketCounter++;
            }
        }
    }

    public int getFpTicketCounter() {
        return fpTicketCounter;
    }

    public int getRegularTicketCounter() {
        return regularTicketCounter;
    }

    public int getFpRevenue(){
        return fpTicketCounter*fpTicketPrice;
    }

    public int getRegularRevenue(){
        return regularTicketCounter*regTicketPrice;
    }
}

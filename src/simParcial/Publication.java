package simParcial;

public class Publication {
    private int availableCopies;
    private String code;
    private Copy[] copies;

    public Publication(String code, int availableCopies) {
        this.availableCopies = availableCopies;
        this.code = code;
        this.copies = new Copy[availableCopies];
        for (int i = 0; i < copies.length; i++) {
            copies[i] = new Copy();
        }
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public String getCode() {
        return code;
    }

    //todo receiveCopy

    public String retrieveCopy() {
        for (int i = 0; i < copies.length; i++) {
            if(!copies[i].isInUse()){
                copies[i].setInUse(true);
                this.availableCopies--;
                return copies[i].getCopyCode();
            }
        }
        return null;
    }
}

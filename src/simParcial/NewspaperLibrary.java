package simParcial;

import lists.DynamicList;

public class NewspaperLibrary {
    private int pubsQuant;
    private Worker worker;
    private Publication[] existingPubs;
    private DynamicList<String> unavailablePubs;
    private DynamicList<DNI> dniUsingCopies;
    private DynamicList<DNI> dniArchive;
    private int copiesQuant;

    public NewspaperLibrary(int pubsQuant, int copiesQuant) {
        this.existingPubs = new Publication[pubsQuant];
        this.pubsQuant = pubsQuant;
        this.copiesQuant = copiesQuant;
        this.unavailablePubs = new DynamicList<>();
        this.dniArchive = new DynamicList<>();
        this.dniUsingCopies = new DynamicList<>();
        this.worker = new Worker(this);
    }

    public void setUp(){
        worker.createAvailablePubs(this.pubsQuant, this.copiesQuant);
    }

    public Publication[] getExistingPubs() {
        return existingPubs;
    }

    public void work(){
        int prob = AuxMethods.randomNumberInRange(0,101);
        if(prob < 50){

            worker.receiveCustomer();
        }



    }

    public DynamicList<String> getUnavailablePubs() {
        return unavailablePubs;
    }
}

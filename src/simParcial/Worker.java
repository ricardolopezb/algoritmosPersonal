package simParcial;

public class Worker {
    NewspaperLibrary library;

    public Worker(NewspaperLibrary library) {
        this.library = library;
    }

    public void createAvailablePubs(int pubsQuant, int copiesQuant) {
        Publication[] pubs = library.getExistingPubs();
        for (int i = 0; i < pubs.length; i++) {
            int copyQuant = AuxMethods.randomNumberInRange(1,copiesQuant+1);
            String pubCode = AuxMethods.newNombre();
            pubs[i] = new Publication(pubCode, copyQuant);

        }

    }

    public void receiveCustomer() {
        DNI customer = generateCustomer(library.getExistingPubs());
    }

    private DNI generateCustomer(Publication[] pubs) {
        int chosenPubPos = AuxMethods.randomNumberInRange(0, pubs.length);

        Publication chosenPub = pubs[chosenPubPos];

        if(chosenPub.getAvailableCopies() == 0){
            library.getUnavailablePubs().addAfter(chosenPub.getCode());
        } else{
            String copyCode = chosenPub.retrieveCopy();
        }


    }
}

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
    public void checkOutCustomer(DNI dni){
        //set the copy to free
        dni.checkOut();
        Publication borrowedPub = searchPub(dni.getChosenPub());
        borrowedPub.returnCopy(dni.getGivenCopy(), dni.getTimeUsingPub());
        library.getDniArchive().addAfter(dni);
        library.getDniUsingCopies().remove();

    }

    public Publication searchPub(String pubCode){
        Publication[] pubs = library.getExistingPubs();
        for (int i = 0; i < pubs.length; i++) {
            if(pubs[i].getCode().equals(pubCode)) return pubs[i];
        }
        return null;

    }

    public void receiveCustomer() {
        DNI customer = generateCustomer(library.getExistingPubs());
        library.addDNIUsingCopy(customer);
    }

    private DNI generateCustomer(Publication[] pubs) {
        int chosenPubPos = AuxMethods.randomNumberInRange(0, pubs.length);

        Publication chosenPub = pubs[chosenPubPos];

        if(chosenPub.getAvailableCopies() == 0){
            library.getUnavailablePubs().addAfter(chosenPub.getCode());
        } else{
            String copyCode = chosenPub.retrieveCopy();
            return new DNI(chosenPub.getCode(), copyCode);
        }

        return null;
    }
}

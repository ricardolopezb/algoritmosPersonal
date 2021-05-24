package parcialElecciones;

public class Boleta {
    static int codigoGeneral = 0;
    private String id;
    private String partido;

    public Boleta(String partido) {
        this.partido = partido;
        codigoGeneral++;
        this.id = String.valueOf(codigoGeneral);
    }

    public String getPartido() {
        return partido;
    }

    public String toString(){
        return "Boleta No. "+id+"\nPartido: " + partido + "\n\n";
    }
}

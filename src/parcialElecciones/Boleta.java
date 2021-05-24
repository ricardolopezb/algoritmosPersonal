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
}

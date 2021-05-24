package parcialElecciones;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Votante {
    private LocalTime entradaAMesa;
    private LocalTime entradaACuarto;
    private LocalTime salidaDeCuarto;
    private Boleta voto;

    public Votante(){
        this.entradaAMesa = LocalTime.now();
    }

    public void setVoto(Boleta voto) {
        this.voto = voto;
    }

    public void pasarACuarto(){
        entradaACuarto = LocalTime.now();
    }

    public void salirDeCuarto(){
        salidaDeCuarto = LocalTime.now();
    }

    public double getTiempoEnCola(){
        return MINUTES.between(entradaAMesa, entradaACuarto);
    }
    public double getTiempoEnCuarto(){
        return MINUTES.between(entradaACuarto, salidaDeCuarto);
    }

    public Boleta getVoto() {
        return voto;
    }
}

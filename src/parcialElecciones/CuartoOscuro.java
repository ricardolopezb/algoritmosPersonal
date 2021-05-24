package parcialElecciones;

import stack.DynamicStack;
import stack.StaticStack;

import java.util.Random;

public class CuartoOscuro {
    private StaticStack<Boleta>[] pilasDeBoletas;
    private Votante votante;
    private boolean ocupado;

    public CuartoOscuro(){
        this.pilasDeBoletas = new StaticStack[5];
        for (int i = 0; i < pilasDeBoletas.length; i++) {
            pilasDeBoletas[i] = new StaticStack<>();
        }
        this.ocupado = false;
        this.votante = null;
    }

    public StaticStack<Boleta>[] getPilas() {
        return this.pilasDeBoletas;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void recibirVotante(Votante votante){
        this.ocupado = true;
        Boleta boletaElegida = seleccionarBoleta();
        this.votante = votante;
        votante.pasarACuarto();
        votante.setVoto(boletaElegida);
    }

    private Boleta seleccionarBoleta(){
        int counter = 0;
        int eleccion = randomNumberInRange(0, 5);
        while(counter < 10){
            try{
                Boleta boletaElegida = pilasDeBoletas[eleccion].peek();
                pilasDeBoletas[eleccion].pop();
                return boletaElegida;
            } catch(Exception e){
                counter++;
                eleccion = randomNumberInRange(0, 5);
            }
        }
        return null;
    }

    public static int randomNumberInRange(int start, int end){
        Random r = new Random();
        int low = start;
        int high = end;
        return r.nextInt(high-low) + low;
    }

    public Votante sacarVotante() {
        Votante v = this.votante;
        this.votante = null;
        this.ocupado = false;
        v.salirDeCuarto();

        return v;


    }
}

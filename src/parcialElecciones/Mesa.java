package parcialElecciones;

import lists.DynamicList;
import parcial2017.Visitor;
import queue.DynamicQueue;
import stack.DynamicStack;
import stack.StaticStack;

public class Mesa {
    private CuartoOscuro cuartoOscuro;
    private DynamicQueue<Votante> cola;
    private DynamicList<Boleta> urna;
    private String[] partidos;

    private DynamicList<Double> tiemposEnCola;
    private DynamicList<Double> tiemposEnCuarto;

    public Mesa(String p1, String p2, String p3, String p4, String p5){
        this.cuartoOscuro = new CuartoOscuro();
        this.cola = new DynamicQueue<>();
        this.urna = new DynamicList<>();
        this.partidos = new String[5];
        this.partidos = new String[]{p1, p2, p3, p4, p5};
        this.tiemposEnCola = new DynamicList<>();
        this.tiemposEnCuarto = new DynamicList<>();

    }

    public void armar(){
        StaticStack<Boleta>[] pilas = cuartoOscuro.getPilas();
        for (int i = 0; i < pilas.length; i++) {
            while(pilas[i].size() != 200){
                pilas[i].stack(new Boleta(partidos[i]));
            }
        }
    }

    public void reponer(){
        if(cuartoOscuro.isOcupado()){
            return;
        }
        int[] counters = {0,0,0,0,0};
        StaticStack<Boleta>[] pilas = cuartoOscuro.getPilas();
        for (int i = 0; i < pilas.length; i++) {
            while(pilas[i].size() != 200){
                pilas[i].stack(new Boleta(partidos[i]));
                counters[i]++;
            }
        }
        for (int i = 0; i < counters.length; i++) {
            System.out.println(partidos[i]+": "+counters[i]+" boletas");
        }
    }

    public void ingresarVotante(){
        Votante votante = new Votante();
        cola.enqueue(votante);

    }

    public void pasarVotante(){
        if(cuartoOscuro.isOcupado() || cola.isEmpty()){
            return;
        }
        try {
            Votante v = cola.dequeue();
            cuartoOscuro.recibirVotante(v);
            tiemposEnCola.insertNext(v.getTiempoEnCola());
        } catch(Exception e){
            e.getMessage();
        }

    }

    public void sacarVotante(){
        if (!cuartoOscuro.isOcupado()){
            return;
        }
        Votante votante = cuartoOscuro.sacarVotante();
        tiemposEnCuarto.insertNext(votante.getTiempoEnCuarto());
        urna.insertNext(votante.getVoto());
    }
    /*
    public void terminar(){
        System.out.println("Tiempo medio en Cola: " + getTiempoEnCola());
        System.out.println("Partido Ganador: " + getPartidoGanador() + " - " + getVotosGanador());
        printUltimasDiez();
        System.out.println("Tiempo medio en Cuarto Oscuro: " + getTiempoEnCuarto());

    }

    private String getTiempoEnCuarto() {
    }

    private String getVotosGanador() {
    }

    private void printUltimasDiez() {
    }

    private String getPartidoGanador(){

    }


    private String getTiempoEnCola() {
    }*/


}

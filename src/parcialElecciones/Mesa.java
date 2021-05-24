package parcialElecciones;

import lists.DynamicList;
import queue.DynamicQueue;
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

    public void terminar(){
        System.out.println("Tiempo medio en Cola: " + getTiempoEnCola());
        System.out.println(ganador());
        printUltimasDiez();
        System.out.println("Tiempo medio en Cuarto Oscuro: " + getTiempoEnCuarto());

    }

    private double getTiempoEnCuarto() {
        return getMean(this.tiemposEnCuarto);
    }

    private double getMean(DynamicList<Double> list){
        double sum = 0;
        list.goTo(0);
        for (int i = 0; i < list.size(); i++) {
            sum += list.getActual();
            if(!list.listEnd()) {
                list.goNext();
            }
        }
        return sum/list.size();
    }

    private String ganador() {
        int[] counter = {0,0,0,0,0};
        String partidoDeBoleta;
        urna.goTo(0);
        for (int i = 0; i < urna.size(); i++) {
            partidoDeBoleta = urna.getActual().getPartido();

            if(partidoDeBoleta.equals(partidos[0])) counter[0]++;
            else if(partidoDeBoleta.equals(partidos[1])) counter[1]++;
            else if(partidoDeBoleta.equals(partidos[2])) counter[2]++;
            else if(partidoDeBoleta.equals(partidos[3])) counter[3]++;
            else if(partidoDeBoleta.equals(partidos[4])) counter[4]++;

            if(!urna.listEnd()) {
                urna.goNext();
            }
        }
        int maxValue = 0;
        int maxIndex = -1;
        for (int i = 0; i < counter.length; i++) {
            if(counter[i] > maxValue){
                maxIndex = i;
                maxValue = counter[i];
            }
        }
        return "Partido ganador: " + partidos[maxIndex] + " - Votos: " + maxValue;
    }

    private void printUltimasDiez() {
        if(urna.size() > 10){
            for (int j = urna.size()-10; j < urna.size(); j++) {
                urna.goTo(j);
                System.out.println(urna.getActual().toString());
            }
        }

    }




    private double getTiempoEnCola() {
        return getMean(this.tiemposEnCola);
    }


}

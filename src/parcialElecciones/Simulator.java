package parcialElecciones;

public class Simulator {
    private Mesa mesa;

    public Simulator(String p1,String p2,String p3,String p4,String p5){
        this.mesa = new Mesa(p1,p2,p3,p4,p5);
        this.mesa.armar();
    }

    public void action1(){
        mesa.ingresarVotante();
    }
    public void action2(){
        mesa.pasarVotante();
    }
    public void action3(){
        mesa.sacarVotante();
    }
    public void action4(){
        mesa.reponer();
    }
    public void action5(){
        mesa.terminar();
    }
}

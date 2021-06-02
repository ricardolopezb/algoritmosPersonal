package TpArchivos.src;

public class Cotizacion {

    private int mes;
    private double valor;

    public Cotizacion(int mes) {
        this.mes = mes;
        this.valor = Math.random()*80+60;//valor random entre 60 y 140 pesos
    }

    public int getMes() {
        return mes;
    }

    public double getValor() {
        return valor;
    }
}

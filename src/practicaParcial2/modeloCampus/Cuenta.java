package practicaParcial2.modeloCampus;

public class Cuenta implements Comparable{
    private final char sucursal;
    private final int numero;

    public Cuenta(char sucursal, int numero) {
        this.sucursal = sucursal;
        this.numero = numero;
    }

    public char getSucursal() {
        return sucursal;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int compareTo(Object o) {
        return this.numero - ((Cuenta)o).getNumero();
    }

    public String toString(){
        return numero+" ";
    }
}

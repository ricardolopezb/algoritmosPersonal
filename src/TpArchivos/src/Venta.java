package TpArchivos.src;

public class Venta {

   private String codigoDestino;
   private int codigoArticulo;
   private int cantidad;
   private int precioUnitarioEnDolares;
   private int mesDeCobro;

    public Venta(String codigoDestino) {
        this.codigoDestino = codigoDestino;
        this.codigoArticulo = (int) (Math.random()*899+100);
        this.cantidad = (int) (Math.random()*9+1);
        this.precioUnitarioEnDolares = (int) (Math.random()*9+1);;
        this.mesDeCobro = (int) (Math.random()*12)+1;;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecioUnitarioEnDolares() {
        return precioUnitarioEnDolares;
    }

    public int getMesDeCobro() {
        return mesDeCobro;
    }
}

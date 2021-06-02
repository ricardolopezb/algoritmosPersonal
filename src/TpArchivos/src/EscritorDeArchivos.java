package TpArchivos.src;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscritorDeArchivos {

    String[]destinos;

    public EscritorDeArchivos() throws IOException {
        destinos=new String[30];
        for (int i = 0; i < 30; i++) {
            destinos[i]=Destino.randomCode();
        }
        escribirVentas();
        escribirDestinos();
        escribirCotizaciones();
    }

    private void escribirCotizaciones() throws IOException {
        File cotizaciones=new File("cotizaciones.txt");
        RandomAccessFile raf=new RandomAccessFile(cotizaciones,"rw");
        raf.seek(0);
        for (int i = 0; i < 12; i++) {
            Cotizacion cotizacion=new Cotizacion(i+1);
            raf.writeInt(cotizacion.getMes());
            raf.writeDouble(cotizacion.getValor());
        }
        raf.close();

    }

    private void escribirDestinos() throws IOException {
        File Filedestinos=new File("destinos.txt");
        RandomAccessFile raf=new RandomAccessFile(Filedestinos,"rw");
        raf.seek(0);
        for (int i = 0; i < 30; i++) {
            Destino destino=new Destino(destinos[i]);
            raf.writeUTF(destino.getCodigo());
            raf.writeUTF(destino.getDescripcion());
        }
        raf.close();
    }

    private void escribirVentas() throws IOException {
        File ventas=new File("ventas.txt");
        RandomAccessFile raf=new RandomAccessFile(ventas,"rw");
        raf.seek(0);
        for (int i = 0; i < 1000; i++) {
            String destinoRandom=destinos[(int) (Math.random()*30)];
            Venta venta=new Venta(destinoRandom);
            raf.writeUTF(destinoRandom);
            raf.writeInt(venta.getCodigoArticulo());
            raf.writeInt(venta.getCantidad());
            raf.writeInt(venta.getPrecioUnitarioEnDolares());
            raf.writeInt(venta.getMesDeCobro());
        }
        raf.close();
    }
}

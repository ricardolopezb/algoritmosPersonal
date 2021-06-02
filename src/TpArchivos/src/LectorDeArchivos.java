package TpArchivos.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LectorDeArchivos {

    String []destinos;

    public LectorDeArchivos() throws IOException {
        this.destinos = leerDestinos();
    }

    private String[] leerDestinos() throws IOException {
        String[]toReturn=new String[30];
        File destinos=new File("destinos.txt");
        RandomAccessFile raf=new RandomAccessFile(destinos,"r");
        raf.seek(0);
        for (int i = 0; i < 30; i++) {
            toReturn[i]=raf.readUTF();
            raf.readUTF();
        }
        raf.close();
        return toReturn;
    }

    private void montoEnPesosPorDestino(String destino) throws IOException {
        File ventas=new File("ventas.txt");
        RandomAccessFile raf=new RandomAccessFile(ventas,"r");
        raf.seek(0);
        double montoTotal=0;
        for (int i = 0; i < 1000; i++) {
            String codigoDestino=raf.readUTF();
            int codigoArticulo=raf.readInt();
            int cantidad=raf.readInt();
            int precioUnitario=raf.readInt();
            int mes=raf.readInt();
            if (codigoDestino.equals(destino)){
                montoTotal+=cantidad*precioUnitario*precioEnPesos(mes);
            }
        }
        raf.close();
        System.out.println("Destino "+destino+": "+(float)montoTotal+" pesos");
    }

    public void montoEnPesosPorDestino() throws IOException {
        for (int i = 0; i < 30; i++) {
            montoEnPesosPorDestino(destinos[i]);
        }
    }

    private double precioEnPesos(int mes) throws IOException {
        File cotizacion=new File("cotizaciones.txt");
        RandomAccessFile raf=new RandomAccessFile(cotizacion,"r");
        raf.seek(0);
        for (int i = 0; i < 12; i++) {
            int mesCot=raf.readInt();
            Double cot= raf.readDouble();
            if (mes==mesCot){
                return cot;
            }
        }
        raf.close();
        return 0;
    }

    private void montoEnPesosPorMes(int mes) throws IOException {
        File ventas=new File("ventas.txt");
        RandomAccessFile raf=new RandomAccessFile(ventas,"r");
        raf.seek(0);
        double montoTotal=0;
        for (int i = 0; i < 1000; i++) {
            String codigoDestino=raf.readUTF();
            int codigoArticulo=raf.readInt();
            int cantidad=raf.readInt();
            int precioUnitario=raf.readInt();
            int mesDeVenta=raf.readInt();
            if (mes==mesDeVenta){
                montoTotal+=cantidad*precioUnitario*precioEnPesos(mes);
            }
        }
        raf.close();
        System.out.println("Mes "+mes+": "+(float)montoTotal+" pesos");
    }

    public void montoEnPesosPorMes() throws IOException {
        for (int i = 0; i < 12; i++) {
            montoEnPesosPorMes(i+1);
        }
    }
}

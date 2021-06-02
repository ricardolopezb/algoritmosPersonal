package TpArchivos.src;

import java.io.IOException;

public class Tester {

    public static void main(String[] args) throws IOException {
        EscritorDeArchivos escritorDeArchivos=new EscritorDeArchivos();
        LectorDeArchivos lectorDeArchivos=new LectorDeArchivos();
        lectorDeArchivos.montoEnPesosPorDestino();
        lectorDeArchivos.montoEnPesosPorMes();
    }
}

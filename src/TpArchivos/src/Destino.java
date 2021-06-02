package TpArchivos.src;

public class Destino {

    private String codigo;
    private String descripcion;

    public Destino(String codigo) {
        this.codigo = codigo;
        this.descripcion = "descripcion";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static String randomCode() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    }


package ArbolBinarioDeBusqueda;

public class Organism implements Comparable {

    private String code;
    private String type;
    private String description;
    private int[] size;

    public Organism(String code, String type, String description, int size1, int size2)throws IncompatibleCode {
        if (code.length()!=5)throw new IncompatibleCode();
        this.code = code;
        this.type = type;
        this.description = description;
        this.size = new int[2];
        getSize()[0] = size1;
        getSize()[1] = size2;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

    public int compareTo(Object o) {
        Organism x = (Organism) o;
        return getCode().toLowerCase().compareTo(x.getCode().toLowerCase());
    }

    public String toString(){
        return "Code: "+getCode()+"\nType: "+getType()+"\nDescription: "+getDescription()+"\nSize: "+getSize()[0]+""+getSize()[1];
    }

}


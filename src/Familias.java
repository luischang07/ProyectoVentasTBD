
public class Familias {
    private int famid;
    private String famnombre;

    public Familias(int famid, String famnombre) {
        this.famid = famid;
        this.famnombre = famnombre;
    }

    public int getFamid() {
        return famid;
    }

    public void setFamid(int famid) {
        this.famid = famid;
    }

    public String getFamnombre() {
        return famnombre;
    }

    public void setFamnombre(String famnombre) {
        this.famnombre = famnombre;
    }
}

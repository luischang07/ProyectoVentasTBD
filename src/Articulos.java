
public class Articulos {
    private int artid;
    private String artnombre;
    private String artdescripcion;
    private float artprecio;
    private int famid;

    public Articulos(int artid, String artnombre, String artdescripcion, float artprecio, int famid) {
        this.artid = artid;
        this.artnombre = artnombre;
        this.artdescripcion = artdescripcion;
        this.artprecio = artprecio;
        this.famid = famid;
    }

    public int getArtid() {
        return artid;
    }

    public void setArtid(int artid) {
        this.artid = artid;
    }

    public String getArtnombre() {
        return artnombre;
    }

    public void setArtnombre(String artnombre) {
        this.artnombre = artnombre;
    }

    public String getArtdescripcion() {
        return artdescripcion;
    }

    public void setArtdescripcion(String artdescripcion) {
        this.artdescripcion = artdescripcion;
    }

    public float getArtprecio() {
        return artprecio;
    }

    public void setArtprecio(float artprecio) {
        this.artprecio = artprecio;
    }

    public int getFamid() {
        return famid;
    }

    public void setFamid(int famid) {
        this.famid = famid;
    }
}

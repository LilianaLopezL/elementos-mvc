

package unitec.elementosmvc;


public class Cliente 
{
    private String nombre;
    private Tarjeta tarjeta;
    private String id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(String nombre, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }

    public Cliente(String nombre, Tarjeta tarjeta, String id) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.id = id;
    }

    public Cliente() {
    }
    
    
}

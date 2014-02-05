package indumaticsgestion.data.ventas;

import com.db4o.config.annotations.Indexed;
import indumaticsgestion.data.comun.Persona;

/**
 *
 * @author Maxi
 */
public class Cliente extends Persona{
    @Indexed
    private int id;
    private Zona zona;   

    public Cliente() {
    }

    
    @Override
    public String toString() {
        return Integer.toString(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    
}

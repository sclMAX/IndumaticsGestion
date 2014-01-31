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
}

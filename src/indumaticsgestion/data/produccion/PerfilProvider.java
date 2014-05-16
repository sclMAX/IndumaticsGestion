/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package indumaticsgestion.data.produccion;

import com.db4o.ObjectSet;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import indumaticsgestion.data.comun.Provider;

/**
 *
 * @author Maxi
 */
public class PerfilProvider extends Provider{

    @Override
    public ObjectSet<Object> serach(Object objeto, String consulta) {
        return super.serach(objeto, consulta); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSet<Object> getAll(Object data) {
        return super.getAll(data); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object data) {
        super.delete(data); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void store(Object data) throws UniqueFieldValueConstraintViolationException {
        super.store(data); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

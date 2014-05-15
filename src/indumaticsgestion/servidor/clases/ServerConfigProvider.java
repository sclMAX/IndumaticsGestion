package indumaticsgestion.servidor.clases;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import indumaticsgestion.data.comun.Usuario;

/**
 *
 * @author Maxi
 */
public class ServerConfigProvider {

    String dbfile = "svrconfig.db4o";
    ObjectContainer db = null;

    public ServerConfigProvider() {
    }

    public void save(ServerConfig data) throws UniqueFieldValueConstraintViolationException{
        db = Db4oEmbedded.openFile(getDbConfig(),dbfile);
        ServerConfig oldconfig = data;
        try {
            ObjectSet<ServerConfig> r = db.queryByExample(ServerConfig.class);
            while (r.hasNext()) {
                db.delete(r.next());
            }
            r = db.queryByExample(Usuario.class);
            while (r.hasNext()) {
                db.delete(r.next());
            }
            db.commit();
            db.store(data);
            db.commit();
        }catch(UniqueFieldValueConstraintViolationException ex){
            db.rollback();
            db.store(oldconfig);
            db.commit();
            throw ex;
        } finally {
            db.close();
        }
    }

    public ServerConfig getConfig() {
        db = Db4oEmbedded.openFile(getDbConfig(),dbfile);
        try {
            ObjectSet<ServerConfig> result = db.queryByExample(ServerConfig.class);
            if (result.hasNext()) {
                return result.next();
            }
            return null;
        } finally {
            db.close();
        }
    }
    private EmbeddedConfiguration getDbConfig(){
        EmbeddedConfiguration econfig = Db4oEmbedded.newConfiguration();
        econfig.common().add(new UniqueFieldValueConstraint(Usuario.class, "user"));
        return econfig;
    }
    
}

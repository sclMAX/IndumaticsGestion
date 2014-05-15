package indumaticsgestion.servidor.clases;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.query.Query;
import indumaticsgestion.data.comun.Usuario;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ServerConfigProvider {

    private static ServerConfigProvider instance = null;
    private static final String DB_CONFIG_FILE = "svrconfig.db4o";
    private static ServerConfig serverconfig = null;
    private static ObjectContainer db = null;

    private ServerConfigProvider() {
    }

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ServerConfigProvider();
            instance.conectar();
        }
    }
    
    public static void setConfig(ServerConfig data){
        db.delete(serverconfig);
        serverconfig = data;
        db.store(serverconfig);
    }

    public void conectar() {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().add(
                new UniqueFieldValueConstraint(Usuario.class, "nombre"));
        db = Db4oEmbedded.openFile(config, DB_CONFIG_FILE);
        final Query query = db.query();
        query.constrain(ServerConfig.class);
        List<ServerConfig> data = query.execute();
        if (!data.isEmpty()) {
            serverconfig = data.get(0);
        } else {
            serverconfig = new ServerConfig();
            db.store(serverconfig);
        }
    }

    public static void desconectar() {
        if (db != null) {
            db.close();
        }
    }
    
    public static ServerConfig getInstance(){
        if(instance == null){
            createInstance();
        }
        return serverconfig;
    }
}

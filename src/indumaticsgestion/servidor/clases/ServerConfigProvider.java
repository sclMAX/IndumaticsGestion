package indumaticsgestion.servidor.clases;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
<<<<<<< HEAD
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Query;
import indumaticsgestion.data.comun.Usuario;
import indumaticsgestion.data.comun.Utils;
=======
import com.db4o.query.Query;
import indumaticsgestion.data.comun.Usuario;
>>>>>>> d5bafe3dfec88665d1311b634d88ee3070bd35bb
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

<<<<<<< HEAD
    public static void setConfig(ServerConfig data) {
        db.delete(serverconfig);
        serverconfig = data;
        db.store(serverconfig);
        db.commit();
        instance = null;
        createInstance();
    }

    public void conectar() {
        try {
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
                db.commit();
            }
        } catch (Db4oIOException | DatabaseFileLockedException | DatabaseReadOnlyException ex) {
            Utils.errorMsg("Error en Base de Datos...", "Archivo Bloqueado!\nERROR:" + ex.getMessage());
            instance = null;
        } catch (IncompatibleFileFormatException | OldFormatException ex) {
            Utils.errorMsg("Error en Base de Datos...", "Version no compatible!\nERROR:" + ex.getMessage());
            instance = null;
        }
    }

    public static void desconectar() {
        if (db != null) {
            db.close();
        }
    }

    public static ServerConfig getInstance() {
        if (instance == null) {
            createInstance();
        }
        return serverconfig;
    }
=======
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
>>>>>>> d5bafe3dfec88665d1311b634d88ee3070bd35bb
}

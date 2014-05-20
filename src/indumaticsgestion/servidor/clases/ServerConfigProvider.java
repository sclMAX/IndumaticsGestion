package indumaticsgestion.servidor.clases;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import indumaticsgestion.data.comun.Utils;
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
    private static ServerConfig serverconfig = new ServerConfig();
    private static ObjectContainer db = null;

    private ServerConfigProvider() {
    }

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ServerConfigProvider();
            instance.conectar();
        }
    }

    public static void setConfig(ServerConfig data) {
        if (db != null) {
            try {
                db.delete(serverconfig);
                db.commit();
                db.store(data);
                db.commit();
            } catch (UniqueFieldValueConstraintViolationException ex) {
                Utils.errorMsg("Usuario incorrecto!", "Usuario ya ingresado en el sistema!");
                db.rollback();
            }
        }
        serverconfig = data;
    }

    public static boolean addUser(Usuario user) {
        if (db != null) {
            try {
                db.store(user);
                db.commit();
                return true;
            } catch (UniqueFieldValueConstraintViolationException ex) {
                Utils.errorMsg("Usuario incorrecto!", "Usuario ya ingresado en el sistema!");
                db.rollback();
            }
        }
        return false;
    }

    public void conectar() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();

            config.common().add(new UniqueFieldValueConstraint(Usuario.class, "user"));
        /*    config.common().objectClass(Usuario.class).objectField("password").indexed(true);
            config.common().add(new UniqueFieldValueConstraint(Usuario.class, "password"));*/
            config.common().objectClass(ServerConfig.class).objectField("users").cascadeOnDelete(true);
            config.common().objectClass(ServerConfig.class).objectField("users").cascadeOnUpdate(true);

            db = Db4oEmbedded.openFile(config, DB_CONFIG_FILE);
            final Query query = db.query();
            query.constrain(ServerConfig.class);
            List<ServerConfig> data = query.execute();
            if (!data.isEmpty()) {
                serverconfig = data.get(0);
            }
        } catch (Db4oIOException | DatabaseFileLockedException | DatabaseReadOnlyException ex) {
            Utils.errorMsg("Error en Base de Datos...", "Archivo Bloqueado!\nERROR:" + ex.getMessage());
        } catch (IncompatibleFileFormatException | OldFormatException ex) {
            Utils.errorMsg("Error en Base de Datos...", "Version no compatible!\nERROR:" + ex.getMessage());
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
}

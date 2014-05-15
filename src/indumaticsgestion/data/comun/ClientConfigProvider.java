package indumaticsgestion.data.comun;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import java.util.List;

public class ClientConfigProvider {

    private static ClientConfigProvider instance = null;
    private static ClientConfig config = null;
    private static final String DB_CONFIG_FILE = "clientconfig.db4o";
    private static ObjectContainer db = null;

    private ClientConfigProvider() {
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new ClientConfigProvider();
            instance.conectar();
        }
    }

    public void conectar() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB_CONFIG_FILE);
        final Query query = db.query();
        query.constrain(ClientConfig.class);
        List<ClientConfig> data = query.execute();
        if (!data.isEmpty()) {
            config = data.get(0);
        } else {
            config = new ClientConfig();
            db.store(config);
        }
    }

    public static void setConfig(ClientConfig data) {
        if (db != null) {
            db.delete(config);
            config = data;
            db.store(config);
        }
    }

    public static ClientConfig getInstance() {
        if (instance == null) {
            createInstance();
        }
        return config;
    }

    public static void deconectar() {
        if (db != null) {
            db.close();
            instance = null;
        }
    }

}

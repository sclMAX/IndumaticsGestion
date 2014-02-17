package indumaticsgestion.servidor.clases;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author Maxi
 */
public class ServerConfigProvider {

    String dbfile = "svrconfig.db4o";
    ObjectContainer db = null;

    public ServerConfigProvider() {
    }

    public void save(ServerConfig data) {
        db = Db4oEmbedded.openFile(dbfile);
        try {
            ObjectSet<ServerConfig> r = db.queryByExample(ServerConfig.class);
            while (r.hasNext()) {
                db.delete(r.next());
            }
            db.commit();
            db.store(data);
            db.commit();
        } finally {
            db.close();
        }
    }

    public ServerConfig getConfig() {
        db = Db4oEmbedded.openFile(dbfile);
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
}

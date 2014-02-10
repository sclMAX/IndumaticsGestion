package indumaticsgestion.servidor.clases;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import indumaticsgestion.data.comun.Usuario;

/**
 *
 * @author max
 */
public class Servidor {

    private final ObjectSet<Usuario> users;
    private final String db ;
    private ObjectServer server = null;
    private final int port;
    private boolean runing = false;

    public boolean isRuning() {
        return runing;
    }

    public Servidor(String db, int port, ObjectSet<Usuario> users) throws DatabaseFileLockedException, DatabaseReadOnlyException, Db4oIOException, IncompatibleFileFormatException, OldFormatException {
       this.db = db;
       this.port = port;
       this.users = users;
    }

    public Boolean starServer() throws Exception {
        ServerConfiguration serverConfig = Db4oClientServer.newServerConfiguration();
        server = Db4oClientServer.openServer(serverConfig, db, port);
        while (users.hasNext()) {
            Usuario user = users.next();
            server.grantAccess(user.getUser(), user.getPassword());
        }
        runing = server != null;
        return isRuning();
    }

    public void stopServer() {
        if (server != null) {
            server.close();
            runing = false;
        }
    }
}

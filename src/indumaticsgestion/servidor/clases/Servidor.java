package indumaticsgestion.servidor.clases;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;
import indumaticsgestion.data.comun.Usuario;

/**
 *
 * @author max
 */
public class Servidor {

    private final ServerConfig config;
    private ObjectServer server = null;
    private boolean runing = false;

    public boolean isRuning() {
        return runing;
    }

    public Servidor(ServerConfig config){
        this.config = config;
    }

    public Boolean starServer() throws Exception {
        server = Db4oClientServer.openServer(getServerConfiguration(), config.getDbpath(), config.getPort());
        for (Usuario user : config.getUsers()) {
            server.grantAccess(user.getUser(), user.getPassword());
        }
        runing = server != null;
        return isRuning();
    }

    private ServerConfiguration getServerConfiguration() {
        ServerConfiguration sc = Db4oClientServer.newServerConfiguration();
        //AQUI la configuracion de los Objetos
        return sc;
    }

    public void stopServer() {
        if (server != null) {
            server.close();
            runing = false;
        }
    }
}

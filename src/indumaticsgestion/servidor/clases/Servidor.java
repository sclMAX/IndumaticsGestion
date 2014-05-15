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

    private static Servidor instance = null;
    private static  ServerConfig config = ServerConfigProvider.getInstance();
    private static ObjectServer server = null;

    private Servidor(){ }
    
    private synchronized static void createInstance() {
		if (instance == null) {
			instance = new Servidor();
			instance.starServer();
		}
	}

    public void starServer(){
        server = Db4oClientServer.openServer(getServerConfiguration(), config.getDbpath(), config.getPort());
        for (Usuario user : config.getUsers()) {
            server.grantAccess(user.getUser(), user.getPassword());
        }
    }
    public static ObjectServer getInstance(){
        if(instance == null){
            createInstance();
        }
        return server;
    }

    private ServerConfiguration getServerConfiguration() {
        ServerConfiguration sc = Db4oClientServer.newServerConfiguration();
        //AQUI la configuracion de los Objetos
        return sc;
    }

    public static  void stopServer() {
        if (server != null) {
            server.close();
        }
        ServerConfigProvider.desconectar();
    }
    public void setConfig(ServerConfig config){
        this.config = config;
    }
}

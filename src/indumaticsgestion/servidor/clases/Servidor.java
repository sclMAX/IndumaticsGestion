package indumaticsgestion.servidor.clases;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import indumaticsgestion.data.comun.Usuario;
import indumaticsgestion.data.comun.Utils;

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
        try{
        server = Db4oClientServer.openServer(getServerConfiguration(), config.getDbpath(), config.getPort());
        for (Usuario user : config.getUsers()) {
            server.grantAccess(user.getUser(), user.getPassword());
        }
        } catch (Db4oIOException | DatabaseFileLockedException | DatabaseReadOnlyException ex) {
                Utils.errorMsg("Error en Base de Datos...", "Archivo Bloqueado!\nERROR:" + ex.getMessage());
                instance = null;
            } catch (IncompatibleFileFormatException | OldFormatException ex) {
                Utils.errorMsg("Error en Base de Datos...", "Version no compatible!\nERROR:" + ex.getMessage());
                instance = null;
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
        ServerConfigProvider.setConfig(config);
        this.config = config;
    }
}

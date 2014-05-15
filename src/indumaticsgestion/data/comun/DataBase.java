/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.data.comun;

import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.InvalidPasswordException;
import com.db4o.ext.OldFormatException;

public class DataBase {

    private static DataBase instance = null;
    private static Usuario user = null;
    private static ClientConfig clientConfig = ClientConfigProvider.getInstance();
    private static ObjectContainer db = null;

    /**
     *
     * @param user
     * @param host
     */
    private DataBase() {
    }

    private static synchronized void createInstance() throws InvalidPasswordException,
            Db4oIOException, DatabaseFileLockedException, DatabaseReadOnlyException,
            IncompatibleFileFormatException, OldFormatException{
        if (instance == null) {
            instance = new DataBase();
            instance.conectar(user);
        }
    }

    public void conectar(Usuario user) throws InvalidPasswordException,
            Db4oIOException, DatabaseFileLockedException, DatabaseReadOnlyException,
            IncompatibleFileFormatException, OldFormatException{
        if (db != null) {
            desconectar();
            clientConfig = ClientConfigProvider.getInstance();
        }
        db = Db4oClientServer.openClient(Db4oClientServer.newClientConfiguration(),
                clientConfig.getHost().getHost(), clientConfig.getHost().getPort(),
                user.getUser(), user.getPassword());
    }

    public static void desconectar() {
        if (db != null) {
            db.close();
            ClientConfigProvider.deconectar();
            instance = null;
        }
    }

    public static ObjectContainer getInstance(Usuario user) throws InvalidPasswordException,
            Db4oIOException, DatabaseFileLockedException, DatabaseReadOnlyException,
            IncompatibleFileFormatException, OldFormatException{
        if (instance == null) {
            instance.user = user;
            createInstance();
        }
        return db;
    }

    public static ObjectContainer getInstance() throws InvalidPasswordException,
            Db4oIOException, DatabaseFileLockedException, DatabaseReadOnlyException,
            IncompatibleFileFormatException, OldFormatException {
        if (instance == null) {
            createInstance();
        }
        return db;
    }

}

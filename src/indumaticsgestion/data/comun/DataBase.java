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
import indumaticsgestion.guis.comun.dlgLogin;

public class DataBase {

    private static DataBase instance = null;
    private static Usuario user = null;
    private final ClientConfig clientConfig;

    private static ObjectContainer db = null;

    /**
     *
     * @param user
     * @param host
     */
    private DataBase() {
        this.clientConfig = ClientConfigProvider.getInstance();
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            if (user == null) {
                dlgLogin login = new dlgLogin(null, true);
                login.setVisible(true);
                if (login.returnStatus == dlgLogin.RET_OK) {
                    user = login.getUser();
                } else {
                    return;
                }
            }
            try {
                instance = new DataBase();
                instance.conectar();
            } catch (InvalidPasswordException ex) {
                Utils.errorMsg("Login...", "Usuario o Password Incorrectos!");
                instance = null;
                user = null;
            }
        }
    }

    public void conectar() throws InvalidPasswordException {
        db = Db4oClientServer.openClient(clientConfig.getHost().getHost(), clientConfig.getHost().getPort(), user.getUser(), user.getPassword());
    }

    public static void desconectar() {
        if (db != null) {
            db.close();
            ClientConfigProvider.deconectar();
            instance = null;
        }
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

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

/**
 *
 * @author Maxi
 */
public class DataBase {
    private final Usuario user;
    private final Host host;

    /**
     *
     * @param user
     * @param host
     */
    public DataBase(Usuario user, Host host) {
        this.user = user;
        this.host = host;
    }

    /**
     *
     * @return
     * @throws DatabaseFileLockedException
     * @throws DatabaseReadOnlyException
     * @throws Db4oIOException
     * @throws IncompatibleFileFormatException
     * @throws OldFormatException
     */
    public  ObjectContainer getDB()
            throws DatabaseFileLockedException, DatabaseReadOnlyException,
            Db4oIOException, IncompatibleFileFormatException, OldFormatException,InvalidPasswordException {
        ObjectContainer db = Db4oClientServer.openClient(Db4oClientServer.newClientConfiguration(),
                host.getHost(), host.getPort(),user.getUser(), user.getPassword());
        return db;
    }

}

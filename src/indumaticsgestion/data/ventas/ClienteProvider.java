/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.data.ventas;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Query;
import indumaticsgestion.data.comun.DataBase;

/**
 *
 * @author Maxi
 */
public class ClienteProvider {

    private static ObjectContainer db;

    public static int add(Cliente data) {
        int result = -1;
        db = DataBase.getDB();
        data.setId(getNextId());
        db.store(data);
        return result;
    }

    public static int getNextId() throws DatabaseClosedException, DatabaseFileLockedException,
            DatabaseReadOnlyException, Db4oIOException, IncompatibleFileFormatException,
            OldFormatException {
        db = DataBase.getDB();
        try {
            int newid = 0;
            Query q = db.query();
            q.constrain(Cliente.class);
            q.descend("id").orderAscending();
            ObjectSet<Cliente> result = q.execute();
            if (result.iterator().hasNext()) {
                newid = result.get(result.size() - 1).getId() + 1;
            }
            return newid;
        } finally {
            db.close();
        }
    }
}

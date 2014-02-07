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

    /**
     *
     * @param data
     * @return
     */
    public static int add(Cliente data) {
        int result = -1;
        db = DataBase.getDB();
        result = getNextId(db);
        data.setId(result);
        db.store(data);
        db.commit();
        db.close();
        return result;

    }

    /**
     *
     * @param data
     */
    public static void update(Cliente data) {
        db = DataBase.getDB();
        db.store(data);
        db.commit();
        db.close();
    }

    /**
     *
     * @param data
     */
    public static void delete(Cliente data) throws DatabaseClosedException,
            DatabaseFileLockedException, DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, OldFormatException {
        db = DataBase.getDB();
        db.delete(data);
        db.commit();
        db.close();
    }

    public static ObjectSet<Cliente> getAll() throws DatabaseClosedException,
            DatabaseFileLockedException, DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, OldFormatException {
        ObjectSet<Cliente> result;
        db = DataBase.getDB();
        result = db.queryByExample(Cliente.class);
        db.close();
        return result;
    }

    public static ObjectSet<Cliente> search(String consulta) throws DatabaseClosedException,
            DatabaseFileLockedException, DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, OldFormatException {
        ObjectSet<Cliente> result;
        db = DataBase.getDB();
        try {
            Query q = db.query();
            q.constrain(Cliente.class);
            q.descend("id").constrain(consulta).like()
                    .or(q.descend("nombre").constrain(consulta).like())
                    .or(q.descend("zona").constrain(consulta).like());
            result = q.execute();
            return result;
        } finally {
            db.close();
        }
    }

    public static int getNextId(ObjectContainer db) throws DatabaseClosedException, DatabaseFileLockedException,
            DatabaseReadOnlyException, Db4oIOException, IncompatibleFileFormatException,
            OldFormatException {
        int newid = -1;
        Query q = db.query();
        q.constrain(Cliente.class);
        q.descend("id").orderAscending();
        final ObjectSet<Cliente> result;
        result = q.execute();
        if (result.iterator().hasNext()) {
            newid = result.get(result.size() - 1).getId() + 1;
        }
        return newid;
        
    }

}

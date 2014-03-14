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
import indumaticsgestion.data.comun.Provider;

/**
 *
 * @author Maxi
 */
public class ClienteProvider extends Provider {

    public ClienteProvider(DataBase db) {
        super(db);
    }

   
    public void add(Object data) throws DatabaseClosedException, DatabaseReadOnlyException {
        Cliente cl = (Cliente)data;
     //   cl.setId(getNextId());
        data = cl;
    }

//    public int getNextId() throws DatabaseClosedException, DatabaseFileLockedException,
//            DatabaseReadOnlyException, Db4oIOException, IncompatibleFileFormatException,
//            OldFormatException {
//        int newid = -1;
//        Query q = this.getDb().query();
//        q.constrain(Cliente.class);
//        q.descend("id").orderAscending();
//        final ObjectSet<Cliente> result;
//        result = q.execute();
//        if (result.iterator().hasNext()) {
//            newid = result.get(result.size() - 1).getId() + 1;
//        }
//        return newid;
//    }
}

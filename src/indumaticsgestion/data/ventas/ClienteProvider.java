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
import indumaticsgestion.data.comun.Provider;

/**
 *
 * @author Maxi
 */
public class ClienteProvider extends Provider {

    public ClienteProvider(ObjectContainer db) {
        super(db);
    }

    @Override
    public void add(Object data) throws DatabaseClosedException, DatabaseReadOnlyException {
        Cliente cl = (Cliente)data;
        cl.setId(getNextId());
        data = cl;
        super.add(data); 
    }
    
    

    public ObjectSet<Cliente> search(String consulta) throws DatabaseClosedException,
            DatabaseFileLockedException, DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, OldFormatException {
        Query q = this.getDb().query();
        q.constrain(Cliente.class);
        q.descend("id").constrain(consulta).like()
                .or(q.descend("nombre").constrain(consulta).like())
                .or(q.descend("zona").constrain(consulta).like());
        return q.execute();
    }

    public int getNextId() throws DatabaseClosedException, DatabaseFileLockedException,
            DatabaseReadOnlyException, Db4oIOException, IncompatibleFileFormatException,
            OldFormatException {
        int newid = -1;
        Query q = this.getDb().query();
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

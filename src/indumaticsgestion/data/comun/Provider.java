package indumaticsgestion.data.comun;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;

/**
 *
 * @author Maxi
 */
public class Provider {

    /**
     *
     */
    private final ObjectContainer db;

    public Provider(ObjectContainer db) {
        this.db = db;
    }

    public ObjectContainer getDb() {
        return db;
    }

    public void add(Object data) throws DatabaseClosedException, DatabaseReadOnlyException {
        db.store(data);
    }

    public void update(Object data) throws DatabaseClosedException, DatabaseReadOnlyException {
        db.store(data);
    }

    public void delete(Object data) throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.delete(data);
    }

    public ObjectSet<Object> getAll(Object data) throws DatabaseClosedException, Db4oIOException {
        return db.queryByExample(data.getClass());
    }

    public void commit() throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.commit();
    }

    public void rollback() throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.rollback();
    }

}

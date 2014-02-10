package indumaticsgestion.data.comun;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Query;

/**
 *
 * @author Maxi
 */
public class LocalidadProvider extends Provider {

    /**
     *
     * @param db
     */
    public LocalidadProvider(ObjectContainer db) {
        super(db);
    }

    /**
     *
     * @param consulta
     * @return
     * @throws DatabaseClosedException
     * @throws DatabaseFileLockedException
     * @throws DatabaseReadOnlyException
     * @throws Db4oIOException
     * @throws IncompatibleFileFormatException
     * @throws OldFormatException
     */
    public ObjectSet<Localidad> search(String consulta)
            throws DatabaseClosedException, DatabaseFileLockedException,
            DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, OldFormatException {

        final Query query;
        query = this.getDb().query();
        query.constrain(Localidad.class);
        query.descend("localidad").constrain(consulta).like()
                .or(query.descend("provincia").constrain(consulta).like())
                .or(query.descend("pais").constrain(consulta).like());
         return query.execute();
    }

    public ObjectSet<Localidad> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

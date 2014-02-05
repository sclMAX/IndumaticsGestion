package indumaticsgestion.data.comun;

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
public class LocalidadProvider {

    public static ObjectSet<Localidad> getAll()
            throws DatabaseClosedException, DatabaseFileLockedException, DatabaseReadOnlyException,
            Db4oIOException, IncompatibleFileFormatException, OldFormatException {
         ObjectSet<Localidad> result = DataBase.getDB().queryByExample(Localidad.class);
        DataBase.getDB().close();
        return result;
    }

    public static ObjectSet<Localidad> search(String consulta)
            throws DatabaseClosedException, DatabaseFileLockedException,
            DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, OldFormatException {

        final Query query = DataBase.getDB().query();
        query.constrain(Localidad.class);
        query.descend("localidad").constrain(consulta).like()
                .or(query.descend("provincia").constrain(consulta).like())
                .or(query.descend("pais").constrain(consulta).like());

        ObjectSet<Localidad> result = query.execute();
        DataBase.getDB().close();
        return result;
    }

}

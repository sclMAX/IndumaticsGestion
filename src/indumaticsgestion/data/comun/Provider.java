package indumaticsgestion.data.comun;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.InvalidPasswordException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import indumaticsgestion.data.comun.annotations.SearchLike;
import java.lang.reflect.Field;

/**
 *
 * @author Maxi
 */
public class Provider {

    /**
     *
     */
    private final DataBase db;
    private final ObjectContainer connection;

    public Provider(DataBase db) throws DatabaseFileLockedException,
            DatabaseReadOnlyException, Db4oIOException,
            IncompatibleFileFormatException, InvalidPasswordException,
            OldFormatException, UniqueFieldValueConstraintViolationException {
        this.db = db;
        this.connection = db.getDB();
    }

    public void store(Object data) throws UniqueFieldValueConstraintViolationException {
        connection.store(data);
    }

    public void delete(Object data) {
        connection.delete(data);
    }

    public ObjectSet<Object> getAll(Object data) {
        return connection.queryByExample(data);
    }

    /**
     *
     * @param objeto Donde buscar
     * @param consulta Que buscar
     * @return
     */
    public ObjectSet<Object> serach(Object objeto, String consulta) {
        Query qr = connection.query();
        qr.constrain(objeto.getClass());

        Field[] fields;
        fields = objeto.getClass().getFields();
        Constraint con;
        con = null;
        for (Field field : fields) {
            SearchLike annot = field.getAnnotation(SearchLike.class);
            if (annot != null) {
                String fieldname = field.getName();
                if (con == null) {
                    con = qr.descend(fieldname).constrain(consulta).like();
                }
                con.or(qr.descend(fieldname).constrain(consulta).like());
            }
        }
        qr.constrain(con);
        return qr.execute();
    }
}

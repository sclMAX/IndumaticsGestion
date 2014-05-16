package indumaticsgestion.data.ventas;

import indumaticsgestion.data.comun.DataBase;
import indumaticsgestion.data.comun.Provider;

/**
 *
 * @author Maxi
 */
public class ClienteProvider extends Provider {

    public ClienteProvider() {
        super();
    }

   
    public void add(Object data) {
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

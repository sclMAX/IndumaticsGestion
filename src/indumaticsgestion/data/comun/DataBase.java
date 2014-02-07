/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.data.comun;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;

/**
 *
 * @author Maxi
 */
public class DataBase {

    public static ObjectContainer getDB()
            throws DatabaseFileLockedException, DatabaseReadOnlyException,
            Db4oIOException, IncompatibleFileFormatException, OldFormatException 
    {
        ObjectContainer db = Db4oEmbedded.openFile("C:\\indumatics.db4o");
        return db;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion;

import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.InvalidPasswordException;
import com.db4o.ext.OldFormatException;
import indumaticsgestion.data.comun.DataBase;
import indumaticsgestion.data.comun.Host;
import indumaticsgestion.data.comun.Utils;
import indumaticsgestion.guis.comun.dlgLogin;
import indumaticsgestion.guis.principal.VentanaPrincipal;

/**
 *
 * @author Maxi
 */
public class IndumaticsGestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
        dlgLogin login;
        Host host;
        host = new Host("localhost",8080);
        login = new dlgLogin(null, true);
        login.setVisible(true);
        if (login.returnStatus == dlgLogin.RET_OK) {
            try {
                DataBase db = new DataBase(login.getUser(), host);
                new VentanaPrincipal(db).setVisible(true);
                return;
            } catch (Db4oIOException | DatabaseFileLockedException | DatabaseReadOnlyException ex) {
                Utils.errorMsg("Error en Base de Datos...", "Archivo Bloqueado!\nERROR:" + ex.getMessage());
            } catch (IncompatibleFileFormatException | OldFormatException ex) {
                Utils.errorMsg("Error en Base de Datos...", "Version no compatible!\nERROR:" + ex.getMessage());
            }  catch (InvalidPasswordException ex) {
                Utils.errorMsg("Login...", "Usuario o Password Incorrectos!");
            }
        }else{
            return;
        }
        }
    }

}

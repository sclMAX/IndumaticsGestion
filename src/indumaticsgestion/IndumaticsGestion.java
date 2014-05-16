/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion;

import indumaticsgestion.data.comun.DataBase;
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
<<<<<<< HEAD
        for(int i=0; i<3;i++){
        Object obj = DataBase.getInstance();
        if (obj != null) {
            new VentanaPrincipal().setVisible(true);
=======
        for(int i=0;i<3;i++){
        dlgLogin login;
        Host host;
        host = new Host("localhost",8080);
        login = new dlgLogin(null, true);
        login.setVisible(true);
        if (login.returnStatus == dlgLogin.RET_OK) {
            try {
                DataBase.getInstance(login.getUser());
                new VentanaPrincipal().setVisible(true);
                return;
            } catch (Db4oIOException | DatabaseFileLockedException | DatabaseReadOnlyException ex) {
                Utils.errorMsg("Error en Base de Datos...", "Archivo Bloqueado!\nERROR:" + ex.getMessage());
            } catch (IncompatibleFileFormatException | OldFormatException ex) {
                Utils.errorMsg("Error en Base de Datos...", "Version no compatible!\nERROR:" + ex.getMessage());
            }  catch (InvalidPasswordException ex) {
                Utils.errorMsg("Login...", "Usuario o Password Incorrectos!");
            }
        }else{
>>>>>>> d5bafe3dfec88665d1311b634d88ee3070bd35bb
            return;
        }
        }
    }

}

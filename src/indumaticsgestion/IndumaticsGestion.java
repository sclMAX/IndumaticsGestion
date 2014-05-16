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
        for(int i=0; i<3;i++){
        Object obj = DataBase.getInstance();
        if (obj != null) {
            new VentanaPrincipal().setVisible(true);
            return;
        }
        }
    }

}

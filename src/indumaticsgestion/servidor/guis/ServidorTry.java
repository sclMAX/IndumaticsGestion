/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.servidor.guis;

import com.db4o.ObjectServer;
import indumaticsgestion.servidor.clases.Servidor;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maxi
 */
public class ServidorTry {

    public static ObjectServer server = Servidor.getInstance();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()  {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            ServidorMain servidorgui;
            servidorgui = new ServidorMain(null, true);
            servidorgui.setLocationRelativeTo(null);
            servidorgui.setVisible(true);
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_on_16x16.gif", "INDUMATICS Server ON"));

        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem menuAbrir = new MenuItem("Opciones");
        MenuItem menuExit = new MenuItem("Cerrar");

        //Add components to popup menu
        popup.add(menuAbrir);
        popup.addSeparator();
        popup.add(menuExit);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("INDUMATICS Server");
            setTrayIconEstado(server != null, trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server != null) {
                    setTrayIconEstado(true, trayIcon);
                } else {
                    setTrayIconEstado(false, trayIcon);
                }
            }
        });

        menuAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServidorMain servidorgui = new ServidorMain(null, true);
                servidorgui.setLocationRelativeTo(null);
                servidorgui.setVisible(true);
            }
        });
        
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Servidor.stopServer();
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }

    protected static void setTrayIconEstado(boolean state, TrayIcon trayIcon) {
        if (state) {
            final TrayIcon trayIconOn = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_on_16x16.gif", "INDUMATICS Server ON"));
            trayIcon.setImage(trayIconOn.getImage());
            trayIcon.setToolTip("INDUMATICS Server ON");
            trayIcon.displayMessage("INDUMATICS Server", "Servidor en linea!", TrayIcon.MessageType.INFO);
        } else {
            final TrayIcon trayIconOff = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_off_16x16.gif", "INDUMATICS Server OFF"));
            trayIcon.setImage(trayIconOff.getImage());
            trayIcon.setToolTip("INDUMATICS Server OFF");
            trayIcon.displayMessage("INDUMATICS Server", "Servidor Desconectado!", TrayIcon.MessageType.WARNING);
        }
    }

    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = ServidorTry.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.servidor.guis;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maxi
 */
public class ServidorTry {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            ServidorMain servidorgui = new ServidorMain();
            servidorgui.setLocationRelativeTo(null);
            servidorgui.setDefaultCloseOperation(EXIT_ON_CLOSE);
            servidorgui.setVisible(true);
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_on_48x48.gif", "INDUMATICS Server ON"));
         final TrayIcon trayIconOn = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_on_48x48.gif", "INDUMATICS Server ON"));
        final TrayIcon trayIconOff = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_off_48x48.gif", "INDUMATICS Server OFF"));
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem menuAbrir = new MenuItem("Opciones");
        MenuItem menuStart = new MenuItem("Iniciar");
        MenuItem menuStop = new MenuItem("Parar");
        MenuItem menuExit = new MenuItem("Cerrar");

        //Add components to popup menu
        popup.add(menuAbrir);
        popup.add(menuStart);
        popup.addSeparator();
        popup.add(menuStart);
        popup.add(menuStop);
        popup.addSeparator();
        popup.add(menuExit);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("INDUMATICS Server");
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CORRER SERVIDOR
            }
        });

        menuAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServidorMain servidorgui = new ServidorMain();
                servidorgui.setLocationRelativeTo(null);
                servidorgui.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                servidorgui.setVisible(true);
            }
        });
        menuStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trayIcon.setImage(trayIconOn.getImage());
                trayIcon.setToolTip("INDUMATICS Server ON");
            }
        });

        menuStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trayIcon.setImage(trayIconOff.getImage());
                trayIcon.setToolTip("INDUMATICS Server OFF");
            }
        });

        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
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

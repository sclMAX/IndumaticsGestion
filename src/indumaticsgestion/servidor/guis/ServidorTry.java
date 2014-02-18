/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.servidor.guis;

import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import indumaticsgestion.data.comun.Utils;
import indumaticsgestion.servidor.clases.ServerConfig;
import indumaticsgestion.servidor.clases.ServerConfigProvider;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maxi
 */
public class ServidorTry {

    public static ServerConfig config;
    public static Servidor server = null;

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
        final ServerConfigProvider provider = new ServerConfigProvider();

        config = provider.getConfig();
        if (config != null) {
            server = new Servidor(config);
            try {
                server.starServer();
            } catch (Exception ex) {
                Utils.errorMsg("Error al iniciar el Servidor", "Error:"+ex.getMessage());
            }
        }
        if (!SystemTray.isSupported()) {
            ServidorMain servidorgui;
            servidorgui = new ServidorMain(null, true, config);
            servidorgui.setLocationRelativeTo(null);
            servidorgui.setVisible(true);
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(createImage("/indumaticsgestion/recursos/iconos/logoServidor_on_16x16.gif", "INDUMATICS Server ON"));

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
            setTrayIconEstado((server != null && server.isRuning()), trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server != null && server.isRuning()) {
                    setTrayIconEstado(true, trayIcon);
                } else {
                    setTrayIconEstado(false, trayIcon);
                }
            }
        });

        menuAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                config = provider.getConfig();
                ServidorMain servidorgui = new ServidorMain(null, true, config);
                servidorgui.setLocationRelativeTo(null);
                servidorgui.setVisible(true);
                if (servidorgui.returnStatus == ServidorMain.RET_OK) {
                    config = servidorgui.getConfig();
                    try{
                        provider.save(config);
                    }catch(UniqueFieldValueConstraintViolationException ex){
                        Utils.errorMsg("Error al guardar...", "Nombre de usuario Existente!");
                        config = provider.getConfig();
                        server.setConfig(config);
                    }
                    if(server!=null){
                        server.stopServer();
                        server = new Servidor(config);
                        try {
                            setTrayIconEstado(server.starServer(), trayIcon);
                        } catch (Exception ex) {
                            Logger.getLogger(ServidorTry.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        menuStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server != null) {
                    try {
                        setTrayIconEstado(server.starServer(), trayIcon);
                    } catch (Exception ex) {
                        Logger.getLogger(ServidorTry.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        menuStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server != null) {
                    server.stopServer();
                }
                setTrayIconEstado(false, trayIcon);
            }
        });

        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        if (config == null) {
            ServidorMain sm = new ServidorMain(null, true, config);
            sm.setVisible(true);
            if (sm.returnStatus == ServidorMain.RET_OK) {
                config = sm.getConfig();
            }
        }
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

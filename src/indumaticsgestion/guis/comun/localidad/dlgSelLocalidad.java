/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.guis.comun.localidad;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import indumaticsgestion.data.comun.Localidad;
import indumaticsgestion.data.comun.LocalidadProvider;
import indumaticsgestion.data.comun.Utils;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Maxi
 */
public class dlgSelLocalidad extends java.awt.Dialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    public int returnStatus = RET_CANCEL;
    public Localidad localidad = null;
    private final ObjectContainer db;
    private final LocalidadProvider provider;

    /**
     * Creates new form dlgBase
     *
     * @param parent
     * @param modal
     * @param localidad
     * @param db
     */
    public dlgSelLocalidad(java.awt.Frame parent, boolean modal, Localidad localidad, ObjectContainer db) {
        super(parent, modal);
        initComponents();
        this.localidad = localidad;
        this.db = db;
        this.setLocationRelativeTo(null);
        setIconImage(Utils.iconToImage(jlLogo.getIcon()));
        this.provider = new LocalidadProvider();
        try {
  //          cargarTablaLocalidades(provider.getAll());
        } catch (DatabaseClosedException | DatabaseFileLockedException |
                DatabaseReadOnlyException | Db4oIOException |
                IncompatibleFileFormatException | OldFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error en la Base de Datos ERROR:" + ex.getMessage(),
                    "Error en Base de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlLogo = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jtBarraComandos = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jtBuscar = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAdd = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jpContenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 153, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setOpaque(false);

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/zone.gif"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_ok_48x48.gif"))); // NOI18N
        btnOk.setBorder(null);
        btnOk.setFocusable(false);
        btnOk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOk.setOpaque(false);
        btnOk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOk);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_cancel_48x48.gif"))); // NOI18N
        btnCancel.setBorder(null);
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setOpaque(false);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlLogo))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtBarraComandos.setFloatable(false);
        jtBarraComandos.setRollover(true);
        jtBarraComandos.setOpaque(false);
        jtBarraComandos.add(jSeparator1);

        jtBuscar.setMaximumSize(new java.awt.Dimension(200, 2147483647));
        jtBuscar.setMinimumSize(new java.awt.Dimension(150, 20));
        jtBuscar.setPreferredSize(new java.awt.Dimension(150, 20));
        jtBarraComandos.add(jtBuscar);
        jtBarraComandos.add(jSeparator5);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_search_24x24.gif"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setOpaque(false);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jtBarraComandos.add(btnBuscar);

        jPanel2.setMaximumSize(new java.awt.Dimension(100, 32767));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(50, 10));
        jtBarraComandos.add(jPanel2);
        jtBarraComandos.add(jSeparator2);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_add_24x24.gif"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setOpaque(false);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jtBarraComandos.add(btnAdd);
        jtBarraComandos.add(jSeparator3);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_edit_24x24.gif"))); // NOI18N
        btnEdit.setBorder(null);
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setOpaque(false);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jtBarraComandos.add(btnEdit);
        jtBarraComandos.add(jSeparator4);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_delete_24x24.gif"))); // NOI18N
        btnDelete.setBorder(null);
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setOpaque(false);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtBarraComandos.add(btnDelete);

        jPanel3.setOpaque(false);
        jtBarraComandos.add(jPanel3);

        jpContenido.setOpaque(false);

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
            jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        jpContenidoLayout.setVerticalGroup(
            jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtBarraComandos, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtBarraComandos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (localidad != null) {
            doClose(RET_OK);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Loclaidad!");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        cargarContenido(new LocalidadAM(null, this));
        setEnable(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (localidad != null) {
            cargarContenido(new LocalidadAM(localidad, this));
            setEnable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Loclaidad!");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       // cargarTablaLocalidades(provider.search(jtBuscar.getText()));
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public void setEnable(boolean b) {
        btnBuscar.setEnabled(b);
        jtBuscar.setEditable(b);
        btnAdd.setEnabled(b);
        btnEdit.setEnabled(b);
        btnDelete.setEnabled(b);
        btnOk.setEnabled(b);
    }

    private void cargarTablaLocalidades(ObjectSet<Localidad> data) {
        cargarContenido(new LocalidadesLista(this, data));
    }

    private void cargarContenido(JPanel data) {
        data.setVisible(true);
        jpContenido.removeAll();
        jpContenido.setLayout(new BorderLayout());
        jpContenido.add(data);
        jpContenido.validate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dlgSelLocalidad dialog = new dlgSelLocalidad(new java.awt.Frame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JToolBar jtBarraComandos;
    private javax.swing.JTextField jtBuscar;
    // End of variables declaration//GEN-END:variables
}

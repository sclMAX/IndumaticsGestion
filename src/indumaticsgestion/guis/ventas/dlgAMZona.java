package indumaticsgestion.guis.ventas;

import indumaticsgestion.guis.comun.*;
import indumaticsgestion.data.comun.Zona;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxi
 */
public class dlgAMZona extends java.awt.Dialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    public int returnStatus = RET_CANCEL;
    private Zona zona = null;
    

    /**
     * Creates new form dlgAMTelefono
     *
     * @param parent
     * @param modal
     * @param zona
     */
    public dlgAMZona(java.awt.Frame parent, boolean modal, Zona zona) {
        super(parent, modal);
        initComponents();
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("indumaticsgestion/recursos/strings"); // NOI18N
        if (zona != null) {
            this.setTitle(bundle.getString("zonaInsert"));
            zona = new Zona(null, null);
        } else {
            this.setTitle(bundle.getString("zonaEdit"));
            this.zona = zona;
            setData();
        }
    }

    private void setData() {
        jtZona.setText(zona.getEmail());
        jtaComentario.setText(zona.getComentario());
    }

    private void getData() throws Exception {
        zona.setEmail(jtZona.getText());
        zona.setComentario(jtaComentario.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        frmIcon = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtZona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaComentario = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(216, 241, 248));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("indumaticsgestion/recursos/strings"); // NOI18N
        setTitle(bundle.getString("")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setOpaque(false);

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar3.setRollover(true);
        jToolBar3.setAutoscrolls(true);
        jToolBar3.setMinimumSize(new java.awt.Dimension(32, 60));
        jToolBar3.setOpaque(false);

        frmIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/zone.gif"))); // NOI18N
        frmIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        frmIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        frmIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        frmIcon.setPreferredSize(new java.awt.Dimension(50, 50));
        jToolBar3.add(frmIcon);

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_ok_48x48.gif"))); // NOI18N
        btnOk.setToolTipText(bundle.getString("btnOktooltip")); // NOI18N
        btnOk.setFocusable(false);
        btnOk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOk.setMaximumSize(new java.awt.Dimension(50, 50));
        btnOk.setMinimumSize(new java.awt.Dimension(50, 50));
        btnOk.setOpaque(false);
        btnOk.setPreferredSize(new java.awt.Dimension(50, 50));
        btnOk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOk);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indumaticsgestion/recursos/iconos/btn_cancel_48x48.gif"))); // NOI18N
        btnCancel.setToolTipText(bundle.getString("btnCanceltooltip")); // NOI18N
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setMaximumSize(new java.awt.Dimension(50, 50));
        btnCancel.setMinimumSize(new java.awt.Dimension(50, 50));
        btnCancel.setOpaque(false);
        btnCancel.setPreferredSize(new java.awt.Dimension(50, 50));
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
                .addGap(4, 4, 4)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        jLabel1.setText(bundle.getString("zonaNombre")); // NOI18N
        jLabel1.setToolTipText("");

        jtZona.setToolTipText("");

        jLabel2.setText(bundle.getString("emailComentario")); // NOI18N

        jtaComentario.setColumns(20);
        jtaComentario.setRows(5);
        jScrollPane1.setViewportView(jtaComentario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtZona)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        try {
            getData();
            doClose(RET_OK);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Datos No Validos...", JOptionPane.WARNING_MESSAGE);
            jtZona.requestFocus();
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public Zona getZona() {
        return this.zona;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dlgAMTelefono dialog = new dlgAMTelefono(new java.awt.Frame(), true, null);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel frmIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JTextField jtZona;
    private javax.swing.JTextArea jtaComentario;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clasesPrincipales.Entradas;
import clasesPrincipales.Salidas;
import clasesPrincipales.imagen;
import clasesPrincipales.imagen_salida;
import conMySql.entradaMySql;
import conMySql.salidaMySql;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import reportes.GenerarReportes;

/**
 *
 * @author Administrador
 */
public class Adjuntos_Salidas extends javax.swing.JFrame {

    private FileInputStream fis;
    private int longitudBytes;

    ArrayList<Salidas> salida;
    salidaMySql dbsalida = new salidaMySql();

    /**
     * Creates new form Adjuntos
     */
    public Adjuntos_Salidas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CPU System Service S.A.S - ADJUNTAR");
        CargarCmbSalida();
        txtIdSalida.setEnabled(false);
        txtCliente.setEnabled(false);
        txtFecha.setEnabled(false);
        txtModelo.setEnabled(false);
        txtSerie.setEnabled(false);
        
        btnSeleccionar.setVisible(false);
        btnGuardar.setVisible(false);
        lblFoto.setVisible(false);
    }

    public void CargarCmbSalida() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT numero FROM salidas ORDER BY numero DESC");
            while (rs.next()) {
                this.cmbSalidas.addItem(rs.getString("numero"));
            }
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        txtIdSalida.setText("");
        txtCliente.setText("");
        txtFecha.setText("");
        txtModelo.setText("");
        txtSerie.setText("");
        lblFoto.setText(null);
        btnSeleccionar.setVisible(false);
        btnGuardar.setVisible(false);
        lblFoto.setVisible(false);
    }
    
    public void habilitar() {
        btnSeleccionar.setVisible(true);
        btnGuardar.setVisible(true);
        lblFoto.setVisible(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        cmbSalidas = new javax.swing.JComboBox();
        btnBusca = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtIdSalida = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADJUNTAR SALIDA");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 11, 240, 29);
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(10, 41, 420, 10);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(290, 60, 60, 14);
        jPanel2.add(txtCliente);
        txtCliente.setBounds(30, 140, 290, 30);

        cmbSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSalidasActionPerformed(evt);
            }
        });
        jPanel2.add(cmbSalidas);
        cmbSalidas.setBounds(30, 80, 160, 30);

        btnBusca.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca.setBorder(null);
        btnBusca.setBorderPainted(false);
        btnBusca.setContentAreaFilled(false);
        btnBusca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusca.setIconTextGap(-1);
        btnBusca.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBusca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBusca);
        btnBusca.setBounds(200, 70, 33, 33);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(350, 120, 60, 14);
        jPanel2.add(txtIdSalida);
        txtIdSalida.setBounds(350, 140, 70, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("SERIE");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(240, 180, 60, 14);
        jPanel2.add(txtSerie);
        txtSerie.setBounds(240, 200, 180, 30);
        jPanel2.add(txtModelo);
        txtModelo.setBounds(30, 200, 180, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CLIENTE");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(30, 120, 60, 14);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("MODELO");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(30, 180, 60, 14);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(300, 300, 120, 40);
        jPanel2.add(txtFecha);
        txtFecha.setBounds(290, 80, 130, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ENTRADAS");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(30, 60, 60, 14);

        lblFoto.setBackground(new java.awt.Color(204, 204, 204));
        lblFoto.setForeground(new java.awt.Color(204, 204, 204));
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        jPanel2.add(lblFoto);
        lblFoto.setBounds(30, 260, 260, 240);

        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnSeleccionar.setText("Seleccionar...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeleccionar);
        btnSeleccionar.setBounds(300, 260, 120, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(303, 463, 120, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSalidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSalidasActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

        //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
        try {

            String guardar = cmbSalidas.getSelectedItem().toString();
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            //PreparedStatement pst = cn.prepareStatement("SELECT numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones, tarjeta FROM entradas where numero = ? ORDER BY 2");
            PreparedStatement pst = cn.prepareStatement("Select * from salidas where numero = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtFecha.setText(rs.getString("fecha").trim());
                txtCliente.setText(rs.getString("empresa").trim());
                txtModelo.setText(rs.getString("modelo").trim());
                txtSerie.setText(rs.getString("serie").trim());
                txtIdSalida.setText(rs.getString("id_salida"));
                habilitar();

                //pst.setString(1, CMBID.getName());
                //String guardar = txtBuscar.getText();
            } else {
                JOptionPane.showMessageDialog(null, "No existe la remision");
            }
            cn.close();
            st.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error:" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtIdSalida.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        }else{
            try {
            imagen_salida ima = new imagen_salida(this.fis, this.longitudBytes, Integer.parseInt(txtIdSalida.getText()));
            //ima.setNombre(this.txtNombreImagen.getText());
            //ima.setImagen(this.fis);
            //ima.setImagen(this.longitudBytes);

            dbsalida.adjuntarImagenINSERT(ima);
            JOptionPane.showMessageDialog(this, "Ingresado exitosamente");
            
            limpiar();
            lblFoto.setText(null);
            

        } catch (Exception e) {
            System.err.println("error" + e);
        }
        }
        
        
        /*
        if (txtIdEntrada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro ENTRADAS");
        } else {
            try {
                imagen ima = new imagen(this.fis, this.longitudBytes, Integer.parseInt(txtIdEntrada.getText()));
                
                //imagen ima = new imagen();
                //ima.setNombre(this.txtNombreImagen.getText());
                //ima.setImagen(this.fis);
                //ima.setImagen(this.longitudBytes);

                dbEntrada.adjuntarImagenUPDATE(ima);
                JOptionPane.showMessageDialog(this, "Ingresado exitosamente");
                limpiar();

            } catch (Exception e) {
                System.err.println("error" + e);
            }
        }
        */

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_lblFotoMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

        if (txtIdSalida.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro ENTRADAS");
        } else {

            JFileChooser se = new JFileChooser();
            se.setFileSelectionMode(JFileChooser.FILES_ONLY); // seleccionar solo archivos..
            int estado = se.showOpenDialog(null);// mostrar el cuadro de archivo..
            if (estado == JFileChooser.APPROVE_OPTION) { // si el usuario selecciono el archivo y dio ACEPTAR..
                try {
                    fis = new FileInputStream(se.getSelectedFile());
                    this.longitudBytes = (int) se.getSelectedFile().length();

                //Dimenciona la imagen a la dimencion del label "lblFoto"
                /*
                     Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                     lblFoto.setIcon(new ImageIcon(icono));
                     lblFoto.updateUI();
                     */
                    Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                    lblFoto.setIcon(new ImageIcon(icono));
                    lblFoto.updateUI();

                } catch (Exception e) {
                    System.out.println("error" + e);
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtIdSalida.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
           String nume = txtIdSalida.getText();
        int id = Integer.parseInt(nume);
        GenerarReportes g = new GenerarReportes();
        g.reporteIMAGEN_SALIDA(id); 
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adjuntos_Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adjuntos_Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adjuntos_Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adjuntos_Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adjuntos_Salidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cmbSalidas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdSalida;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}

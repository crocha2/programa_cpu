/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clasesPrincipales.Entradas;
import clasesPrincipales.Garantias;
import clasesPrincipales.clientes;
import conMySql.clienteMySql;
import conMySql.entradaMySql;
import conMySql.garantiaMySql;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import reportes.GenerarReportes;

/**
 *
 * @author CPU_SYS
 */
public class Editar_Entrada extends javax.swing.JFrame {

    ArrayList<Entradas> entrada;
    //entradaDB db = new entradaDB();
    entradaMySql db = new entradaMySql();

    ArrayList<clientes> cliente;
    //entradaDB dbcli = new entradaDB();
    clienteMySql dbcli = new clienteMySql();
    
    ArrayList<Garantias> garantia;
    //entradaDB dbgar = new entradaDB();
    garantiaMySql dbgar = new garantiaMySql();
    
    Tecnico tec = new Tecnico();

    //excel obj = new excel();
    /**
     * Creates new form Entrada
     */
    public Editar_Entrada() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CPU System Service S.A.S - FACTURAS DE ENTRADA");
        //CargarCmbCliente();
        txtSec.setEnabled(false);
        txtIdCli.setEnabled(false);
        traerDatos();
        txtEstado.setEnabled(false);
        txtGarantia.setEnabled(false);
    }

    public void traerDatos() {

        Tecnico obj = new Tecnico();
        txtIdCli.setText(obj.id_cli_entrada);
        txtSec.setText(obj.numero_entrada);
        txtFecha.setText(obj.fecha_entrada);
        txtElemento.setText(obj.elemento_entrada);
        txtMarca.setText(obj.marca_entrada);
        txtModelo.setText(obj.modelo_entrada);
        txtSerie.setText(obj.serie_entrada);
        txtGarantia.setText(obj.garantia_entrada);
        txtEmpresa.setText(obj.cliente_entrada);
        txtNitCliente.setText(obj.nit_entrada);
        txtTelefonoCliente.setText(obj.telefono_entrada);
        txtCorreoCliente.setText(obj.correo_entrada);
        areaObservaciones.setText(obj.observacion_entrada);
        txtEstado.setText(obj.estado_entrada);
        String estado = txtEstado.getText();
        String garan = txtGarantia.getText();
        try {
            if(estado.equals("REVISION")){
            cmbEditar_Entrada.setSelectedIndex(0);
        }
        if(estado.equals("PROCESO")){
            cmbEditar_Entrada.setSelectedIndex(1);
        }
        if(estado.equals("LISTO")){
            cmbEditar_Entrada.setSelectedIndex(2);
        }
        if(estado.equals("RECHAZADO")){
            cmbEditar_Entrada.setSelectedIndex(3);
        }
        } catch (Exception e) {
            System.out.println("error:"+e);
        }
        try {
            if(garan.equals("SI")){
                cmbGaran.setSelectedIndex(0);
            }
            if(garan.equals("NO")){
                cmbGaran.setSelectedIndex(1);
            }
        } catch (Exception e) {
        }
}
    
    public void comboEstado(){
        int posicion = cmbEditar_Entrada.getSelectedIndex();
        try {
            if(posicion == 0){
                txtEstado.setText("REVISION");
            }
            if(posicion == 1){
                txtEstado.setText("PROCESO");
            }
            if(posicion == 2){
                txtEstado.setText("LISTO");
            }
            if(posicion == 3){
                txtEstado.setText("RECHAZADO");
            }
            if(posicion == 4){
                txtEstado.setText("ENTREGADO");
            }
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }
    
    public void comboGarantia(){
        int posicion = cmbGaran.getSelectedIndex();
        try {
            if(posicion == 0){
                txtGarantia.setText("SI");
            }
            if(posicion == 1){
                txtGarantia.setText("NO");
            }
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    }

/*
 public void CargarCmbCliente() {
 try {
 Connection cnx = DataBaseConexion.getConnection();
 Statement st = cnx.createStatement();
 ResultSet rs = st.executeQuery("SELECT NOMBRECLIENTE FROM CLIENTES ORDER BY NOMBRECLIENTE ASC");
 while (rs.next()) {
 this.cmbClientes.addItem(rs.getString("nombrecliente"));
 }
 } catch (Exception e) {
 }
 }
 */
public void limpiar() {
        txtSec.setText("");
        txtNitCliente.setText("");
        txtEmpresa.setText("");
        txtTelefonoCliente.setText("");
        txtCorreoCliente.setText("");
        txtElemento.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtSerie.setText("");
        areaObservaciones.setText("");
        txtFecha.setText("");
        txtGarantia.setText("");
        areaObservaciones.setText("");
        txtIdCli.setText("");
        txtEstado.setText("");
        txtElemento.requestFocus();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtElemento = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtNitCliente = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObservaciones = new javax.swing.JTextArea();
        jSeparator9 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JTextField();
        txtGarantia = new javax.swing.JTextField();
        txtSec = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        cmbEditar_Entrada = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbGaran = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setText("Editar Entrada");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Elemento");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Modelo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Serie");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Empresa remitente");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NIT");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 30, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Garantia");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 50, 20));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 750, 10));
        getContentPane().add(txtElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 270, -1));
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 180, -1));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 210, -1));
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 230, -1));
        getContentPane().add(txtNitCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 210, -1));
        getContentPane().add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 270, -1));

        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 210, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Correo");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, 20));

        txtCorreoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 270, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Telefono");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 50, 20));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 310, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 153));
        jLabel22.setText("REVISIÓN DE LA MAQUINA");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 255, 153));
        jLabel24.setText("ID_CLI");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 50, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 255, 153));
        jLabel25.setText("No. REM");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Observaciones");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 20));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, 10));

        areaObservaciones.setColumns(20);
        areaObservaciones.setRows(5);
        jScrollPane1.setViewportView(areaObservaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 610, 110));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 260, 10));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 150, -1));
        getContentPane().add(txtGarantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 90, -1));
        getContentPane().add(txtSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("FECHA");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 40, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Marca");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 40, 20));
        getContentPane().add(txtIdCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Estado");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 40, 20));
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 120, -1));

        cmbEditar_Entrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REVISION", "PROCESO", "LISTO", "RECHAZADO", "ENTREGADO" }));
        cmbEditar_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEditar_EntradaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEditar_Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 100, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Estado");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 40, 20));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EDITAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 100, 50));

        cmbGaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        cmbGaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGaranActionPerformed(evt);
            }
        });
        getContentPane().add(cmbGaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 90, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Garantia");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 50, 20));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Entrada.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoClienteActionPerformed

    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void cmbEditar_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEditar_EntradaActionPerformed

        comboEstado();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEditar_EntradaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         try {
            Entradas en = new Entradas();
            clientes cli = new clientes();
            Garantias gar = new Garantias();

            en.setNumero(txtSec.getText().toUpperCase());
            en.setFecha(txtFecha.getText().toUpperCase());
            en.setElemento(txtElemento.getText().toUpperCase());
            en.setMarca(txtMarca.getText().toUpperCase());
            en.setModelo(txtModelo.getText().toUpperCase());
            en.setSerie(txtSerie.getText().toUpperCase());
            en.setEmpresa(txtEmpresa.getText().toUpperCase());
            en.setNit(txtNitCliente.getText().toUpperCase());
            en.setTelefono_contacto(txtTelefonoCliente.getText().toUpperCase());
            en.setCorreo(txtCorreoCliente.getText().toUpperCase());
            en.setGarantia(txtGarantia.getText().toUpperCase());
            en.setObservaciones(areaObservaciones.getText().toUpperCase());
            en.setEstado(txtEstado.getText().toUpperCase());
            en.setId_cli(Integer.parseInt(txtIdCli.getText()));

            cli.setId_cliente(Integer.parseInt(txtIdCli.getText()));
            cli.setNombre_cliente(txtEmpresa.getText().toUpperCase());
            cli.setNit_cliente(txtNitCliente.getText().toUpperCase());
            cli.setTelefono_cliente(txtTelefonoCliente.getText().toUpperCase());
            cli.setCorreo_cliente(txtCorreoCliente.getText().toUpperCase());
            
            gar.setFecha_entrada(txtFecha.getText().toUpperCase());
            gar.setCliente(txtEmpresa.getText().toUpperCase());
            gar.setNit(txtNitCliente.getText().toUpperCase());
            gar.setModelo(txtModelo.getText().toUpperCase());
            gar.setPrimera_serie(txtSerie.getText().toUpperCase());
            gar.setSerie_vieja(txtSerie.getText().toUpperCase());
            gar.setEstado(txtEstado.getText().toUpperCase());
            gar.setNumero(txtSec.getText().toUpperCase());

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea EDITAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                dbgar.EditarProceso(gar);
                db.EditarTablaEntrada(en);
                dbcli.EditarClienteEntrada(cli);
                limpiar();
                tec.LimpiarEntradas();
                tec.LimpiarEntradas_Garantias();
                tec.LimpiarGarantiasProceso();
                tec.ListarEntradas();
                tec.ListarEntradas_Garantias();
                tec.ListarGarantiasProceso();
                this.setVisible(false);
                
            } else {
                limpiar();
                this.setVisible(false);
            }  
        } catch (NumberFormatException | HeadlessException e) {
            System.out.println("error:"+e);
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbGaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGaranActionPerformed

        comboGarantia();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGaranActionPerformed

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
            java.util.logging.Logger.getLogger(Editar_Entrada.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar_Entrada.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar_Entrada.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar_Entrada.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editar_Entrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservaciones;
    private javax.swing.JComboBox cmbEditar_Entrada;
    private javax.swing.JComboBox cmbGaran;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtElemento;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNitCliente;
    private javax.swing.JTextField txtSec;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}

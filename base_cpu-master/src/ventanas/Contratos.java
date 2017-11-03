/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clasesPrincipales.Entradas;
import clasesPrincipales.clientes;
import clasesPrincipales.contratos;
import com.mxrck.autocompleter.TextAutoCompleter;
import conMySql.clienteMySql;
import conMySql.contratoMySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JR
 */
public class Contratos extends javax.swing.JFrame {

    ArrayList<contratos> contrato;
    //clienteDB db = new clienteDB();
    contratoMySql db = new contratoMySql();
    
    ArrayList<clientes> cliente;
    //clienteDB db = new clienteDB();
    clienteMySql dbcli = new clienteMySql();

    DefaultComboBoxModel modeloContrato;

    /**
     * Creates new form Tecnico
     */
    public Contratos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CPU System Service S.A.S - CONTRATOS");
        ListarDatos();
        ListarDatos2();
        autoCompleteCli();
        autoComplete();
        //autoCompletar();
        //cargarComboContratos();
        txtId.setEnabled(false);
    }

    public void limpiarCombo() {
        this.cmbHistorial.removeAllItems();
        //cargarComboContratos();
    }

    public void limpiar() {
        txtId.setText("");
        txtNumeroCont.setText("");
        //txtFechaInicial.setText("");
        //txtFechaFin.setText("");
        txtCliente.setText("");
        txtNitCed.setText("");
        txtResponsable.setText("");
        txtNumeroCont.requestFocus();
    }

    public void limpiar2() {
        txtId.setText("");
        txtNumeroContrato.setText("");
        txtCli.setText("");
        txtNitCe.setText("");
        txtResp.setText("");
        txtNumeroContrato.requestFocus();
    }

    public void autoCompleteCli() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(txtCli);
        //String guar = txtCli.getText();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = (Statement) cn.createStatement();
            //ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE nombre_cli like"+'"'+guar+'"'+"_%");
            ResultSet rs = st.executeQuery("SELECT nombre_cli, nit_cli FROM clientes");
            while (rs.next()) {
                TextAutoCompleter.addItem(rs.getString("nombre_cli"));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    /*
     public final void cargarComboContratos(){
     String [] con = {"NUMERO","CLIENTE","NIT O CEDULA","RESPONSABLE"};
     modeloContrato = new DefaultComboBoxModel(con);
     cmbHistorial.setModel(modeloContrato);
     }
     */
    public void autoCompletar() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(auto);
        int guardar = cmbHistorial.getSelectedIndex();
        switch (guardar) {
            case 0:
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("numero"));
                    }
                    //cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR EN NUMERO: " + e);
                }
                break;
            case 1:
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("cliente"));
                    }
                    // cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR EN CLIENTE: " + e);
                }
                break;
            case 2:
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("nit_ced"));
                    }
                    // cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR EN NIT-CEDULA: " + e);
                }
                break;
            case 3:
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("responsable"));
                    }
                    //cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR EN RESPONSABLE: " + e);
                }
                break;
            default:
                System.out.println("error");
                break;
        }

    }

    public void autoComplete() {

        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(auto);

        try {
            String guardar = cmbHistorial.getSelectedItem().toString();
            if (guardar.equals("NUMERO")) {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                Statement st = (Statement) cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                while (rs.next()) {
                    TextAutoCompleter.addItem(rs.getString("numero"));
                }
                cn.close();
            }
            if (guardar.equals("CLIENTE")) {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                Statement st = (Statement) cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                while (rs.next()) {
                    TextAutoCompleter.addItem(rs.getString("cliente"));
                }
                cn.close();
            }
            if ("NIT O CEDULA".equals(guardar)) {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                Statement st = (Statement) cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                while (rs.next()) {
                    TextAutoCompleter.addItem(rs.getString("nit_ced"));
                }
                cn.close();
            }
            if ("RESPONSABLE".equals(guardar)) {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                Statement st = (Statement) cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM contratos");
                while (rs.next()) {
                    TextAutoCompleter.addItem(rs.getString("responsable"));
                }
                cn.close();
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

    }

    public void ListarDatos() {
        contrato = db.ListContrato();
        DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
        for (contratos con : contrato) {
            tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
        }
    }

    public void ListarDatos2() {
        contrato = db.ListContrato();
        DefaultTableModel tb = (DefaultTableModel) tabla_contrato2.getModel();
        for (contratos con : contrato) {
            tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
        }
    }

    public void LimpiarTabla() {
        DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    public void LimpiarTabla2() {
        DefaultTableModel tb = (DefaultTableModel) tabla_contrato2.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroContrato = new javax.swing.JTextField();
        txtFechaIn = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFechaFi = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNitCe = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtResp = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtCli = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_contrato2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_contrato = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNumeroCont = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNitCed = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtResponsable = new javax.swing.JTextField();
        txtFechaInicial = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        auto = new javax.swing.JTextField();
        btnBusca3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cmbHistorial = new javax.swing.JComboBox();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CONTRATO");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("NO. CONTRATO");

        txtFechaIn.setDateFormatString("yyyy/MM/dd");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("FECHA INICIO");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("FECHA FINAL");

        txtFechaFi.setDateFormatString("yyyy/MM/dd");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("CLIENTE");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("NIT O CEDULA");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("RESPONSABLE");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton3.setText("BUSCAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroContrato)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addComponent(txtCli))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtFechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNitCe, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtFechaFi, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResp, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(txtFechaFi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNitCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(txtResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("GUARDAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tabla_contrato2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No. CONTRATO", "FECHA INICIO", "FECHA FINAL", "CLIENTE", "NIT - CEDULA", "RESPONSABLE"
            }
        ));
        jScrollPane1.setViewportView(tabla_contrato2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(330, 330, 330)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONTRATO", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        tabla_contrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NO. CONTRATO", "FECHA INICIO", "FECHA FINAL", "CLIENTE", "NIT O CEDULA", "RESPONSABLE"
            }
        ));
        tabla_contrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_contratoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_contrato);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("NO. CONTRATO");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("FECHA INICIO");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("FECHA FINAL");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("CLIENTE");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("NIT O CEDULA");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("RESPONSABLE");

        txtFechaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroCont, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtResponsable))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(txtFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtFechaFin)))
                    .addComponent(txtNitCed, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(6, 6, 6)
                        .addComponent(txtNumeroCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(txtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(6, 6, 6)
                        .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(26, 26, 26))
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNitCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CONTRATOS");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ID");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoActionPerformed(evt);
            }
        });

        btnBusca3.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca3.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca3.setBorderPainted(false);
        btnBusca3.setContentAreaFilled(false);
        btnBusca3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusca3.setIconTextGap(-1);
        btnBusca3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBusca3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusca3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 102));
        jLabel23.setText("BUSCAR");

        cmbHistorial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NUMERO", "CLIENTE", "NIT O CEDULA", "RESPONSABLE" }));
        cmbHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbHistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbHistorialMouseEntered(evt);
            }
        });
        cmbHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(auto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusca3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBusca3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(cmbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(auto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(361, 361, 361))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(770, 770, 770))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(254, 254, 254))
        );

        jTabbedPane1.addTab("REGISTROS", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        /*
         try {
         String formato1 = txtFe1.getDateFormatString();
         Date date1 = txtFe1.getDate();
         SimpleDateFormat sdf1 = new SimpleDateFormat(formato1);
         String dato1 = String.valueOf(sdf1.format(date1));

         String formato2 = txtFe2.getDateFormatString();
         Date date2 = txtFe2.getDate();
         SimpleDateFormat sdf2 = new SimpleDateFormat(formato2);
         String dato2 = String.valueOf(sdf2.format(date2));

         GenerarReportes g = new GenerarReportes();
         g.reporteGarantia(dato1, dato2);
         } catch (Exception e) {
         }
         */
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnBusca3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca3ActionPerformed

        String guardar = auto.getText();
        int tipo = cmbHistorial.getSelectedIndex();
        switch (tipo) {
            case 0:
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = cn.createStatement();
                    PreparedStatement pst = cn.prepareStatement("Select * from contratos where numero = ?");
                    pst.setString(1, guardar);
                    ResultSet rs = pst.executeQuery();
                    LimpiarTabla();
                    if (rs.next()) {
                        contratos con = new contratos();
                        con.setId_contrato(rs.getInt("id_contrato"));
                        con.setNumero(rs.getString("numero"));
                        con.setFecha_inicio(rs.getString("fecha_inicio"));
                        con.setFecha_fin(rs.getString("fecha_fin"));
                        con.setCliente(rs.getString("cliente"));
                        con.setNit_ced(rs.getString("nit_ced"));
                        con.setResponsable(rs.getString("responsable"));
                        contrato.add(con);
                        DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
                        tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
                    }
                    cn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "ERROR AL BUSCAR NUMERO: " + e);
                }
                break;
            case 1:
                try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = cn.createStatement();
                    PreparedStatement pst = cn.prepareStatement("Select * from contratos where cliente = ?");
                    pst.setString(1, guardar);
                    ResultSet rs = pst.executeQuery();
                    LimpiarTabla();
                    while (rs.next()) {
                        contratos con = new contratos();
                        con.setId_contrato(rs.getInt("id_contrato"));
                        con.setNumero(rs.getString("numero"));
                        con.setFecha_inicio(rs.getString("fecha_inicio"));
                        con.setFecha_fin(rs.getString("fecha_fin"));
                        con.setCliente(rs.getString("cliente"));
                        con.setNit_ced(rs.getString("nit_ced"));
                        con.setResponsable(rs.getString("responsable"));
                        contrato.add(con);
                        DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
                        tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR AL BUSCAR CLIENTE: " + e);
                }
                break;
            case 2:
                try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = cn.createStatement();
                    PreparedStatement pst = cn.prepareStatement("Select * from contratos where nit_ced = ?");
                    pst.setString(1, guardar);
                    ResultSet rs = pst.executeQuery();
                    LimpiarTabla();
                    while (rs.next()) {
                        contratos con = new contratos();
                        con.setId_contrato(rs.getInt("id_contrato"));
                        con.setNumero(rs.getString("numero"));
                        con.setFecha_inicio(rs.getString("fecha_inicio"));
                        con.setFecha_fin(rs.getString("fecha_fin"));
                        con.setCliente(rs.getString("cliente"));
                        con.setNit_ced(rs.getString("nit_ced"));
                        con.setResponsable(rs.getString("responsable"));
                        contrato.add(con);
                        DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
                        tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR AL BUSCAR REGISTRO: " + e);
                }
                break;
            case 3:
                try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = cn.createStatement();
                    PreparedStatement pst = cn.prepareStatement("Select * from contratos where responsable = ?");
                    pst.setString(1, guardar);
                    ResultSet rs = pst.executeQuery();
                    LimpiarTabla();
                    while (rs.next()) {
                        contratos con = new contratos();
                        con.setId_contrato(rs.getInt("id_contrato"));
                        con.setNumero(rs.getString("numero"));
                        con.setFecha_inicio(rs.getString("fecha_inicio"));
                        con.setFecha_fin(rs.getString("fecha_fin"));
                        con.setCliente(rs.getString("cliente"));
                        con.setNit_ced(rs.getString("nit_ced"));
                        con.setResponsable(rs.getString("responsable"));
                        contrato.add(con);
                        DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
                        tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.print("ERROR AL BUSCAR RESPONSABLE: " + e);
                }
                break;
            default:
                System.out.println("error");
                break;
        }

        /*
         try {
         String guardar = auto.getText();
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = cn.createStatement();
         PreparedStatement pst = cn.prepareStatement("Select * from clientes where nombre_cli = ?");
         pst.setString(1, guardar);
         //pst.setString(1, CMBID.getName());
         ResultSet rs = pst.executeQuery();
         LimpirTabla();
         if (rs.next()) {
                
         clientes cl = new clientes();
         cl.setNit_cliente(rs.getString("nit_cli"));
         cl.setNombre_cliente(rs.getString("nombre_cli"));
         cl.setTelefono_cliente(rs.getString("telefono_cli"));
         cl.setDireccion_cliente(rs.getString("direccion_cli"));
         cl.setCiudad_cliente(rs.getString("ciudad_cli"));
         cl.setCorreo_cliente(rs.getString("correo_cli"));
         cl.setNombre_contacto(rs.getString("contacto_cli"));
         cliente.add(cl);
         DefaultTableModel tb = (DefaultTableModel) tabla_clientes.getModel();
         tb.addRow(new Object[]{cl.getNit_cliente(), cl.getNombre_cliente(), cl.getTelefono_cliente(), cl.getDireccion_cliente(), cl.getCiudad_cliente(), cl.getCorreo_cliente(), cl.getNombre_contacto()});

         } else {
         JOptionPane.showMessageDialog(null, "No existe el usuario");
         }
         cn.close();
         } catch (SQLException ex) {
         System.out.println(ex.getMessage());
         }
         */
        /*
         String aux = auto.getText();

         try {
         String tipo = cmbHistorial.getSelectedItem().toString();
         if (tipo.equals("NUMERO")) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM contratos");
         if (rs.next()) {
         contratos con = new contratos();
         con.setId_contrato(rs.getInt("id_contrato"));
         con.setNumero(rs.getString("numero"));
         con.setFecha_inicio(rs.getString("fecha_inicio"));
         con.setFecha_fin(rs.getString("fecha_fin"));
         con.setCliente(rs.getString("cliente"));
         con.setNit_ced(rs.getString("nit_ced"));
         con.setResponsable(rs.getString("responsable"));
         contrato.add(con);
         DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
         tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
         }
         cn.close();
         } if (tipo.equals("CLIENTE")) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM contratos");
         if (rs.next()) {
         contratos con = new contratos();
         con.setId_contrato(rs.getInt("id_contrato"));
         con.setNumero(rs.getString("numero"));
         con.setFecha_inicio(rs.getString("fecha_inicio"));
         con.setFecha_fin(rs.getString("fecha_fin"));
         con.setCliente(rs.getString("cliente"));
         con.setNit_ced(rs.getString("nit_ced"));
         con.setResponsable(rs.getString("responsable"));
         contrato.add(con);
         DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
         tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
         }
         cn.close();
         } if ("NIT O CEDULA".equals(tipo)) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM contratos");
         if (rs.next()) {
         contratos con = new contratos();
         con.setId_contrato(rs.getInt("id_contrato"));
         con.setNumero(rs.getString("numero"));
         con.setFecha_inicio(rs.getString("fecha_inicio"));
         con.setFecha_fin(rs.getString("fecha_fin"));
         con.setCliente(rs.getString("cliente"));
         con.setNit_ced(rs.getString("nit_ced"));
         con.setResponsable(rs.getString("responsable"));
         contrato.add(con);
         DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
         tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
         }
         cn.close();
         } if ("RESPONSABLE".equals(tipo)) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM contratos");
         if (rs.next()) {
         contratos con = new contratos();
         con.setId_contrato(rs.getInt("id_contrato"));
         con.setNumero(rs.getString("numero"));
         con.setFecha_inicio(rs.getString("fecha_inicio"));
         con.setFecha_fin(rs.getString("fecha_fin"));
         con.setCliente(rs.getString("cliente"));
         con.setNit_ced(rs.getString("nit_ced"));
         con.setResponsable(rs.getString("responsable"));
         contrato.add(con);
         DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
         tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
         }
         cn.close();
         }
         } catch (Exception e) {
         System.out.println("error: " + e);
         }
         */
        /*
         String guardar = auto.getText();
         String tipo = cmbHistorial.getSelectedItem().toString();

         try {

         if ("NUMERO".equals(tipo)) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         PreparedStatement pst = cn.prepareStatement("Select * from contratos where numero = ?");
         pst.setString(1, guardar);
         ResultSet rs = pst.executeQuery();
         LimpiarTabla();
         if (rs.next()) {
         contratos con = new contratos();
         con.setId_contrato(rs.getInt("id_contrato"));
         con.setNumero(rs.getString("numero"));
         con.setFecha_inicio(rs.getString("fecha_inicio"));
         con.setFecha_fin(rs.getString("fecha_fin"));
         con.setCliente(rs.getString("cliente"));
         con.setNit_ced(rs.getString("nit_ced"));
         con.setResponsable(rs.getString("responsable"));
         contrato.add(con);
         DefaultTableModel tb = (DefaultTableModel) tabla_contrato.getModel();
         tb.addRow(new Object[]{con.getId_contrato(), con.getNumero(), con.getFecha_inicio(), con.getFecha_fin(), con.getCliente(), con.getNit_ced(), con.getResponsable()});
         } else {
         JOptionPane.showMessageDialog(null, "No existe");
         }
         cn.close();
         }
         } catch (SQLException ex) {
         System.out.println(ex.getMessage());
         }
         */
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca3ActionPerformed

    private void tabla_contratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_contratoMouseClicked

        int seleccion = tabla_contrato.getSelectedRow();

        txtId.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 0)));
        txtNumeroCont.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 1)));
        txtFechaInicial.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 2)));
        txtFechaFin.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 3)));
        txtCliente.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 4)));
        txtNitCed.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 5)));
        txtResponsable.setText(String.valueOf(tabla_contrato.getValueAt(seleccion, 6)));

        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_contratoMouseClicked

    private void txtFechaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicialActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            contratos con = new contratos();

            con.setNumero(txtNumeroContrato.getText().toUpperCase());

            String formato = txtFechaIn.getDateFormatString();
            Date date = txtFechaIn.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String dato = String.valueOf(sdf.format(date));
            //no_rem.setDisabledTextColor(java.awt.Color.BLUE);
            con.setFecha_inicio(dato);

            String formato2 = txtFechaFi.getDateFormatString();
            Date date2 = txtFechaFi.getDate();
            SimpleDateFormat sdf2 = new SimpleDateFormat(formato2);
            String dato2 = String.valueOf(sdf2.format(date2));
            //no_rem.setDisabledTextColor(java.awt.Color.BLUE);
            con.setFecha_fin(dato2);

            con.setCliente(txtCli.getText().toUpperCase());
            con.setNit_ced(txtNitCe.getText().toUpperCase());
            con.setResponsable(txtResp.getText().toUpperCase());

            db.InsertarContrato(con);

            limpiar2();
            LimpiarTabla2();
            LimpiarTabla();
            ListarDatos2();
            ListarDatos();

        } catch (Exception e) {
            System.err.println("error" + e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmbHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHistorialActionPerformed

        autoComplete();

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHistorialActionPerformed

    private void cmbHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbHistorialMouseClicked

        // autoComplete();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHistorialMouseClicked

    private void cmbHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbHistorialMouseEntered

        //autoComplete();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHistorialMouseEntered

    private void autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String guardar = txtCli.getText();
        try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = cn.createStatement();
                    PreparedStatement pst = cn.prepareStatement("Select * FROM clientes where nombre_cli = ?");
                    pst.setString(1, guardar);
                    ResultSet rs = pst.executeQuery();
                    LimpiarTabla();
                    if (rs.next()) {
                        clientes cli = new clientes();
                        txtNitCe.setText(rs.getString("nit_cli").trim());
                        autoCompleteCli();
                    }
                    cn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error al buscar:"+e);
                }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Contratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contratos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField auto;
    private javax.swing.JButton btnBusca3;
    private javax.swing.JComboBox cmbHistorial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla_contrato;
    private javax.swing.JTable tabla_contrato2;
    private javax.swing.JTextField txtCli;
    private javax.swing.JTextField txtCliente;
    private com.toedter.calendar.JDateChooser txtFechaFi;
    private javax.swing.JTextField txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaIn;
    private javax.swing.JTextField txtFechaInicial;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNitCe;
    private javax.swing.JTextField txtNitCed;
    private javax.swing.JTextField txtNumeroCont;
    private javax.swing.JTextField txtNumeroContrato;
    private javax.swing.JTextField txtResp;
    private javax.swing.JTextField txtResponsable;
    // End of variables declaration//GEN-END:variables
}

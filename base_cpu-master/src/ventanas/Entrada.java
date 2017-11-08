/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clasesPrincipales.Entradas;
import clasesPrincipales.clientes;
import clasesPrincipales.usuarios;
import com.mxrck.autocompleter.TextAutoCompleter;
import conMySql.GenerarNumeros;
import conMySql.clienteMySql;
import conMySql.entradaMySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author CPU_SYS
 */
public class Entrada extends javax.swing.JFrame {

    ArrayList<Entradas> entrada;
    //entradaDB db = new entradaDB();
    entradaMySql db = new entradaMySql();

    ArrayList<clientes> cliente;
    //entradaDB db = new entradaDB();
    clienteMySql dbcli = new clienteMySql();

    //excel obj = new excel();
    /**
     * Creates new form Entrada
     */
    public Entrada() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CPU System Service S.A.S - ENTRADA");
        //CargarCmbCliente();
        autoComplete();
        //numeroForaneo();
        numeros();
        txtSec.setEnabled(false);
        txtIdCli.setEnabled(false);
        txtIdCli.setText("" + 0);
        //txtForanea.setEnabled(false);
        //CargarCmbFacturas();
    }

    public void autoComplete() {
        TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(auto);
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_cli FROM clientes");
            while (rs.next()) {
                TextAutoCompleter.addItem(rs.getString("nombre_cli"));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
    /*
     public void CargarCmbCliente() {
     try {
     Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/basecpu", "root", "8020123496");
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery("SELECT nombre_cli FROM clientes ORDER BY nombre_cli ASC");
     while (rs.next()) {
     this.cmbClientes.addItem(rs.getString("nombre_cli"));
     }
     } catch (Exception e) {
     }
     }
     */
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    /*
     public void numeroForaneo(){
     int c = 0;
     int aux = 0;
     String SQL = "SELECT MAX(id_garantia) AS id_garantia FROM entradas";
     try {
     Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(SQL);
     if (rs.next()){
     c = rs.getInt("id_garantia");
     }
     if (c == 0) {
     aux = c+1;
     txtForanea.setText(""+aux);
     System.out.println(c);
     }else{
     aux = c+1;
     txtForanea.setText(""+aux);
     System.out.println(c);
     }
     } catch (Exception e) {
     }
     }
     */
    public void limpiar() {
        numeros();
        //numeroForaneo();
        txtNitCliente.setText("");
        txtEmpresa.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        txtCiudadCliente.setText("");
        txtCorreoCliente.setText("");
        txtContactoCliente.setText("");
        txtElemento.setText("");
        txtPotencia.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtSerie.setText("");
        txtMotivo.setText("");
        areaObservaciones.setText("");
        txtPersonaRemitente.setText("");
        //this.cmbClientes.removeAllItems();
        //this.cmbFacturas.removeAllItems();
        //CargarCmbCliente();
        //CargarCmbFacturas();
        txtElemento.requestFocus();
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    void numeros() {
        int j;
        String c = "";
        String SQL = "SELECT MAX(numero) AS numero FROM entradas";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString("numero");
            }
            System.out.println(c);
            if (c == null) {
                txtSec.setText("NE000001");
                System.out.println(c);
            }else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                char r5 = c.charAt(6);
                char r6 = c.charAt(7);

                System.out.println("" + r1 + r2 + r3 + r4 + r5 + r6);
                String juntar = "" + r1 + r2 + r3 + r4 + r5 + r6;
                int var = Integer.parseInt(juntar);

                System.out.println("\n lo que vale: " + var);
                GenerarNumeros gen = new GenerarNumeros();
                gen.generarEntradas(var);

                txtSec.setDisabledTextColor(java.awt.Color.BLUE);
                txtSec.setText(gen.serie());
            }
          
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     public void CargarCmbFacturas() {
     try {
     Connection cnx = DataBaseConexion.getConnection();
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery("SELECT ID_ENTRADA FROM ENTRADAS ORDER BY ID_ENTRADA DESC");
     while (rs.next()) {
     this.cmbFacturas.addItem(rs.getString("ID_ENTRADA"));
     }
     } catch (Exception e) {
     }
     }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbTarjetaDeRed = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtCiudadCliente = new javax.swing.JTextField();
        txtElemento = new javax.swing.JTextField();
        txtPotencia = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtNitCliente = new javax.swing.JTextField();
        txtPersonaRemitente = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtContactoCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cmbGarantia = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        cmbParrilla = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        cmbBasesPlasticas = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        cmbEstadoCarcasa = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        cmbConectorOriginal = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObservaciones = new javax.swing.JTextArea();
        jSeparator9 = new javax.swing.JSeparator();
        txtFecha = new com.toedter.calendar.JDateChooser();
        btnDescartar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnBusca = new javax.swing.JButton();
        btnGuarda = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        txtSec = new javax.swing.JTextField();
        auto = new javax.swing.JTextField();
        btnBusca1 = new javax.swing.JButton();
        txtIdCli = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Formato De Entrada");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 270, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 120, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Elemento");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Potencia");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 50, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Modelo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Serie");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Empresa remitente");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NIT");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 30, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ciudad");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 255, 153));
        jLabel16.setText("DATOS DEL CONTACTO");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 150, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Garantia");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 90, 20));

        cmbTarjetaDeRed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        getContentPane().add(cmbTarjetaDeRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 60, 20));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 750, 10));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 310, 10));
        getContentPane().add(txtCiudadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 150, -1));
        getContentPane().add(txtElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 150, -1));
        getContentPane().add(txtPotencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 150, -1));
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 180, -1));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 150, -1));
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 150, -1));
        getContentPane().add(txtNitCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 150, -1));
        getContentPane().add(txtPersonaRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 170, -1));
        getContentPane().add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 170, -1));
        getContentPane().add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 170, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Persona remitente");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Dirección");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtContactoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtContactoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 190, -1));

        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 150, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Correo");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 40, 20));

        txtCorreoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 200, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Telefono");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 50, 20));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 153));
        jLabel22.setText("REVISIÓN DE LA MAQUINA");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Estado Carcasa");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, 20));
        getContentPane().add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 700, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Marca");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 40, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 255, 153));
        jLabel25.setText("No. REM");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 60, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Motivo");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        cmbGarantia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        cmbGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGarantiaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbGarantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 80, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Parrilla");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, 20));

        cmbParrilla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        getContentPane().add(cmbParrilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 60, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Bases Plasticas");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 90, 20));

        cmbBasesPlasticas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        getContentPane().add(cmbBasesPlasticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 60, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Conector original");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, 20));

        cmbEstadoCarcasa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buen Estado", "Mal Estado" }));
        getContentPane().add(cmbEstadoCarcasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 110, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Tarjeta de red");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 20));

        cmbConectorOriginal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        getContentPane().add(cmbConectorOriginal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 60, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Observaciones");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 20));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, 10));

        areaObservaciones.setColumns(20);
        areaObservaciones.setRows(5);
        jScrollPane1.setViewportView(areaObservaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 500, 100));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 260, 10));

        txtFecha.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 160, -1));

        btnDescartar.setBackground(new java.awt.Color(255, 255, 255));
        btnDescartar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar2.png"))); // NOI18N
        btnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 40, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 153));
        jLabel7.setText("CLIENTES");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 20));

        btnBusca.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
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
        getContentPane().add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 40, -1));

        btnGuarda.setBackground(new java.awt.Color(255, 255, 255));
        btnGuarda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuarda.setForeground(new java.awt.Color(255, 255, 255));
        btnGuarda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar_1.png"))); // NOI18N
        btnGuarda.setText("Guardar");
        btnGuarda.setBorderPainted(false);
        btnGuarda.setContentAreaFilled(false);
        btnGuarda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuarda.setIconTextGap(-1);
        btnGuarda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuarda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuarda, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 80, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 120, 10));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 255, 153));
        jLabel26.setText("FECHA");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 40, 20));
        getContentPane().add(txtSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 170, -1));
        getContentPane().add(auto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, -1));

        btnBusca1.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca1.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_usu_mini.png"))); // NOI18N
        btnBusca1.setBorderPainted(false);
        btnBusca1.setContentAreaFilled(false);
        btnBusca1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusca1.setIconTextGap(-1);
        btnBusca1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBusca1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBusca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 33, 50, -1));

        txtIdCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCliActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 80, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("ID");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 20, 20));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Entrada.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, 800, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoClienteActionPerformed

    private void cmbGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGarantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGarantiaActionPerformed

    private void txtContactoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoClienteActionPerformed

    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

        try {

            String guardar = auto.getText();
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select * from clientes where nombre_cli = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtNitCliente.setText(rs.getString("nit_cli").trim());
                txtEmpresa.setText(rs.getString("nombre_cli").trim());
                txtTelefonoCliente.setText(rs.getString("telefono_cli").trim());
                txtDireccionCliente.setText(rs.getString("direccion_cli").trim());
                txtCiudadCliente.setText(rs.getString("ciudad_cli").trim());
                txtCorreoCliente.setText(rs.getString("correo_cli").trim());
                txtContactoCliente.setText(rs.getString("contacto_cli").trim());
                txtPersonaRemitente.setText(rs.getString("contacto_cli").trim());
                txtIdCli.setText(rs.getString("id_cli").trim());
                autoComplete();
                //pst.setString(1, CMBID.getName());
                //String guardar = txtBuscar.getText();
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarActionPerformed

        txtNitCliente.setText("");
        txtEmpresa.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        txtCiudadCliente.setText("");
        txtCorreoCliente.setText("");
        txtContactoCliente.setText("");
        txtElemento.setText("");
        txtPotencia.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtSerie.setText("");
        txtMotivo.setText("");
        areaObservaciones.setText("");
        txtPersonaRemitente.setText("");
        //txtFecha.setDateFormatString("");
        txtElemento.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescartarActionPerformed

    private void btnGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaActionPerformed

        if (txtEmpresa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DEBE DILIGENCIAR EL FORMULARIO");
        }
        if (txtFecha.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE DILIGENCIAR LA FECHA");
        } else {
            int id = Integer.parseInt(txtIdCli.getText());
            try {
                clientes cli = new clientes();
                cli.setNombre_cliente(this.txtEmpresa.getText());

                Entradas en = new Entradas();

                String formato = txtFecha.getDateFormatString();
                Date date = txtFecha.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                String dato = String.valueOf(sdf.format(date));
                //no_rem.setDisabledTextColor(java.awt.Color.BLUE);
                en.setFecha(dato);
                en.setElemento(txtElemento.getText().toUpperCase());
                en.setPotencia(txtPotencia.getText().toUpperCase());
                en.setMarca(txtMarca.getText().toUpperCase());
                en.setModelo(txtModelo.getText().toUpperCase());
                en.setSerie(txtSerie.getText().toUpperCase());
                en.setEmpresa(txtEmpresa.getText().toUpperCase());
                en.setNit(txtNitCliente.getText().toUpperCase());
                en.setPersona_remite(txtPersonaRemitente.getText().toUpperCase());
                en.setCiudad(txtCiudadCliente.getText().toUpperCase());
                en.setDireccion(txtDireccionCliente.getText().toUpperCase());
                en.setNombre_contacto(txtContactoCliente.getText().toUpperCase());
                en.setTelefono_contacto(txtTelefonoCliente.getText().toUpperCase());
                en.setCorreo(txtCorreoCliente.getText().toUpperCase());
                en.setMotivo(txtMotivo.getText().toUpperCase());
                en.setTarjeta_red(cmbTarjetaDeRed.getSelectedItem().toString().toUpperCase());
                en.setParrilla(cmbParrilla.getSelectedItem().toString().toUpperCase());
                en.setBases_plasticas(cmbBasesPlasticas.getSelectedItem().toString().toUpperCase());
                en.setConector_origi(cmbConectorOriginal.getSelectedItem().toString().toUpperCase());
                en.setGarantia(cmbGarantia.getSelectedItem().toString().toUpperCase());
                en.setEstado_carcasa(cmbEstadoCarcasa.getSelectedItem().toString().toUpperCase());
                en.setObservaciones(areaObservaciones.getText().toUpperCase());
                en.setId_cli(Integer.parseInt(txtIdCli.getText()));
                en.setEstado("REVISION");
                //en.setId_garantia(Integer.parseInt(txtForanea.getText()));
                en.setNumero(txtSec.getText());

                cli.setId_cliente(id);
                cli.setNombre_cliente(txtEmpresa.getText().toUpperCase());
                cli.setNit_cliente(txtNitCliente.getText().toUpperCase());
                cli.setCiudad_cliente(txtCiudadCliente.getText().toUpperCase());
                cli.setDireccion_cliente(txtDireccionCliente.getText().toUpperCase());
                cli.setNombre_contacto(txtContactoCliente.getText().toUpperCase());
                cli.setTelefono_cliente(txtTelefonoCliente.getText().toUpperCase());
                cli.setCorreo_cliente(txtCorreoCliente.getText().toUpperCase());
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    PreparedStatement pst = cn.prepareStatement("Select * From clientes Where nombre_cli = ?");
                    pst.setString(1, cli.getNombre_cliente());
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        db.insertarEntrada(en);
                        limpiar();
                    } else {
                        if (id == 0) {
                            JOptionPane.showMessageDialog(this, "Debe registrar al cliente");
                            Nuevo_Cliente obj = new Nuevo_Cliente();
                            obj.setVisible(true);
                            dispose();
                        }
                    }
                    cn.close();

                } catch (Exception e) {
                }

            } catch (Exception e) {
                System.err.println("error" + e);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnGuardaActionPerformed

    private void btnBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca1ActionPerformed

        Nuevo_Cliente obj = new Nuevo_Cliente();
        obj.setVisible(true);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca1ActionPerformed

    private void txtIdCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCliActionPerformed

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
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservaciones;
    private javax.swing.JTextField auto;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnBusca1;
    private javax.swing.JButton btnDescartar;
    private javax.swing.JButton btnGuarda;
    private javax.swing.JComboBox cmbBasesPlasticas;
    private javax.swing.JComboBox cmbConectorOriginal;
    private javax.swing.JComboBox cmbEstadoCarcasa;
    private javax.swing.JComboBox cmbGarantia;
    private javax.swing.JComboBox cmbParrilla;
    private javax.swing.JComboBox cmbTarjetaDeRed;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtCiudadCliente;
    private javax.swing.JTextField txtContactoCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtElemento;
    private javax.swing.JTextField txtEmpresa;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtNitCliente;
    private javax.swing.JTextField txtPersonaRemitente;
    private javax.swing.JTextField txtPotencia;
    private javax.swing.JTextField txtSec;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clasesPrincipales.Entradas;
import clasesPrincipales.Salidas;
import clasesPrincipales.clientes;
import com.mxrck.autocompleter.TextAutoCompleter;
import conMySql.GenerarNumeros;
import conMySql.salidaMySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CPU_SYS
 */
public class Salidass extends javax.swing.JFrame {

    ArrayList<Salidass> salida;
    salidaMySql db = new salidaMySql();

    /**
     * Creates new form Entrada
     */
    public Salidass() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CPU System Service S.A.S - SALIDA");
        //CargarCmbCliente();
        autoComplete();
        CargarCmbEntadas();
        CargarCmbGarantias();
        numeros();
        txtSec.setEnabled(false);
        txtIdCli.setEnabled(false);
        txtIdCli.setText("" + 0);
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
     Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/basecpu", "root", "8020123496");
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery("SELECT nombre_cli FROM clientes ORDER BY nombre_cli ASC");
     while (rs.next()) {
     this.cmbClientes.addItem(rs.getString("nombre_cli"));
     }
     cn.close();
     } catch (Exception e) {
     }
     }
     */

    public void CargarCmbEntadas() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT numero FROM entradas ORDER BY numero DESC");
            while (rs.next()) {
                this.cmbEntradas.addItem(rs.getString("numero"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Servidor: error al cargar comboBox:\n"+e.getMessage());
        }
    }
    
    public void CargarCmbGarantias() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT numero FROM garantias WHERE estado = 'LISTO' ORDER BY numero DESC");
            while (rs.next()) {
                this.cmbGarantias.addItem(rs.getString("numero"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Servidor: error al cargar comboBox:\n"+e.getMessage());
        }
    }

    public void limpiar() {
        txtEmpresa.setText("");
        txtCiudad.setText("");
        txtDireccion.setText("");
        txtContacto.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        areaComentario.setText("");
        txtEquipo.setText("");
        txtModel.setText("");
        txtSerie.setText("");
        //txtFecha.setDateFormatString("");
        //this.cmbClientes.removeAllItems();
        //CargarCmbCliente();
        txtEmpresa.requestFocus();
    }

    public void limpiar2() {
        areaComentario.setText("");
        txtEquipo.setText("");
        txtModel.setText("");
        txtSerie.setText("");
        //this.cmbClientes.removeAllItems();
        //CargarCmbCliente();
        txtEmpresa.requestFocus();
    }

    void numeros() {
        int j;
        String c = "";
        String SQL = "SELECT MAX(numero) AS numero FROM salidas";
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString("numero");
            }
            System.out.println(c);
            if (c == null) {
                txtSec.setText("NS000001");
                System.out.println(c);
            } else {
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
                gen.generarSalidas(var);

                txtSec.setDisabledTextColor(java.awt.Color.BLUE);
                txtSec.setText(gen.serie());
            }
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(Salidass.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtCiudad = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txtEquipo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaComentario = new javax.swing.JTextArea();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        btnGuarda = new javax.swing.JButton();
        btnDescartar1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        txtSec = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        cmbEntradas = new javax.swing.JComboBox();
        btnBusca3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnGuarda1 = new javax.swing.JButton();
        auto = new javax.swing.JTextField();
        btnBusca1 = new javax.swing.JButton();
        txtIdCli = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cmbPrestamo = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        btnBusca4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbGarantias = new javax.swing.JComboBox();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FORMATOS DE SALIDA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 280, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 220, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 153));
        jLabel6.setText("CLIENTES");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 20));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 130, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ciudad");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 255, 153));
        jLabel16.setText("DATOS DEL CONTACTO");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 150, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 650, 10));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 260, 10));
        getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 200, -1));
        getContentPane().add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 200, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Dirección");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));
        getContentPane().add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 140, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 110, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Correo");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 40, 20));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 180, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Telefono");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 50, 20));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 270, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 153));
        jLabel22.setText("DATOS DEL EQUIPO");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));
        getContentPane().add(txtEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 130, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setText("PRESTAMO");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 90, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Equipo");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 40, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Comentario");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 330, 10));

        areaComentario.setColumns(20);
        areaComentario.setRows(5);
        jScrollPane1.setViewportView(areaComentario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 450, 140));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 230, 10));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Modelo");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 50, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Serie");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 40, 20));
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 150, -1));

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
        getContentPane().add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 40, -1));

        btnGuarda.setBackground(new java.awt.Color(255, 255, 255));
        btnGuarda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuarda.setForeground(new java.awt.Color(255, 255, 255));
        btnGuarda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar_1.png"))); // NOI18N
        btnGuarda.setText("Guardar");
        btnGuarda.setBorder(null);
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
        getContentPane().add(btnGuarda, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 50, -1));

        btnDescartar1.setBackground(new java.awt.Color(255, 255, 255));
        btnDescartar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDescartar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar2.png"))); // NOI18N
        btnDescartar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnDescartar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 40, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Empresa");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));
        getContentPane().add(txtModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 160, -1));

        txtSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecActionPerformed(evt);
            }
        });
        getContentPane().add(txtSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 170, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 110, 10));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 255, 153));
        jLabel26.setText("No. REM");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 60, 20));

        txtFecha.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 170, -1));

        cmbEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEntradasActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 150, -1));

        btnBusca3.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca3.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca3.setBorder(null);
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
        getContentPane().add(btnBusca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 40, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 153));
        jLabel8.setText("GARANTIAS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 100, 20));

        btnGuarda1.setBackground(new java.awt.Color(255, 255, 255));
        btnGuarda1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuarda1.setForeground(new java.awt.Color(255, 255, 255));
        btnGuarda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarr.png"))); // NOI18N
        btnGuarda1.setText("Go");
        btnGuarda1.setBorder(null);
        btnGuarda1.setBorderPainted(false);
        btnGuarda1.setContentAreaFilled(false);
        btnGuarda1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuarda1.setIconTextGap(-1);
        btnGuarda1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuarda1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuarda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuarda1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuarda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 50, -1));
        getContentPane().add(auto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

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
        getContentPane().add(btnBusca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 50, -1));

        txtIdCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCliActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 80, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("ID");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 20, 20));

        cmbPrestamo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        getContentPane().add(cmbPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 60, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 255, 153));
        jLabel29.setText("FECHA");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 40, 20));

        btnBusca4.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca4.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca4.setBorder(null);
        btnBusca4.setBorderPainted(false);
        btnBusca4.setContentAreaFilled(false);
        btnBusca4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusca4.setIconTextGap(-1);
        btnBusca4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBusca4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusca4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBusca4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 40, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 153));
        jLabel9.setText("ENTRADAS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 70, 20));

        getContentPane().add(cmbGarantias, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 160, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ima2.2_ampliada.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

        //limpiar2();
        try {

            String guardar = auto.getText();
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select * from clientes where nombre_cli = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtEmpresa.setText(rs.getString("nombre_cli").trim());
                txtCiudad.setText(rs.getString("ciudad_cli").trim());
                txtDireccion.setText(rs.getString("direccion_cli").trim());
                txtContacto.setText(rs.getString("contacto_cli").trim());
                txtTelefono.setText(rs.getString("telefono_cli").trim());
                txtCorreo.setText(rs.getString("correo_cli").trim());
                txtIdCli.setText(rs.getString("id_cli").trim());
                //pst.setString(1, CMBID.getName());
                //String guardar = txtBuscar.getText();
                limpiar2();
                autoComplete();
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaActionPerformed

        int id = Integer.parseInt(txtIdCli.getText());

        try {
            clientes cli = new clientes();
            cli.setNombre_cliente(this.txtEmpresa.getText());

            Salidas sal = new Salidas();
            String formato = txtFecha.getDateFormatString();
            Date date = txtFecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String dato = String.valueOf(sdf.format(date));
            sal.setFecha(dato);
            sal.setNumero(txtSec.getText());
            sal.setEmpresa(txtEmpresa.getText().toUpperCase());
            sal.setCiudad(txtCiudad.getText().toUpperCase());
            sal.setDireccion(txtDireccion.getText().toUpperCase());
            sal.setContacto(txtContacto.getText().toUpperCase());
            sal.setTelefono(txtTelefono.getText().toUpperCase());
            sal.setCorreo(txtCorreo.getText().toUpperCase());
            sal.setEquipo(txtEquipo.getText().toUpperCase());
            sal.setModelo(txtModel.getText().toUpperCase());
            sal.setSerie(txtSerie.getText().toUpperCase());
            sal.setComentario(areaComentario.getText().toUpperCase());
            sal.setPrestamo(cmbPrestamo.getSelectedItem().toString());
            sal.setId_cli(Integer.parseInt(txtIdCli.getText()));

            cli.setId_cliente(id);
            cli.setNombre_cliente(txtEmpresa.getText().toUpperCase());
            cli.setCiudad_cliente(txtCiudad.getText().toUpperCase());
            cli.setDireccion_cliente(txtDireccion.getText().toUpperCase());
            cli.setNombre_contacto(txtContacto.getText().toUpperCase());
            cli.setTelefono_cliente(txtTelefono.getText().toUpperCase());
            cli.setCorreo_cliente(txtCorreo.getText().toUpperCase());

            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                PreparedStatement pst = cn.prepareStatement("Select * From clientes Where nombre_cli = ?");
                pst.setString(1, cli.getNombre_cliente());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    db.insertarSalida(sal);
                    numeros();
                    limpiar();
                } else {
                    if (id == 0) {
                        JOptionPane.showMessageDialog(this, "Debe registrar al cliente");
                        Nuevo_Cliente obj = new Nuevo_Cliente();
                        obj.setVisible(true);
                        dispose();
                    }
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.err.println("error" + e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardaActionPerformed

    private void btnDescartar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartar1ActionPerformed

        txtEmpresa.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
        txtCorreo.setText("");
        txtContacto.setText("");
        txtEquipo.setText("");
        areaComentario.setText("");
        txtModel.setText("");
        txtSerie.setText("");
        txtEmpresa.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescartar1ActionPerformed

    private void txtSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecActionPerformed

    private void cmbEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEntradasActionPerformed

    private void btnBusca3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca3ActionPerformed

        //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
        try {

            String guardar = cmbEntradas.getSelectedItem().toString();
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Select * from entradas where numero = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtEmpresa.setText(rs.getString("empresa").trim());
                txtCiudad.setText(rs.getString("ciudad").trim());
                txtDireccion.setText(rs.getString("direccion").trim());
                txtContacto.setText(rs.getString("contacto").trim());
                txtTelefono.setText(rs.getString("telefono").trim());
                txtCorreo.setText(rs.getString("correo").trim());
                txtEquipo.setText(rs.getString("elemento"));
                txtModel.setText(rs.getString("modelo"));
                txtSerie.setText(rs.getString("serie").trim());
                areaComentario.setText(rs.getString("observaciones").trim());
                txtIdCli.setText(rs.getString("id_cli"));

                //pst.setString(1, CMBID.getName());
                //String guardar = txtBuscar.getText();
            } else {
                JOptionPane.showMessageDialog(null, "No existe la factura");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca3ActionPerformed

    private void btnGuarda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuarda1ActionPerformed

        Facturas_Salida obj = new Facturas_Salida();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuarda1ActionPerformed

    private void btnBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca1ActionPerformed

        Nuevo_Cliente obj = new Nuevo_Cliente();
        obj.setVisible(true);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca1ActionPerformed

    private void txtIdCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCliActionPerformed

    private void btnBusca4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca4ActionPerformed

        try {
            String area ="";
            String guardar = cmbGarantias.getSelectedItem().toString();
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("SELECT e.empresa, e.ciudad, e.direccion, e.contacto , e.telefono, e.correo, e.elemento, e.modelo, e.serie, e.id_cli, g.serie_nueva\n"
                    + "FROM entradas e \n"
                    + "INNER JOIN garantias g \n"
                    + "ON e.id_entra = g.id_entra\n"
                    + "WHERE e.numero = ?");
            pst.setString(1, guardar);
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Entradas en = new Entradas();
                txtEmpresa.setText(rs.getString("empresa").trim());
                txtCiudad.setText(rs.getString("ciudad").trim());
                txtDireccion.setText(rs.getString("direccion").trim());
                txtContacto.setText(rs.getString("contacto").trim());
                txtTelefono.setText(rs.getString("telefono").trim());
                txtCorreo.setText(rs.getString("correo").trim());
                txtEquipo.setText(rs.getString("elemento"));
                txtModel.setText(rs.getString("modelo"));
                txtSerie.setText(rs.getString("serie_nueva").trim());
                txtIdCli.setText(rs.getString("id_cli"));
                areaComentario.setText(rs.getString("serie").trim());
                
                //pst.setString(1, CMBID.getName());
                //String guardar = txtBuscar.getText();
            } else {
                JOptionPane.showMessageDialog(null, "No existe la factura");
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error\n" + ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca4ActionPerformed

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
            java.util.logging.Logger.getLogger(Salidass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salidass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salidass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salidass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salidass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaComentario;
    private javax.swing.JTextField auto;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnBusca1;
    private javax.swing.JButton btnBusca3;
    private javax.swing.JButton btnBusca4;
    private javax.swing.JButton btnDescartar1;
    private javax.swing.JButton btnGuarda;
    private javax.swing.JButton btnGuarda1;
    private javax.swing.JComboBox cmbEntradas;
    private javax.swing.JComboBox cmbGarantias;
    private javax.swing.JComboBox cmbPrestamo;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEquipo;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtSec;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

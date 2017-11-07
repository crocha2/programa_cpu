/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clasesPrincipales.Entradas;
import clasesPrincipales.Envios;
import clasesPrincipales.Garantias;
import clasesPrincipales.Listos;
import clasesPrincipales.Salidas;
import clasesPrincipales.contratos;
import com.mxrck.autocompleter.TextAutoCompleter;
import conMySql.entradaMySql;
import conMySql.envioMySql;
import conMySql.garantiaMySql;
import conMySql.salidaMySql;
import conMySql.listoMySql;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JR
 */
public class Tecnico_Oper extends javax.swing.JFrame {

    ArrayList<Entradas> entrada;
    entradaMySql dbEntrada = new entradaMySql();

    ArrayList<Salidas> salida;
    salidaMySql dbSalida = new salidaMySql();

    ArrayList<Envios> envio;
    envioMySql dbEnvio = new envioMySql();

    ArrayList<Garantias> garantia;
    garantiaMySql dbGarantia = new garantiaMySql();

    ArrayList<Listos> listo;
    listoMySql dbListo = new listoMySql();

    /**
     * Creates new form Tecnico
     */
    public Tecnico_Oper() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CPU System Service S.A.S - PANEL");
        ListarEntradas();
        ListarSalidas();
        ListarEnvios();
        ListarPrestamo();
        colorEstado();
        //autoCompleteEntradas();
        //autoCompleteSalidas();
        //autoCompleteEnvios();
        //autoCompleteProceso();
        //autoCompleteRevision();
        
        txtIdEntrada.setEnabled(false);
        txtIdSalida.setEnabled(false);
        txtIdEnvio.setEnabled(false);      
        txtIdPrestamo.setEnabled(false);    
        txtEstado.setEnabled(false);
        //txtFechaEntrad.setEnabled(false);
    }

    //variables de tabla ENTRADAS para editar o eliminar... 
    public static String id_entrada;
    public static String fecha_entrada;
    public static String numero_entrada;
    public static String cliente_entrada;
    public static String nit_entrada;
    public static String telefono_entrada;
    public static String correo_entrada;
    public static String elemento_entrada;
    public static String marca_entrada;
    public static String modelo_entrada;
    public static String serie_entrada;
    public static String garantia_entrada;
    public static String observacion_entrada;
    public static String estado_entrada;
    public static String id_cli_entrada;

    //variables de tabla SALIDAS para editar o eliminar... 
    public static String id_salida;
    public static String fecha_salida;
    public static String numero_salida;
    public static String cliente_salida;
    public static String telefono_salida;
    public static String correo_salida;
    public static String equipo_salida;
    public static String modelo_salida;
    public static String serie_salida;
    public static String observacion_salida;
    public static String prestamo_salida;
    public static String id_cli_salida;

    //variables de tabla ENVIOS para editar o eliminar...
    public static String id_envio;
    public static String fecha_envio;
    public static String numero_envio;
    public static String destinatario_envio;
    public static String atn_envio;
    public static String direccion_envio;
    public static String telefono_envio;
    public static String ciudad_envio;
    public static String comentario_envio;
    public static String id_cli_envio;


    public void colorEstado() {
        txtEstado.setDisabledTextColor(java.awt.Color.BLUE);
        //txtSec.setText(gen.serie());
    }

    public void ListarEntradas() {
        entrada = dbEntrada.ListEntradas();
        DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
        for (Entradas en : entrada) {
            tb.addRow(new Object[]{en.getId_entrada(), en.getFecha(), en.getNumero(), en.getEmpresa(), en.getNit(), en.getTelefono_contacto(), en.getCorreo(), en.getElemento(), en.getMarca(), en.getModelo(), en.getSerie(), en.getGarantia(), en.getObservaciones(), en.getEstado(), en.getId_cli()});
        }
    }

    public void LimpiarEntradas() {
        DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void ListarSalidas() {
        salida = dbSalida.ListSalidas();
        DefaultTableModel tb = (DefaultTableModel) tbSalidas.getModel();
        for (Salidas sal : salida) {
            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
        }
    }

    public void LimpiarSalidas() {
        DefaultTableModel tb = (DefaultTableModel) tbSalidas.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    public void ListarPrestamo() {
        salida = dbSalida.ListPrestamo();
        DefaultTableModel tb = (DefaultTableModel) tbPrestamos.getModel();
        for (Salidas sal : salida) {
            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
        }
    }

    public void LimpiarPrestamo() {
        DefaultTableModel tb = (DefaultTableModel) tbPrestamos.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void ListarEnvios() {
        envio = dbEnvio.ListEnvios();
        DefaultTableModel tb = (DefaultTableModel) tbEnvios.getModel();
        for (Envios en : envio) {
            tb.addRow(new Object[]{en.getId_envio(), en.getFecha(), en.getNumero(), en.getDestinatario(), en.getATN(), en.getDireccion(), en.getTelefono(), en.getCiudad(), en.getComentario(), en.getId_cli()});
        }
    }

    public void LimpiarEnvios() {
        DefaultTableModel tb = (DefaultTableModel) tbEnvios.getModel();
        for (int i = tb.getRowCount() - 1; i >= 0; i--) {
            tb.removeRow(i);
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void autoCompleteEntradas() {

        int tipo = cmbEntradas.getSelectedIndex();
        switch (tipo) {
            case 0:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEntra);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT numero FROM entradas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("numero"));
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 1:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEntra);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT empresa FROM entradas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("empresa"));
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 2:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEntra);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT nit FROM entradas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("nit"));
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 3:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEntra);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT serie FROM entradas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("serie"));
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
        }

        /*
         TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEntra);
         String guardar = cmbEntradas.getSelectedItem().toString();
         try {
         //String guardar = cmbEntradas.getSelectedItem().toString();
         if (guardar.equals("NUMERO")) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT numero FROM entradas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("numero"));
         }
         cn.close();
         }
         if (guardar.equals("CLIENTE")) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT empresa FROM entradas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("empresa"));
         }
         cn.close();
         }
         if ("NIT O CEDULA".equals(guardar)) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT nit FROM entradas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("nit"));
         }
         cn.close();
         }
         if ("SERIE".equals(guardar)) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT serie FROM entradas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("serie"));
         }
         cn.close();
         }
         } catch (Exception e) {
         System.out.println("error: " + e);
         }
         */
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /*
     public void autoComplete(){
     TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(auto);
     try {
     Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
     Statement st = (Statement)cn.createStatement();
     ResultSet rs = st.executeQuery("SELECT nombre_cli FROM clientes");
     while (rs.next()) {
     TextAutoCompleter.addItem(rs.getString("nombre_cli"));
     }
     cn.close();
     } catch (Exception e) {
     System.out.println("error: "+e);
     }
     }
     */

    

    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void autoCompleteSalidas() {

        int tipo = cmbSalidas.getSelectedIndex();
        switch (tipo) {
            case 0:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoSal);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT numero FROM salidas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("numero"));
                    }
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 1:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoSal);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT empresa FROM salidas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("empresa"));
                    }
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 2:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoSal);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT serie FROM salidas");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("serie"));
                    }
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
        }


        /*
         TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoSal);

         try {
         String guardar = cmbSalidas.getSelectedItem().toString();
         if (guardar.equals("NUMERO")) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT numero FROM salidas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("numero"));
         }
         cn.close();
         }
         if (guardar.equals("CLIENTE")) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT empresa FROM salidas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("empresa"));
         }
         cn.close();
         }
         if ("SERIE".equals(guardar)) {
         Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
         Statement st = (Statement) cn.createStatement();
         ResultSet rs = st.executeQuery("SELECT serie FROM salidas");
         while (rs.next()) {
         TextAutoCompleter.addItem(rs.getString("serie"));
         }
         cn.close();
         }
         } catch (Exception e) {
         System.out.println("error: " + e);
         }
         */
    }

    public void autoCompletePrestamo() {

        int tipo = cmbPrestamo.getSelectedIndex();
        switch (tipo) {
            case 0:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoPres);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT numero FROM salidas WHERE prestamo = 'SI'");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("numero"));
                    }
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 1:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoPres);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT empresa FROM salidas WHERE prestamo = 'SI'");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("empresa"));
                    }
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 2:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoPres);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT serie FROM salidas WHERE prestamo = 'SI'");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("serie"));
                    }
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void autoCompleteEnvios() {

        int tipo = cmbEnvios.getSelectedIndex();
        switch (tipo) {
            case 0:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEnvio);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT numero FROM envios");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("numero"));
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                break;
            case 1:
                try {
                    TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEnvio);
                    Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                    Statement st = (Statement) cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT destinatario FROM envios");
                    while (rs.next()) {
                        TextAutoCompleter.addItem(rs.getString("destinatario"));
                    }
                    cn.close();
                } catch (Exception e) {
                    System.out.println("error" + e);
                }

            /*
             TextAutoCompleter TextAutoCompleter = new TextAutoCompleter(autoEnvio);

             try {
             String guardar = cmbEnvios.getSelectedItem().toString();
             if (guardar.equals("NUMERO")) {
             Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
             Statement st = (Statement) cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT numero FROM envios");
             while (rs.next()) {
             TextAutoCompleter.addItem(rs.getString("numero"));
             }
             cn.close();
             }
             if ("DESTINATARIO".equals(guardar)) {
             Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
             Statement st = (Statement) cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT destinatario FROM envios");
             while (rs.next()) {
             TextAutoCompleter.addItem(rs.getString("destinatario"));
             }
             cn.close();
             }
             } catch (Exception e) {
             System.out.println("error: " + e);
             }
             */
        }
    }

    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
   


    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEntradas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaEntrada = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cmbEntradas = new javax.swing.JComboBox();
        btnBusca = new javax.swing.JButton();
        autoEntra = new javax.swing.JTextField();
        txtIdEntrada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        btnSalida2 = new javax.swing.JButton();
        btnSalida1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSalidas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaSalida = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        cmbSalidas = new javax.swing.JComboBox();
        autoSal = new javax.swing.JTextField();
        btnBusca1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtIdSalida = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btnSalida3 = new javax.swing.JButton();
        btnSalida4 = new javax.swing.JButton();
        btnSalida5 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbEnvios = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        areaEnvio = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        cmbEnvios = new javax.swing.JComboBox();
        autoEnvio = new javax.swing.JTextField();
        btnBusca2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtIdEnvio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnSalida6 = new javax.swing.JButton();
        btnSalida7 = new javax.swing.JButton();
        btnSalida8 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbPrestamos = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        cmbPrestamo = new javax.swing.JComboBox();
        autoPres = new javax.swing.JTextField();
        btnBusca7 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtIdPrestamo = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        areaPrestamo = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        btnSalida9 = new javax.swing.JButton();
        btnSalida10 = new javax.swing.JButton();
        btnSalida11 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        tbEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "No.Rem", "Cliente", "Nit o Cedula", "Telefono", "Correo", "Elemento", "Marca", "Modelo", "Serie", "Garantia", "Observacion", "estado", "Id_cli"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEntradas.setToolTipText("");
        tbEntradas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbEntradas.setGridColor(new java.awt.Color(0, 153, 153));
        tbEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEntradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEntradas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 876, 206);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Observaciones");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(430, 50, 87, 15);

        areaEntrada.setColumns(20);
        areaEntrada.setRows(5);
        jScrollPane4.setViewportView(areaEntrada);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(430, 70, 459, 72);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("REGISTRO DE ENTRADAS");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(290, 10, 305, 29);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbEntradas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NUMERO", "CLIENTE", "NIT O CEDULA", "SERIE" }));
        cmbEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEntradasActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBusca)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cmbEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 60, 345, 80);
        jPanel1.add(txtIdEntrada);
        txtIdEntrada.setBounds(20, 380, 76, 30);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ID");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(20, 360, 24, 20);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(380, 70, 23, 23);

        btnSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entrada_mini.png"))); // NOI18N
        btnSalida.setBorder(null);
        btnSalida.setBorderPainted(false);
        btnSalida.setContentAreaFilled(false);
        btnSalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida.setIconTextGap(-1);
        btnSalida.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalida);
        btnSalida.setBounds(330, 370, 40, 40);

        btnSalida2.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida2.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida_mini.png"))); // NOI18N
        btnSalida2.setBorder(null);
        btnSalida2.setBorderPainted(false);
        btnSalida2.setContentAreaFilled(false);
        btnSalida2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida2.setIconTextGap(-1);
        btnSalida2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalida2);
        btnSalida2.setBounds(370, 370, 40, 40);

        btnSalida1.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida1.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio_mini.png"))); // NOI18N
        btnSalida1.setBorder(null);
        btnSalida1.setBorderPainted(false);
        btnSalida1.setContentAreaFilled(false);
        btnSalida1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida1.setIconTextGap(-1);
        btnSalida1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalida1);
        btnSalida1.setBounds(410, 370, 40, 40);

        jButton10.setBackground(new java.awt.Color(0, 153, 153));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("EDITAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(470, 380, 100, 40);

        jButton17.setBackground(new java.awt.Color(0, 153, 153));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("ELIMINAR");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17);
        jButton17.setBounds(580, 380, 100, 40);
        jPanel1.add(txtEstado);
        txtEstado.setBounds(120, 380, 130, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTADO");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 360, 50, 20);

        jTabbedPane1.addTab("ENTRADAS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(null);

        tbSalidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "No.Rem", "Cliente", "Telefono", "Correo", "Equipo", "Modelo", "Serie", "Observacion", "Prestamo", "id_cli"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSalidas.setToolTipText("");
        tbSalidas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbSalidas.setGridColor(new java.awt.Color(0, 153, 153));
        tbSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSalidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSalidas);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(68, 170, 760, 202);

        areaSalida.setColumns(20);
        areaSalida.setRows(5);
        jScrollPane5.setViewportView(areaSalida);

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(417, 75, 410, 84);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbSalidas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NUMERO", "CLIENTE", "SERIE" }));
        cmbSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSalidasActionPerformed(evt);
            }
        });

        autoSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoSalActionPerformed(evt);
            }
        });

        btnBusca1.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca1.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca1.setBorder(null);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoSal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBusca1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cmbSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(68, 75, 277, 90);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("REGISTRO DE SALIDAS");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(275, 21, 280, 29);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Observaciones");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(417, 54, 87, 15);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("ID");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(70, 390, 24, 14);
        jPanel2.add(txtIdSalida);
        txtIdSalida.setBounds(100, 380, 76, 30);

        jButton4.setText("jButton3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(355, 75, 24, 23);

        btnSalida3.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida3.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entrada_mini.png"))); // NOI18N
        btnSalida3.setBorder(null);
        btnSalida3.setBorderPainted(false);
        btnSalida3.setContentAreaFilled(false);
        btnSalida3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida3.setIconTextGap(-1);
        btnSalida3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida3ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalida3);
        btnSalida3.setBounds(200, 380, 40, 40);

        btnSalida4.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida4.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida_mini.png"))); // NOI18N
        btnSalida4.setBorder(null);
        btnSalida4.setBorderPainted(false);
        btnSalida4.setContentAreaFilled(false);
        btnSalida4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida4.setIconTextGap(-1);
        btnSalida4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida4ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalida4);
        btnSalida4.setBounds(240, 380, 40, 40);

        btnSalida5.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida5.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio_mini.png"))); // NOI18N
        btnSalida5.setBorder(null);
        btnSalida5.setBorderPainted(false);
        btnSalida5.setContentAreaFilled(false);
        btnSalida5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida5.setIconTextGap(-1);
        btnSalida5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida5ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalida5);
        btnSalida5.setBounds(280, 380, 40, 40);

        jButton13.setBackground(new java.awt.Color(0, 153, 153));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("ELIMINAR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(450, 380, 100, 40);

        jButton14.setBackground(new java.awt.Color(0, 153, 153));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("EDITAR");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(340, 380, 100, 40);

        jTabbedPane1.addTab("SALIDAS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("REGISTRO DE ENVIOS");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(276, 11, 269, 29);

        tbEnvios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbEnvios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "No.Rem", "Destinatario", "ATN", "Direccion", "Telefono", "Ciudad", "Comentario", "id_cli"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEnvios.setToolTipText("");
        tbEnvios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbEnvios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbEnvios.setGridColor(new java.awt.Color(0, 153, 153));
        tbEnvios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEnviosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbEnvios);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(89, 181, 711, 200);

        areaEnvio.setColumns(20);
        areaEnvio.setRows(5);
        jScrollPane6.setViewportView(areaEnvio);

        jPanel3.add(jScrollPane6);
        jScrollPane6.setBounds(433, 79, 367, 84);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbEnvios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NUMERO", "DESTINATARIO" }));
        cmbEnvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnviosActionPerformed(evt);
            }
        });

        autoEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoEnvioActionPerformed(evt);
            }
        });

        btnBusca2.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca2.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca2.setBorder(null);
        btnBusca2.setBorderPainted(false);
        btnBusca2.setContentAreaFilled(false);
        btnBusca2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusca2.setIconTextGap(-1);
        btnBusca2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBusca2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEnvios, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBusca2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cmbEnvios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7);
        jPanel7.setBounds(89, 81, 277, 82);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ID");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(90, 410, 24, 14);
        jPanel3.add(txtIdEnvio);
        txtIdEnvio.setBounds(120, 400, 76, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Comentario");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(433, 58, 71, 15);

        jButton5.setText("jButton3");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(376, 81, 24, 23);

        btnSalida6.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida6.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entrada_mini.png"))); // NOI18N
        btnSalida6.setBorder(null);
        btnSalida6.setBorderPainted(false);
        btnSalida6.setContentAreaFilled(false);
        btnSalida6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida6.setIconTextGap(-1);
        btnSalida6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida6ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalida6);
        btnSalida6.setBounds(210, 390, 40, 40);

        btnSalida7.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida7.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida_mini.png"))); // NOI18N
        btnSalida7.setBorder(null);
        btnSalida7.setBorderPainted(false);
        btnSalida7.setContentAreaFilled(false);
        btnSalida7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida7.setIconTextGap(-1);
        btnSalida7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida7ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalida7);
        btnSalida7.setBounds(250, 390, 40, 40);

        btnSalida8.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida8.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio_mini.png"))); // NOI18N
        btnSalida8.setBorder(null);
        btnSalida8.setBorderPainted(false);
        btnSalida8.setContentAreaFilled(false);
        btnSalida8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida8.setIconTextGap(-1);
        btnSalida8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida8ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalida8);
        btnSalida8.setBounds(290, 390, 40, 40);

        jButton15.setBackground(new java.awt.Color(0, 153, 153));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("ELIMINAR");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15);
        jButton15.setBounds(460, 400, 95, 40);

        jButton16.setBackground(new java.awt.Color(0, 153, 153));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("EDITAR");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16);
        jButton16.setBounds(360, 400, 95, 40);

        jTabbedPane1.addTab("ENVIOS", jPanel3);

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("REGISTRO DE PRESTAMOS");
        jPanel14.add(jLabel26);
        jLabel26.setBounds(270, 20, 330, 29);

        tbPrestamos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "No.Rem", "Cliente", "Telefono", "Correo", "Equipo", "Modelo", "Serie", "Observacion", "Prestamo", "id_cli"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPrestamos.setToolTipText("");
        tbPrestamos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbPrestamos.setGridColor(new java.awt.Color(0, 153, 153));
        tbPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPrestamosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbPrestamos);

        jPanel14.add(jScrollPane7);
        jScrollPane7.setBounds(70, 180, 760, 202);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbPrestamo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NUMERO", "CLIENTE", "SERIE" }));
        cmbPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrestamoActionPerformed(evt);
            }
        });

        autoPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoPresActionPerformed(evt);
            }
        });

        btnBusca7.setBackground(new java.awt.Color(255, 255, 255));
        btnBusca7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusca7.setForeground(new java.awt.Color(255, 255, 255));
        btnBusca7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa2.png"))); // NOI18N
        btnBusca7.setBorder(null);
        btnBusca7.setBorderPainted(false);
        btnBusca7.setContentAreaFilled(false);
        btnBusca7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusca7.setIconTextGap(-1);
        btnBusca7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBusca7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusca7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoPres, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBusca7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBusca7)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(cmbPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel17);
        jPanel17.setBounds(68, 75, 277, 90);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("ID");
        jPanel14.add(jLabel27);
        jLabel27.setBounds(70, 410, 24, 14);
        jPanel14.add(txtIdPrestamo);
        txtIdPrestamo.setBounds(100, 400, 76, 30);

        areaPrestamo.setColumns(20);
        areaPrestamo.setRows(5);
        jScrollPane12.setViewportView(areaPrestamo);

        jPanel14.add(jScrollPane12);
        jScrollPane12.setBounds(417, 75, 410, 84);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Observaciones");
        jPanel14.add(jLabel28);
        jLabel28.setBounds(417, 54, 87, 15);

        btnSalida9.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida9.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entrada_mini.png"))); // NOI18N
        btnSalida9.setBorder(null);
        btnSalida9.setBorderPainted(false);
        btnSalida9.setContentAreaFilled(false);
        btnSalida9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida9.setIconTextGap(-1);
        btnSalida9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida9ActionPerformed(evt);
            }
        });
        jPanel14.add(btnSalida9);
        btnSalida9.setBounds(200, 390, 40, 40);

        btnSalida10.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida10.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida_mini.png"))); // NOI18N
        btnSalida10.setBorder(null);
        btnSalida10.setBorderPainted(false);
        btnSalida10.setContentAreaFilled(false);
        btnSalida10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida10.setIconTextGap(-1);
        btnSalida10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida10ActionPerformed(evt);
            }
        });
        jPanel14.add(btnSalida10);
        btnSalida10.setBounds(240, 390, 40, 40);

        btnSalida11.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalida11.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/envio_mini.png"))); // NOI18N
        btnSalida11.setBorder(null);
        btnSalida11.setBorderPainted(false);
        btnSalida11.setContentAreaFilled(false);
        btnSalida11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalida11.setIconTextGap(-1);
        btnSalida11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalida11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalida11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalida11ActionPerformed(evt);
            }
        });
        jPanel14.add(btnSalida11);
        btnSalida11.setBounds(280, 390, 40, 40);

        jButton18.setBackground(new java.awt.Color(0, 153, 153));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("EDITAR");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton18);
        jButton18.setBounds(340, 400, 100, 40);

        jButton19.setBackground(new java.awt.Color(0, 153, 153));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("ELIMINAR");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton19);
        jButton19.setBounds(450, 400, 100, 40);

        jButton6.setText("jButton3");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton6);
        jButton6.setBounds(355, 75, 24, 23);

        jTabbedPane1.addTab("PRESTAMO", jPanel14);

        jTabbedPane2.addTab("REGISTROS", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

        if (autoEntra.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe llenar campo para su busqueda");
        } else {
            String guardar = autoEntra.getText();
            int tipo = cmbEntradas.getSelectedIndex();
            switch (tipo) {
                case 0:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from entradas where numero = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarEntradas();
                        if (rs.next()) {
                            Entradas en = new Entradas();
                            en.setId_entrada(rs.getInt("id_entra"));
                            en.setFecha(rs.getString("fecha"));
                            en.setNumero(rs.getString("numero"));
                            en.setEmpresa(rs.getString("empresa"));
                            en.setNit(rs.getString("nit"));
                            en.setTelefono_contacto(rs.getString("telefono"));
                            en.setCorreo(rs.getString("correo"));
                            en.setElemento(rs.getString("elemento"));
                            en.setMarca(rs.getString("marca"));
                            en.setModelo(rs.getString("modelo"));
                            en.setSerie(rs.getString("serie"));
                            en.setGarantia(rs.getString("garantia"));
                            en.setObservaciones(rs.getString("observaciones"));
                            en.setEstado(rs.getString("estado"));
                            en.setId_cli((rs.getInt("id_cli")));
                            entrada.add(en);
                            DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
                            tb.addRow(new Object[]{en.getId_entrada(), en.getFecha(), en.getNumero(), en.getEmpresa(), en.getNit(), en.getTelefono_contacto(), en.getCorreo(), en.getElemento(), en.getMarca(), en.getModelo(), en.getSerie(), en.getGarantia(), en.getObservaciones(), en.getEstado(), en.getId_cli()});
                            autoCompleteEntradas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from entradas where empresa = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarEntradas();
                        while (rs.next()) {
                            Entradas en = new Entradas();
                            en.setId_entrada(rs.getInt("id_entra"));
                            en.setFecha(rs.getString("fecha"));
                            en.setNumero(rs.getString("numero"));
                            en.setEmpresa(rs.getString("empresa"));
                            en.setNit(rs.getString("nit"));
                            en.setTelefono_contacto(rs.getString("telefono"));
                            en.setCorreo(rs.getString("correo"));
                            en.setElemento(rs.getString("elemento"));
                            en.setMarca(rs.getString("marca"));
                            en.setModelo(rs.getString("modelo"));
                            en.setSerie(rs.getString("serie"));
                            en.setGarantia(rs.getString("garantia"));
                            en.setObservaciones(rs.getString("observaciones"));
                            en.setEstado(rs.getString("estado"));
                            en.setId_cli((rs.getInt("id_cli")));
                            entrada.add(en);
                            DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
                            tb.addRow(new Object[]{en.getId_entrada(), en.getFecha(), en.getNumero(), en.getEmpresa(), en.getNit(), en.getTelefono_contacto(), en.getCorreo(), en.getElemento(), en.getMarca(), en.getModelo(), en.getSerie(), en.getGarantia(), en.getObservaciones(), en.getEstado(), en.getId_cli()});
                            autoCompleteEntradas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from entradas where nit = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarEntradas();
                        while (rs.next()) {
                            Entradas en = new Entradas();
                            en.setId_entrada(rs.getInt("id_entra"));
                            en.setFecha(rs.getString("fecha"));
                            en.setNumero(rs.getString("numero"));
                            en.setEmpresa(rs.getString("empresa"));
                            en.setNit(rs.getString("nit"));
                            en.setTelefono_contacto(rs.getString("telefono"));
                            en.setCorreo(rs.getString("correo"));
                            en.setElemento(rs.getString("elemento"));
                            en.setMarca(rs.getString("marca"));
                            en.setModelo(rs.getString("modelo"));
                            en.setSerie(rs.getString("serie"));
                            en.setGarantia(rs.getString("garantia"));
                            en.setObservaciones(rs.getString("observaciones"));
                            en.setEstado(rs.getString("estado"));
                            en.setId_cli((rs.getInt("id_cli")));
                            entrada.add(en);
                            DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
                            tb.addRow(new Object[]{en.getId_entrada(), en.getFecha(), en.getNumero(), en.getEmpresa(), en.getNit(), en.getTelefono_contacto(), en.getCorreo(), en.getElemento(), en.getMarca(), en.getModelo(), en.getSerie(), en.getGarantia(), en.getObservaciones(), en.getEstado(), en.getId_cli()});
                            autoCompleteEntradas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from entradas where serie = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarEntradas();
                        while (rs.next()) {
                            Entradas en = new Entradas();
                            en.setId_entrada(rs.getInt("id_entra"));
                            en.setFecha(rs.getString("fecha"));
                            en.setNumero(rs.getString("numero"));
                            en.setEmpresa(rs.getString("empresa"));
                            en.setNit(rs.getString("nit"));
                            en.setTelefono_contacto(rs.getString("telefono"));
                            en.setCorreo(rs.getString("correo"));
                            en.setElemento(rs.getString("elemento"));
                            en.setMarca(rs.getString("marca"));
                            en.setModelo(rs.getString("modelo"));
                            en.setSerie(rs.getString("serie"));
                            en.setGarantia(rs.getString("garantia"));
                            en.setObservaciones(rs.getString("observaciones"));
                            en.setEstado(rs.getString("estado"));
                            en.setId_cli((rs.getInt("id_cli")));
                            entrada.add(en);
                            DefaultTableModel tb = (DefaultTableModel) tbEntradas.getModel();
                            tb.addRow(new Object[]{en.getId_entrada(), en.getFecha(), en.getNumero(), en.getEmpresa(), en.getNit(), en.getTelefono_contacto(), en.getCorreo(), en.getElemento(), en.getMarca(), en.getModelo(), en.getSerie(), en.getGarantia(), en.getObservaciones(), en.getEstado(), en.getId_cli()});
                            autoCompleteEntradas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca1ActionPerformed

        if (autoSal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe llenar campo para su busqueda");
        } else {
            String guardar = autoSal.getText();
            int tipo = cmbSalidas.getSelectedIndex();
            switch (tipo) {
                case 0:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from salidas where numero = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarSalidas();
                        if (rs.next()) {
                            Salidas sal = new Salidas();
                            sal.setId_salida(rs.getInt("id_salida"));
                            sal.setFecha(rs.getString("fecha"));
                            sal.setNumero(rs.getString("numero"));
                            sal.setEmpresa(rs.getString("empresa"));
                            sal.setTelefono(rs.getString("telefono"));
                            sal.setCorreo(rs.getString("correo"));
                            sal.setEquipo(rs.getString("equipo"));
                            sal.setModelo(rs.getString("modelo"));
                            sal.setSerie(rs.getString("serie"));
                            sal.setComentario(rs.getString("comentario"));
                            sal.setPrestamo(rs.getString("prestamo"));
                            sal.setId_cli(rs.getInt("id_cli"));
                            salida.add(sal);
                            DefaultTableModel tb = (DefaultTableModel) tbSalidas.getModel();
                            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
                            autoCompleteSalidas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from salidas where empresa = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarSalidas();
                        while (rs.next()) {
                            Salidas sal = new Salidas();
                            sal.setId_salida(rs.getInt("id_salida"));
                            sal.setFecha(rs.getString("fecha"));
                            sal.setNumero(rs.getString("numero"));
                            sal.setEmpresa(rs.getString("empresa"));
                            sal.setTelefono(rs.getString("telefono"));
                            sal.setCorreo(rs.getString("correo"));
                            sal.setEquipo(rs.getString("equipo"));
                            sal.setModelo(rs.getString("modelo"));
                            sal.setSerie(rs.getString("serie"));
                            sal.setComentario(rs.getString("comentario"));
                            sal.setPrestamo(rs.getString("prestamo"));
                            sal.setId_cli(rs.getInt("id_cli"));
                            salida.add(sal);
                            DefaultTableModel tb = (DefaultTableModel) tbSalidas.getModel();
                            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
                            autoCompleteSalidas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from salidas where serie = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarSalidas();
                        while (rs.next()) {
                            Salidas sal = new Salidas();
                            sal.setId_salida(rs.getInt("id_salida"));
                            sal.setFecha(rs.getString("fecha"));
                            sal.setNumero(rs.getString("numero"));
                            sal.setEmpresa(rs.getString("empresa"));
                            sal.setTelefono(rs.getString("telefono"));
                            sal.setCorreo(rs.getString("correo"));
                            sal.setEquipo(rs.getString("equipo"));
                            sal.setModelo(rs.getString("modelo"));
                            sal.setSerie(rs.getString("serie"));
                            sal.setComentario(rs.getString("comentario"));
                            sal.setPrestamo(rs.getString("prestamo"));
                            sal.setId_cli(rs.getInt("id_cli"));
                            salida.add(sal);
                            DefaultTableModel tb = (DefaultTableModel) tbSalidas.getModel();
                            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
                            autoCompleteSalidas();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnBusca1ActionPerformed

    private void btnBusca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca2ActionPerformed

        if (autoEnvio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe llenar campo para su busqueda");
        } else {
            String guardar = autoEnvio.getText();
            int tipo = cmbEnvios.getSelectedIndex();
            switch (tipo) {
                case 0:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from envios where numero = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarEnvios();
                        if (rs.next()) {
                            Envios en = new Envios();
                            en.setId_envio(rs.getInt("id_envio"));
                            en.setFecha(rs.getString("fecha"));
                            en.setNumero(rs.getString("numero"));
                            en.setDestinatario(rs.getString("destinatario"));
                            en.setATN(rs.getString("atn"));
                            en.setDireccion(rs.getString("direccion"));
                            en.setTelefono(rs.getString("telefono"));
                            en.setCiudad(rs.getString("ciudad"));
                            en.setComentario(rs.getString("comentario"));
                            en.setId_cli(rs.getInt("id_cli"));
                            envio.add(en);
                            DefaultTableModel tb = (DefaultTableModel) tbEnvios.getModel();
                            tb.addRow(new Object[]{en.getId_envio(), en.getFecha(), en.getNumero(), en.getDestinatario(), en.getATN(), en.getDireccion(), en.getTelefono(), en.getCiudad(), en.getComentario(), en.getId_cli()});

                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from envios where destinatario = ?");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarEnvios();
                        while (rs.next()) {
                            Envios en = new Envios();
                            en.setId_envio(rs.getInt("id_envio"));
                            en.setFecha(rs.getString("fecha"));
                            en.setNumero(rs.getString("numero"));
                            en.setDestinatario(rs.getString("destinatario"));
                            en.setATN(rs.getString("atn"));
                            en.setDireccion(rs.getString("direccion"));
                            en.setTelefono(rs.getString("telefono"));
                            en.setCiudad(rs.getString("ciudad"));
                            en.setComentario(rs.getString("comentario"));
                            en.setId_cli(rs.getInt("id_cli"));
                            envio.add(en);
                            DefaultTableModel tb = (DefaultTableModel) tbEnvios.getModel();
                            tb.addRow(new Object[]{en.getId_envio(), en.getFecha(), en.getNumero(), en.getDestinatario(), en.getATN(), en.getDireccion(), en.getTelefono(), en.getCiudad(), en.getComentario(), en.getId_cli()});

                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca2ActionPerformed

    private void cmbSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSalidasActionPerformed

        autoSal.setText("");
        autoCompleteSalidas();

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSalidasActionPerformed

    private void cmbEnviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnviosActionPerformed

        autoEnvio.setText("");
        autoCompleteEnvios();

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEnviosActionPerformed

    private void tbEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEntradasMouseClicked

        int seleccion = tbEntradas.getSelectedRow();
        txtIdEntrada.setText(String.valueOf(tbEntradas.getValueAt(seleccion, 0)));
        areaEntrada.setText(String.valueOf(tbEntradas.getValueAt(seleccion, 12)));
        txtEstado.setText(String.valueOf(tbEntradas.getValueAt(seleccion, 13)));

// TODO add your handling code here:
    }//GEN-LAST:event_tbEntradasMouseClicked

    private void tbSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalidasMouseClicked

        int seleccion = tbSalidas.getSelectedRow();
        txtIdSalida.setText(String.valueOf(tbSalidas.getValueAt(seleccion, 0)));
        areaSalida.setText(String.valueOf(tbSalidas.getValueAt(seleccion, 9)));

// TODO add your handling code here:
    }//GEN-LAST:event_tbSalidasMouseClicked

    private void tbEnviosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEnviosMouseClicked

        int seleccion = tbEnvios.getSelectedRow();
        txtIdEnvio.setText(String.valueOf(tbEnvios.getValueAt(seleccion, 0)));
        areaEnvio.setText(String.valueOf(tbEnvios.getValueAt(seleccion, 8)));

// TODO add your handling code here:
    }//GEN-LAST:event_tbEnviosMouseClicked

    private void cmbEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEntradasActionPerformed

        autoEntra.setText("");
        autoCompleteEntradas();

// TODO add your handling code here:
    }//GEN-LAST:event_cmbEntradasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        LimpiarEntradas();
        ListarEntradas();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        LimpiarSalidas();
        ListarSalidas();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        LimpiarEnvios();
        ListarEnvios();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed

        Entrada obj = new Entrada();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void btnSalida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida2ActionPerformed

        Salidass obj = new Salidass();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalida2ActionPerformed

    private void btnSalida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida1ActionPerformed

        Envio obj = new Envio();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalida1ActionPerformed

    private void btnSalida3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida3ActionPerformed

        Entrada obj = new Entrada();
        obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSalida3ActionPerformed

    private void btnSalida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida4ActionPerformed

        Salidass obj = new Salidass();
        obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSalida4ActionPerformed

    private void btnSalida5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida5ActionPerformed

        Envio obj = new Envio();
        obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSalida5ActionPerformed

    private void btnSalida6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida6ActionPerformed

        Entrada obj = new Entrada();
        obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSalida6ActionPerformed

    private void btnSalida7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida7ActionPerformed

        Salidass obj = new Salidass();
        obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSalida7ActionPerformed

    private void btnSalida8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida8ActionPerformed

        Envio obj = new Envio();
        obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSalida8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        if (txtIdEntrada.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
            int seleccion = tbEntradas.getSelectedRow();

            id_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 0));
            fecha_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 1));
            numero_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 2));
            cliente_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 3));
            nit_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 4));
            telefono_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 5));
            correo_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 6));
            elemento_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 7));
            marca_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 8));
            modelo_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 9));
            serie_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 10));
            garantia_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 11));
            observacion_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 12));
            estado_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 13));
            id_cli_entrada = String.valueOf(tbEntradas.getValueAt(seleccion, 14));

            Editar_Entrada obj = new Editar_Entrada();
            obj.setVisible(true);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        if (txtIdSalida.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {

            int seleccion = tbSalidas.getSelectedRow();
            Salidas sal = new Salidas();
            sal.setNumero(String.valueOf(tbSalidas.getValueAt(seleccion, 2)));

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                dbSalida.EliminarSalida(sal);
                LimpiarSalidas();
                ListarSalidas();
                txtIdSalida.setText("");
                areaSalida.setText("");
            } else {
                txtIdSalida.setText("");
                areaSalida.setText("");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        if (txtIdSalida.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
            int seleccion = tbSalidas.getSelectedRow();

            fecha_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 1));
            numero_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 2));
            cliente_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 3));
            telefono_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 4));
            correo_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 5));
            equipo_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 6));
            modelo_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 7));
            serie_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 8));
            observacion_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 9));
            prestamo_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 10));
            id_cli_salida = String.valueOf(tbSalidas.getValueAt(seleccion, 11));

            Editar_Salida obj = new Editar_Salida();
            obj.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        try {

            if (txtIdEnvio.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
            } else {
                int seleccion = tbEnvios.getSelectedRow();
                Envios en = new Envios();
                en.setNumero(String.valueOf(tbEnvios.getValueAt(seleccion, 2)));

                Object[] opciones = {"Aceptar", "Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
                if (eleccion == JOptionPane.YES_OPTION) {
                    dbEnvio.EliminarEnvio(en);
                    LimpiarEnvios();
                    ListarEnvios();
                    txtIdEnvio.setText("");
                    areaEnvio.setText("");
                } else {
                    txtIdSalida.setText("");
                    areaSalida.setText("");
                }
            }
        } catch (Exception e) {
            System.err.println("error" + e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        if (txtIdEnvio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
            int seleccion = tbEnvios.getSelectedRow();

            id_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 0));
            fecha_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 1));
            numero_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 2));
            destinatario_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));
            atn_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));
            direccion_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));
            telefono_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));
            ciudad_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));
            comentario_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));
            id_cli_envio = String.valueOf(tbEnvios.getValueAt(seleccion, 3));

            Editar_Envio obj = new Editar_Envio();
            obj.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        try {
            if (txtIdEntrada.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
            } else {
                Entradas en = new Entradas();
                Garantias gar = new Garantias();
                int seleccion = tbEntradas.getSelectedRow();
                en.setNumero(String.valueOf(tbEntradas.getValueAt(seleccion, 2)));
                gar.setId_entra(Integer.parseInt(txtIdEntrada.getText()));
                Object[] opciones = {"Aceptar", "Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
                if (eleccion == JOptionPane.YES_OPTION) {
                    dbEntrada.EliminarEntrada(en);
                    dbGarantia.EliminarGarantia(gar);
                    LimpiarEntradas();
                    ListarEntradas();
                    txtIdEntrada.setText("");
                    areaEntrada.setText("");
                } else {
                    LimpiarEntradas();
                    ListarEntradas();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error:" + e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void autoSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoSalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoSalActionPerformed

    private void autoEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoEnvioActionPerformed

    private void tbPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPrestamosMouseClicked

        int seleccion = tbPrestamos.getSelectedRow();
        txtIdPrestamo.setText(String.valueOf(tbPrestamos.getValueAt(seleccion, 0)));
        areaPrestamo.setText(String.valueOf(tbPrestamos.getValueAt(seleccion, 9)));

        // TODO add your handling code here:
    }//GEN-LAST:event_tbPrestamosMouseClicked

    private void cmbPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrestamoActionPerformed

        autoPres.setText("");
        autoCompletePrestamo();

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPrestamoActionPerformed

    private void autoPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoPresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoPresActionPerformed

    private void btnBusca7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca7ActionPerformed

        if (autoPres.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe llenar campo para su busqueda");
        } else {
            String guardar = autoPres.getText();
            int tipo = cmbPrestamo.getSelectedIndex();
            switch (tipo) {
                case 0:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from salidas where numero = ? AND prestamo = 'SI'");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarPrestamo();
                        if (rs.next()) {
                            Salidas sal = new Salidas();
                            sal.setId_salida(rs.getInt("id_salida"));
                            sal.setFecha(rs.getString("fecha"));
                            sal.setNumero(rs.getString("numero"));
                            sal.setEmpresa(rs.getString("empresa"));
                            sal.setTelefono(rs.getString("telefono"));
                            sal.setCorreo(rs.getString("correo"));
                            sal.setEquipo(rs.getString("equipo"));
                            sal.setModelo(rs.getString("modelo"));
                            sal.setSerie(rs.getString("serie"));
                            sal.setComentario(rs.getString("comentario"));
                            sal.setPrestamo(rs.getString("prestamo"));
                            sal.setId_cli(rs.getInt("id_cli"));
                            salida.add(sal);
                            DefaultTableModel tb = (DefaultTableModel) tbPrestamos.getModel();
                            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
                            autoCompletePrestamo();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from salidas where empresa = ? AND prestamo = 'SI'");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarPrestamo();
                        while (rs.next()) {
                            Salidas sal = new Salidas();
                            sal.setId_salida(rs.getInt("id_salida"));
                            sal.setFecha(rs.getString("fecha"));
                            sal.setNumero(rs.getString("numero"));
                            sal.setEmpresa(rs.getString("empresa"));
                            sal.setTelefono(rs.getString("telefono"));
                            sal.setCorreo(rs.getString("correo"));
                            sal.setEquipo(rs.getString("equipo"));
                            sal.setModelo(rs.getString("modelo"));
                            sal.setSerie(rs.getString("serie"));
                            sal.setComentario(rs.getString("comentario"));
                            sal.setPrestamo(rs.getString("prestamo"));
                            sal.setId_cli(rs.getInt("id_cli"));
                            salida.add(sal);
                            DefaultTableModel tb = (DefaultTableModel) tbPrestamos.getModel();
                            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
                            autoCompletePrestamo();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        // id_entra,  numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones,
                        Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
                        Statement st = cn.createStatement();
                        PreparedStatement pst = cn.prepareStatement("Select * from salidas where serie = ? AND prestamo = 'SI'");
                        pst.setString(1, guardar);
                        ResultSet rs = pst.executeQuery();
                        LimpiarPrestamo();
                        while (rs.next()) {
                            Salidas sal = new Salidas();
                            sal.setId_salida(rs.getInt("id_salida"));
                            sal.setFecha(rs.getString("fecha"));
                            sal.setNumero(rs.getString("numero"));
                            sal.setEmpresa(rs.getString("empresa"));
                            sal.setTelefono(rs.getString("telefono"));
                            sal.setCorreo(rs.getString("correo"));
                            sal.setEquipo(rs.getString("equipo"));
                            sal.setModelo(rs.getString("modelo"));
                            sal.setSerie(rs.getString("serie"));
                            sal.setComentario(rs.getString("comentario"));
                            sal.setPrestamo(rs.getString("prestamo"));
                            sal.setId_cli(rs.getInt("id_cli"));
                            salida.add(sal);
                            DefaultTableModel tb = (DefaultTableModel) tbPrestamos.getModel();
                            tb.addRow(new Object[]{sal.getId_salida(), sal.getFecha(), sal.getNumero(), sal.getEmpresa(), sal.getTelefono(), sal.getCorreo(), sal.getEquipo(), sal.getModelo(), sal.getSerie(), sal.getComentario(), sal.getPrestamo(), sal.getId_cli()});
                            autoCompletePrestamo();
                        }
                        cn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR EN BUSQUEDA: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca7ActionPerformed

    private void btnSalida9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida9ActionPerformed

        Entrada obj = new Entrada();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalida9ActionPerformed

    private void btnSalida10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida10ActionPerformed

        Salidass obj = new Salidass();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalida10ActionPerformed

    private void btnSalida11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalida11ActionPerformed

        Envio obj = new Envio();
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalida11ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        if (txtIdPrestamo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
        } else {
            int seleccion = tbPrestamos.getSelectedRow();

            fecha_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 1));
            numero_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 2));
            cliente_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 3));
            telefono_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 4));
            correo_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 5));
            equipo_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 6));
            modelo_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 7));
            serie_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 8));
            observacion_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 9));
            prestamo_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 10));
            id_cli_salida = String.valueOf(tbPrestamos.getValueAt(seleccion, 11));

            Editar_Salida obj = new Editar_Salida();
            obj.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        try {
            if (txtIdPrestamo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
            } else {

                int seleccion = tbPrestamos.getSelectedRow();
                Salidas sal = new Salidas();
                sal.setNumero(String.valueOf(tbPrestamos.getValueAt(seleccion, 2)));

                Object[] opciones = {"Aceptar", "Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea ELIMINAR este registro?", "Mensaje de Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
                if (eleccion == JOptionPane.YES_OPTION) {
                    dbSalida.EliminarSalida(sal);
                    LimpiarSalidas();
                    ListarSalidas();
                    LimpiarPrestamo();
                    ListarPrestamo();
                    txtIdSalida.setText("");
                    areaSalida.setText("");
                } else {
                    txtIdSalida.setText("");
                    areaSalida.setText("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error:" + e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        LimpiarPrestamo();
        ListarPrestamo();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Tecnico_Oper.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico_Oper.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico_Oper.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico_Oper.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico_Oper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaEntrada;
    private javax.swing.JTextArea areaEnvio;
    private javax.swing.JTextArea areaPrestamo;
    private javax.swing.JTextArea areaSalida;
    private javax.swing.JTextField autoEntra;
    private javax.swing.JTextField autoEnvio;
    private javax.swing.JTextField autoPres;
    private javax.swing.JTextField autoSal;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnBusca1;
    private javax.swing.JButton btnBusca2;
    private javax.swing.JButton btnBusca7;
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton btnSalida1;
    private javax.swing.JButton btnSalida10;
    private javax.swing.JButton btnSalida11;
    private javax.swing.JButton btnSalida2;
    private javax.swing.JButton btnSalida3;
    private javax.swing.JButton btnSalida4;
    private javax.swing.JButton btnSalida5;
    private javax.swing.JButton btnSalida6;
    private javax.swing.JButton btnSalida7;
    private javax.swing.JButton btnSalida8;
    private javax.swing.JButton btnSalida9;
    private javax.swing.JComboBox cmbEntradas;
    private javax.swing.JComboBox cmbEnvios;
    private javax.swing.JComboBox cmbPrestamo;
    private javax.swing.JComboBox cmbSalidas;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tbEntradas;
    private javax.swing.JTable tbEnvios;
    private javax.swing.JTable tbPrestamos;
    private javax.swing.JTable tbSalidas;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdEntrada;
    private javax.swing.JTextField txtIdEnvio;
    private javax.swing.JTextField txtIdPrestamo;
    private javax.swing.JTextField txtIdSalida;
    // End of variables declaration//GEN-END:variables
}

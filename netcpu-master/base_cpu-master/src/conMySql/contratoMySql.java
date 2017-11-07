/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;

import clasesPrincipales.clientes;
import clasesPrincipales.contratos;

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
//import run.Main;


//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
//import com.mysql.jdbc.Connection;
/**
 *
 * @author CPU_SYS
 */
public class contratoMySql {

    //Codigo para el listado en la base de datos...
    public ArrayList<contratos> ListContrato() {
        ArrayList<contratos> contrato = new ArrayList();
        try {       
            //Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            //Connection cn = DataBaseConexion.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_contrato, numero, fecha_inicio, fecha_fin, cliente, nit_ced, responsable FROM contratos ORDER BY fecha_inicio DESC");
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
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n"+ex.getMessage());
        }
        return contrato;
    }

    //Codigo para INSERTAR DATOS.........................................................
    public void InsertarContrato(contratos contrato) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst =  cn.prepareStatement("INSERT INTO contratos(numero, fecha_inicio, fecha_fin, cliente, nit_ced, responsable) VALUES (?,?,?,?,?,?)");
            //pst.setInt(1, cliente.getId_cliente());
            pst.setString(1, contrato.getNumero());
            pst.setString(2, contrato.getFecha_inicio());
            pst.setString(3, contrato.getFecha_fin());
            pst.setString(4, contrato.getCliente());
            pst.setString(5, contrato.getNit_ced());
            pst.setString(6, contrato.getResponsable());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage()); 
        }
    }
    /*
    public void insertarUsuarios(clientes cliente) {
        try {
            Connection cnx = DataBaseConexion.getConnection();
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement("INSERT INTO CLIENTES (NIT, NOMBRE, TELEFONO, DIRECCION, CIUDAD, CORREO, CONTACTO) \n"
                    + " VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, cliente.getNit_cliente());
            pst.setString(2, cliente.getNombre_cliente());
            pst.setString(3, cliente.getTelefono_cliente());
            pst.setString(4, cliente.getDireccion_cliente());
            pst.setString(5, cliente.getCiudad_cliente());
            pst.setString(6, cliente.getCorreo_cliente());
            pst.setString(7, cliente.getNombre_contacto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
    }
    */

    //Codigo para MODIFICAR datos
    public void EditarContrato(contratos con) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE contratos SET numero = ?, fecha_inicio = ?, fecha_fin = ?, cliente = ?, nit_ced = ?, responsable = ? WHERE id_contrato = ?");
            pst.setString(1, con.getNumero());
            pst.setString(2, con.getFecha_inicio());
            pst.setString(3, con.getFecha_fin());
            pst.setString(4, con.getCliente());
            pst.setString(5, con.getNit_ced());
            pst.setString(6, con.getResponsable());
            pst.setInt(8, con.getId_contrato());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(contratoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }

   
    public void EliminarContrato(contratos con) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM contratos WHERE id_contrato = ?");
            pst.setInt(1, con.getId_contrato());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(contratoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    


    /*
    public void Buscar(clientes cli) {

        try {
            Connection cnx = DataBaseConexion.getConnection();
            PreparedStatement pst = cnx.prepareStatement("SELECT * FROM CLIENTES WHERE NOMBRECLIENTE = ?");
            //pst.setString(1, CMBID.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                pst.setString(1, rs.getString(cli.getNit_cliente()).trim());
                pst.setString(2, rs.getString(cli.getNombre_cliente()).trim());
                pst.setString(3, rs.getString(cli.getTelefono_cliente()).trim());
                pst.setString(4, rs.getString(cli.getDireccion_cliente()).trim());
                pst.setString(5, rs.getString(cli.getCiudad_cliente()).trim());
                pst.setString(6, rs.getString(cli.getCorreo_cliente()).trim());
                pst.setString(7, rs.getString(cli.getNombre_contacto()).trim());
           
                //pst.setString(1, CMBID.getName());
                //String guardar = txtBuscar.getText();
                //txtID.setText(guardar);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
        } catch (Exception er) {
            System.out.println("error en buscar " + er);
        }
    }
    */
   

    /*

     //BUSCAR DATOS DE CLIENTES
     public clientes Buscar(String buscar) {
     clientes c = null;
     try {
     Connection cnx = DataBaseConexion.getConnection();
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery("SELECT IDCLIENTE,NOMBRE,APELLIDO,DNI,TELEFONO,DIRECCION"
     + " FROM CLIENTES "
     + " WHERE NOMBRE='" + buscar + "' OR DNI='" + buscar + "'  ");
     while (rs.next()) {
     c = new clientes();
     c.setId_cliente(rs.getInt(1));
     c.setNit_cliente(rs.getString(2));
     c.setNombre_cliente(rs.getString(3));
     c.setTelefono_cliente(rs.getString(4));
     c.setDireccion_cliente(rs.getString(5));
     c.setCiudad_cliente(rs.getString(6));
     c.setCorreo_cliente(rs.getString(7));
     c.setNombre_contacto(rs.getString(8));
     }
     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     }
     return c;
     }

     public void Buscar(clientes cli) {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
    
     */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;

import clasesPrincipales.Salidas;
import clasesPrincipales.clientes;
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

/**
 *
 * @author CPU_SYS
 */
public class salidaMySql {
    
    public ArrayList<Salidas> ListSalidas() {
        ArrayList<Salidas> salida = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_salida, numero, fecha, empresa, ciudad, direccion, contacto, telefono, correo, equipo, modelo, serie, comentario, prestamo, id_cli FROM salidas ORDER BY fecha DESC");
            while (rs.next()) {
                Salidas sal = new Salidas();
                sal.setId_salida(rs.getInt("id_salida"));
                sal.setNumero(rs.getString("numero"));
                sal.setFecha(rs.getString("fecha"));
                sal.setEmpresa(rs.getString("empresa"));
                sal.setCiudad(rs.getString("ciudad"));
                sal.setDireccion(rs.getString("direccion"));
                sal.setContacto(rs.getString("contacto"));
                sal.setTelefono(rs.getString("telefono"));
                sal.setCorreo(rs.getString("correo"));
                sal.setEquipo(rs.getString("equipo"));
                sal.setModelo(rs.getString("modelo"));
                sal.setSerie(rs.getString("serie"));
                sal.setComentario(rs.getString("comentario"));
                sal.setPrestamo(rs.getString("prestamo"));
                sal.setId_cli(rs.getInt("id_cli"));
                salida.add(sal);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n"+ex.getMessage());
        }
        return salida;
    }
    
    public ArrayList<Salidas> ListPrestamo() {
        ArrayList<Salidas> salida = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_salida, numero, fecha, empresa, ciudad, direccion, contacto, telefono, correo, equipo, modelo, serie, comentario, prestamo, id_cli FROM salidas WHERE prestamo = 'SI' ORDER BY fecha DESC");
            while (rs.next()) {
                Salidas sal = new Salidas();
                sal.setId_salida(rs.getInt("id_salida"));
                sal.setNumero(rs.getString("numero"));
                sal.setFecha(rs.getString("fecha"));
                sal.setEmpresa(rs.getString("empresa"));
                sal.setCiudad(rs.getString("ciudad"));
                sal.setDireccion(rs.getString("direccion"));
                sal.setContacto(rs.getString("contacto"));
                sal.setTelefono(rs.getString("telefono"));
                sal.setCorreo(rs.getString("correo"));
                sal.setEquipo(rs.getString("equipo"));
                sal.setModelo(rs.getString("modelo"));
                sal.setSerie(rs.getString("serie"));
                sal.setComentario(rs.getString("comentario"));
                sal.setPrestamo(rs.getString("prestamo"));
                sal.setId_cli(rs.getInt("id_cli"));
                salida.add(sal);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n"+ex.getMessage());
        }
        return salida;
    }
    
    public void insertarSalida(Salidas salida) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst =  cn.prepareStatement("INSERT INTO salidas(numero, fecha, empresa, ciudad, direccion, contacto, telefono, correo, equipo, modelo, serie, comentario, prestamo, id_cli) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, salida.getNumero());
            pst.setString(2, salida.getFecha());
            pst.setString(3, salida.getEmpresa());
            pst.setString(4, salida.getCiudad());
            pst.setString(5, salida.getDireccion());
            pst.setString(6, salida.getContacto());
            pst.setString(7, salida.getTelefono());
            pst.setString(8, salida.getCorreo());
            pst.setString(9, salida.getEquipo());
            pst.setString(10, salida.getModelo());
            pst.setString(11, salida.getSerie());
            pst.setString(12, salida.getComentario());
            pst.setString(13, salida.getPrestamo());
            pst.setInt(14, salida.getId_cli());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }
    
    public void EditarSalida(Salidas salida) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE salidas SET fecha=?,empresa=?,ciudad=?,direccion=?,contacto=?,telefono=?,correo=?,equipo=?,modelo=?,serie=?,comentario=?,prestamo=? WHERE numero = ?");
            pst.setString(1, salida.getFecha());
            pst.setString(2, salida.getEmpresa());
            pst.setString(3, salida.getCiudad());
            pst.setString(4, salida.getDireccion());
            pst.setString(5, salida.getContacto());
            pst.setString(6, salida.getTelefono());
            pst.setString(7, salida.getCorreo());
            pst.setString(8, salida.getEquipo());
            pst.setString(9, salida.getModelo());
            pst.setString(10, salida.getSerie());
            pst.setString(11, salida.getComentario());
            pst.setString(12, salida.getPrestamo());
            pst.setString(13, salida.getNumero());
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null, "Editado exitosamente");
         cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(salidaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }
    }
    
    public void EditarTablaSalida(Salidas salida) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE salidas SET fecha=?,empresa=?,telefono=?,correo=?,equipo=?,modelo=?,serie=?,comentario=?,prestamo=? WHERE numero = ?");
            pst.setString(1, salida.getFecha());
            pst.setString(2, salida.getEmpresa());
            pst.setString(3, salida.getTelefono());
            pst.setString(4, salida.getCorreo());
            pst.setString(5, salida.getEquipo());
            pst.setString(6, salida.getModelo());
            pst.setString(7, salida.getSerie());
            pst.setString(8, salida.getComentario());
            pst.setString(9, salida.getPrestamo());
            pst.setString(10, salida.getNumero());
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null, "Editado exitosamente");
         cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(salidaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }
    }
    
    public void EditarCliente(clientes cli) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE clientes SET nombre_cli = ?, telefono_cli = ?, direccion_cli = ?, ciudad_cli = ?, correo_cli = ?, contacto_cli = ? WHERE id_cli = ?");
    
            pst.setString(1, cli.getNombre_cliente());//
            pst.setString(2, cli.getTelefono_cliente());//
            pst.setString(3, cli.getDireccion_cliente());//
            pst.setString(4, cli.getCiudad_cliente());//
            pst.setString(5, cli.getCorreo_cliente());//
            pst.setString(6, cli.getNombre_contacto());//
            pst.setInt(7, cli.getId_cliente());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
    public void EditarClienteSalida(clientes cli) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE clientes SET nombre_cli = ?, telefono_cli = ?, correo_cli = ? WHERE id_cli = ?");
    
            pst.setString(1, cli.getNombre_cliente());//
            pst.setString(2, cli.getTelefono_cliente());//
            pst.setString(3, cli.getCorreo_cliente());//
            pst.setInt(4, cli.getId_cliente());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
    public void EliminarSalida(Salidas sal) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM salidas WHERE numero = ?");
            pst.setString(1, sal.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(salidaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
}

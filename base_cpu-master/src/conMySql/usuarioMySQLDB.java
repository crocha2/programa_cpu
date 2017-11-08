/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;

import clasesPrincipales.clientes;
import clasesPrincipales.usuarios;
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
import ventanas.Tabla_Clientes_Admin;

/**
 *
 * @author CPU_SYS
 */
public class usuarioMySQLDB {
    
    public ArrayList<usuarios> ListUsuarios() {
        ArrayList<usuarios> usuario = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_usu, nombre_usu, password_usu, id_tipo_usu FROM usuarios ORDER BY 2");
            while (rs.next()) {
                usuarios usu = new usuarios();
                usu.setId_usuario(rs.getInt("id_usu"));
                usu.setNombre(rs.getString("nombre_usu"));
                usu.setPassword(rs.getString("password_usu"));
                usu.setTipoUsuario(rs.getInt("id_tipo_usu"));
                usuario.add(usu);
            }
            cn.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar:\n"+ex.getMessage());
        }
        return usuario;
    }
    
    
    public void insertarUsuario(usuarios usuario) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO usuarios (nombre_usu, password_usu, id_tipo_usu) VALUES (?,?,?)");
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getPassword());
            pst.setInt(3, usuario.getTipoUsuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }
    
    /*
    public void EliminarUsuario(usuarios usu) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/basecpu", "root", "8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM usuarios "
                    + " WHERE nombre_usu=?");
            pst.setString(1, usu.getNombre());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioMySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    public void EliminarUsuarios(usuarios usu) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM usuarios WHERE nombre_usu=?");
            pst.setString(1, usu.getNombre());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
    public void EditarUsuario(usuarios usu) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE usuarios SET nombre_usu = ?, password_usu = ?, id_tipo_usu = ? WHERE id_usu = ?");
            pst.setString(1, usu.getNombre());
            pst.setString(2, usu.getPassword());
            pst.setInt(3, usu.getTipoUsuario());
            pst.setInt(4, usu.getId_usuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioMySQLDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }

    }
    
       
    
}

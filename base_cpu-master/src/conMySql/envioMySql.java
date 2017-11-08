/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;


import clasesPrincipales.Envios;
import clasesPrincipales.Salidas;
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
public class envioMySql {
    
    public ArrayList<Envios> ListEnvios() {
        ArrayList<Envios> envio = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_envio, numero, fecha, destinatario, atn, direccion, telefono, ciudad, comentario, id_cli FROM envios ORDER BY fecha DESC");
            while (rs.next()) {
                Envios env = new Envios();
                env.setId_envio(rs.getInt("id_envio"));
                env.setNumero(rs.getString("numero"));
                env.setFecha(rs.getString("fecha"));
                env.setDestinatario(rs.getString("destinatario"));
                env.setATN(rs.getString("atn"));
                env.setDireccion(rs.getString("direccion"));
                env.setTelefono(rs.getString("telefono"));
                env.setCiudad(rs.getString("ciudad"));
                env.setComentario(rs.getString("comentario"));
                env.setId_cli(rs.getInt("id_cli"));
                envio.add(env);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n"+ex.getMessage());
        }
        return envio;
    }
    
    public void insertarEnvio(Envios envio) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst =  cn.prepareStatement("INSERT INTO envios(numero, fecha, destinatario, atn, direccion, telefono, ciudad, comentario, id_cli) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, envio.getNumero());
            pst.setString(2, envio.getFecha());
            pst.setString(3, envio.getDestinatario());
            pst.setString(4, envio.getATN());
            pst.setString(5, envio.getDireccion());
            pst.setString(6, envio.getTelefono());
            pst.setString(7, envio.getCiudad());
            pst.setString(8, envio.getComentario());
            pst.setInt(9, envio.getId_cli());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n"+ex.getMessage());
        }
    }
    
    public void EditarEnvio(Envios envio) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE envios SET fecha=?,destinatario=?,atn=?,direccion=?,telefono=?,ciudad=?,comentario=? WHERE numero = ?");
            pst.setString(1, envio.getFecha());
            pst.setString(2, envio.getDestinatario());
            pst.setString(3, envio.getATN());
            pst.setString(4, envio.getDireccion());
            pst.setString(5, envio.getTelefono());
            pst.setString(6, envio.getCiudad());
            pst.setString(7, envio.getComentario());
            pst.setString(8, envio.getNumero());
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null, "Editado exitosamente");
         cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(envioMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n"+ex.getMessage());
        }
    }
    
    public void EliminarEnvio(Envios envio) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM envios WHERE numero = ?");
            pst.setString(1, envio.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(envioMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n"+ex.getMessage());
        }
    }
    
}

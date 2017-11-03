/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;

import clasesPrincipales.Entradas;
import clasesPrincipales.Listos;
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
public class listoMySql {


    public ArrayList<Listos> ListListos() {
        ArrayList<Listos> listo = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT e.id_entra, e.numero, e.fecha, e.elemento, e.marca, e.modelo, e.serie, e.empresa, e.nit, e.ciudad, e.garantia, e.observaciones, e.id_cli, g.estado, g.fecha_garantia, g.rma, g.numero_caso, g.serie_nueva, g.primera_serie \n"
                    + "FROM entradas e \n"
                    + "INNER JOIN garantias g \n"
                    + "ON e.id_entra = g.id_entra \n"
                    + "WHERE e.estado = 'LISTO' \n"
                    + "AND e.garantia = 'SI' ORDER BY e.fecha ASC");
            while (rs.next()) {
                Listos lis = new Listos();
                lis.setId_entra(rs.getInt("id_entra"));
                lis.setNumero(rs.getString("numero"));
                lis.setFecha_entrada(rs.getString("fecha"));
                lis.setFecha_garantia(rs.getString("fecha_garantia"));
                lis.setElemento(rs.getString("elemento"));
                lis.setMarca(rs.getString("marca"));
                lis.setModelo(rs.getString("modelo"));
                lis.setSerie_vieja(rs.getString("serie"));
                lis.setCliente(rs.getString("empresa"));
                lis.setNit(rs.getString("nit"));
                lis.setCiudad(rs.getString("ciudad"));
                lis.setGarantia(rs.getString("garantia"));
                lis.setObservacion(rs.getString("observaciones"));
                lis.setId_cli(rs.getInt("id_cli"));
                lis.setEstado(rs.getString("estado"));
                lis.setRma(rs.getString("rma"));
                lis.setSerie_nueva(rs.getString("serie_nueva"));
                lis.setNumero_caso(rs.getString("numero_caso"));
                lis.setPrimera_serie(rs.getString("primera_serie"));
                
                listo.add(lis);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n" + ex.getMessage());
        }
        return listo;
    }
    
    public ArrayList<Listos> ListEntregados() {
    ArrayList<Listos> listo = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT e.id_entra, e.numero, e.fecha, e.elemento, e.marca, e.modelo, e.serie, e.empresa, e.nit, e.ciudad, e.garantia, e.observaciones, e.id_cli, g.estado, g.fecha_garantia, g.rma, g.numero_caso, g.serie_nueva, g.primera_serie \n"
                    + "FROM entradas e \n"
                    + "INNER JOIN garantias g \n"
                    + "ON e.id_entra = g.id_entra \n"
                    + "WHERE e.estado = 'ENTREGADO' \n"
                    + "AND e.garantia = 'SI' ORDER BY e.fecha ASC");
            while (rs.next()) {
                Listos lis = new Listos();
                lis.setId_entra(rs.getInt("id_entra"));
                lis.setNumero(rs.getString("numero"));
                lis.setFecha_entrada(rs.getString("fecha"));
                lis.setFecha_garantia(rs.getString("fecha_garantia"));
                lis.setElemento(rs.getString("elemento"));
                lis.setMarca(rs.getString("marca"));
                lis.setModelo(rs.getString("modelo"));
                lis.setSerie_vieja(rs.getString("serie"));
                lis.setCliente(rs.getString("empresa"));
                lis.setNit(rs.getString("nit"));
                lis.setCiudad(rs.getString("ciudad"));
                lis.setGarantia(rs.getString("garantia"));
                lis.setObservacion(rs.getString("observaciones"));
                lis.setId_cli(rs.getInt("id_cli"));
                lis.setEstado(rs.getString("estado"));
                lis.setRma(rs.getString("rma"));
                lis.setSerie_nueva(rs.getString("serie_nueva"));
                lis.setNumero_caso(rs.getString("numero_caso"));
                lis.setPrimera_serie(rs.getString("primera_serie"));
                
                listo.add(lis);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n" + ex.getMessage());
        }
        return listo;
    }
    
  
    public ArrayList<Entradas> ListEntradas_garantias() {
        ArrayList<Entradas> entrada = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_entra, fecha, numero, empresa, nit, elemento, marca, modelo, serie, garantia, estado FROM entradas WHERE garantia = 'SI' AND estado = 'REVISION' ORDER BY fecha ASC");
            while (rs.next()) {
                Entradas en = new Entradas();
                en.setId_entrada(rs.getInt("id_entra"));
                en.setFecha(rs.getString("fecha"));
                en.setNumero(rs.getString("numero"));
                en.setEmpresa(rs.getString("empresa"));
                en.setNit(rs.getString("nit"));
                en.setElemento(rs.getString("elemento"));
                en.setMarca(rs.getString("marca"));
                en.setModelo(rs.getString("modelo"));
                en.setSerie(rs.getString("serie"));
                en.setGarantia(rs.getString("garantia"));
                en.setEstado(rs.getString("estado"));
                entrada.add(en);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n" + ex.getMessage());
        }
        return entrada;
    }

    //Codigo para INSERTAR DATOS.........................................................
    public void insertarEntrada(Entradas entrada) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO entradas(numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones, tarjeta, estado, id_cli) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, entrada.getNumero());
            pst.setString(2, entrada.getFecha());
            pst.setString(3, entrada.getElemento());
            pst.setString(4, entrada.getPotencia());
            pst.setString(5, entrada.getMarca());
            pst.setString(6, entrada.getModelo());
            pst.setString(7, entrada.getSerie());
            pst.setString(8, entrada.getEmpresa());
            pst.setString(9, entrada.getNit());
            pst.setString(10, entrada.getPersona_remite());
            pst.setString(11, entrada.getCiudad());
            pst.setString(12, entrada.getDireccion());
            pst.setString(13, entrada.getNombre_contacto());
            pst.setString(14, entrada.getTelefono_contacto());
            pst.setString(15, entrada.getCorreo());
            pst.setString(16, entrada.getMotivo());
            pst.setString(17, entrada.getParrilla());
            pst.setString(18, entrada.getBases_plasticas());
            pst.setString(19, entrada.getConector_origi());
            pst.setString(20, entrada.getGarantia());
            pst.setString(21, entrada.getEstado_carcasa());
            pst.setString(22, entrada.getObservaciones());
            pst.setString(23, entrada.getTarjeta_red());
            pst.setString(24, entrada.getEstado());
            pst.setInt(25, entrada.getId_cli());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n" + ex.getMessage());
        }
    }

    public void EditarTablaEntrada(Entradas entrada) {
        try {
            //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE entradas SET fecha=?,elemento=?,marca=?,modelo=?,serie=?,empresa=?,nit=?,telefono=?,correo=?,garantia=?,observaciones=?,estado=? WHERE numero = ?");
            pst.setString(1, entrada.getFecha());
            pst.setString(2, entrada.getElemento());
            pst.setString(3, entrada.getMarca());
            pst.setString(4, entrada.getModelo());
            pst.setString(5, entrada.getSerie());
            pst.setString(6, entrada.getEmpresa());
            pst.setString(7, entrada.getNit());
            pst.setString(8, entrada.getTelefono_contacto());
            pst.setString(9, entrada.getCorreo());
            pst.setString(10, entrada.getGarantia());
            pst.setString(11, entrada.getObservaciones());
            pst.setString(12, entrada.getEstado());
            pst.setString(13, entrada.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(listoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n" + ex.getMessage());
        }
    }

    public void EditarEntrada(Entradas entrada) {
        try {
            //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE entradas SET fecha=?,elemento=?,potencia=?,marca=?,modelo=?,serie=?,empresa=?,nit=?,persona_remite=?,ciudad=?,direccion=?,contacto=?,telefono=?,correo=?,motivo=?,parrilla=?,bases_plas=?,conector_ori=?,garantia=?,estado_car=?,observaciones=?,tarjeta=? WHERE numero = ?");
            pst.setString(1, entrada.getFecha());
            pst.setString(2, entrada.getElemento());
            pst.setString(3, entrada.getPotencia());
            pst.setString(4, entrada.getMarca());
            pst.setString(5, entrada.getModelo());
            pst.setString(6, entrada.getSerie());
            pst.setString(7, entrada.getEmpresa());
            pst.setString(8, entrada.getNit());
            pst.setString(9, entrada.getPersona_remite());
            pst.setString(10, entrada.getCiudad());
            pst.setString(11, entrada.getDireccion());
            pst.setString(12, entrada.getNombre_contacto());
            pst.setString(13, entrada.getTelefono_contacto());
            pst.setString(14, entrada.getCorreo());
            pst.setString(15, entrada.getMotivo());
            pst.setString(16, entrada.getParrilla());
            pst.setString(17, entrada.getBases_plasticas());
            pst.setString(18, entrada.getConector_origi());
            pst.setString(19, entrada.getGarantia());
            pst.setString(20, entrada.getEstado_carcasa());
            pst.setString(21, entrada.getObservaciones());
            pst.setString(22, entrada.getTarjeta_red());
            pst.setString(23, entrada.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(listoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n" + ex.getMessage());
        }
    }

    public void EditarClienteEnEntrada(clientes cli) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE clientes SET nit_cli = ?, nombre_cli = ?, telefono_cli = ?, direccion_cli = ?, ciudad_cli = ?, correo_cli = ?, contacto_cli = ? WHERE id_cli = ?");
            pst.setString(1, cli.getNit_cliente());
            pst.setString(2, cli.getNombre_cliente());
            pst.setString(3, cli.getTelefono_cliente());
            pst.setString(4, cli.getDireccion_cliente());
            pst.setString(5, cli.getCiudad_cliente());
            pst.setString(6, cli.getCorreo_cliente());
            pst.setString(7, cli.getNombre_contacto());
            pst.setInt(8, cli.getId_cliente());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(clienteMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n" + ex.getMessage());
        }

    }

    public void EliminarEntrada(Entradas en) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM entradas "
                    + " WHERE numero=?");
            pst.setString(1, en.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(listoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n" + ex.getMessage());
        }
    }

}

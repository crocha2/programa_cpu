/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;

import clasesPrincipales.Entradas;
import clasesPrincipales.Garantias;
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
public class garantiaMySql {

    public ArrayList<Garantias> ListGarantias() {
        ArrayList<Garantias> garantia = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_garantia, fecha_entrada, fecha_garantia, numero, rma, numero_caso, cliente, nit, modelo, serie_vieja, serie_nueva, primera_serie, estado, id_entra FROM garantias WHERE estado = 'PROCESO' ORDER BY fecha_entrada ASC");
            while (rs.next()) {
                Garantias gar = new Garantias();
                gar.setId_garantia(rs.getInt("id_garantia"));
                gar.setFecha_entrada(rs.getString("fecha_entrada"));
                gar.setFecha_garantia(rs.getString("fecha_garantia"));
                gar.setNumero(rs.getString("numero"));
                gar.setRma(rs.getString("rma"));
                gar.setNumero_caso(rs.getString("numero_caso"));
                gar.setCliente(rs.getString("cliente"));
                gar.setNit(rs.getString("nit"));
                gar.setModelo(rs.getString("modelo"));
                gar.setSerie_vieja(rs.getString("serie_vieja"));
                gar.setSerie_nueva(rs.getString("serie_nueva"));
                gar.setPrimera_serie(rs.getString("primera_serie"));
                gar.setEstado(rs.getString("estado"));
                gar.setId_entra(rs.getInt("id_entra"));

                garantia.add(gar);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado:\n" + ex.getMessage());
        }
        return garantia;
    }

    //Codigo para INSERTAR DATOS.........................................................
    public void insertarEntrada_Garantia(Garantias garantia) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            //PreparedStatement pst =  cn.prepareStatement("INSERT INTO garantias(fecha_entrada, cliente, nit, serie_vieja, primera_serie, estado, id_entra) VALUES (?,?,?,?,?,?,?)");
            PreparedStatement pst = cn.prepareStatement("INSERT INTO garantias(fecha_entrada, fecha_garantia, numero, rma, numero_caso, cliente, nit, modelo, serie_vieja, serie_nueva, primera_serie, estado, id_entra) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, garantia.getFecha_entrada());
            pst.setString(2, garantia.getFecha_garantia());
            pst.setString(3, garantia.getNumero());
            pst.setString(4, garantia.getRma());
            pst.setString(5, garantia.getNumero_caso());
            pst.setString(6, garantia.getCliente());
            pst.setString(7, garantia.getNit());
            pst.setString(8, garantia.getModelo());
            pst.setString(9, garantia.getSerie_vieja());
            pst.setString(10, garantia.getSerie_nueva());
            pst.setString(11, garantia.getPrimera_serie());
            pst.setString(12, garantia.getEstado());
            pst.setInt(13, garantia.getId_entra());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar:\n" + ex.getMessage());
        }
    }

    public void EditarEntrada(Entradas entrada) {
        try {
            //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE entradas SET fecha=?,elemento=?,potencia=?,marca=?,modelo=?,serie=?,empresa=?,nit=?,modelo=?,persona_remite=?,ciudad=?,direccion=?,contacto=?,telefono=?,correo=?,motivo=?,parrilla=?,bases_plas=?,conector_ori=?,garantia=?,estado_car=?,observaciones=?,tarjeta=? WHERE numero = ?");
            pst.setString(1, entrada.getFecha());
            pst.setString(2, entrada.getElemento());
            pst.setString(3, entrada.getPotencia());
            pst.setString(4, entrada.getMarca());
            pst.setString(5, entrada.getModelo());
            pst.setString(6, entrada.getSerie());
            pst.setString(7, entrada.getEmpresa());
            pst.setString(8, entrada.getNit());
            pst.setString(9, entrada.getModelo());
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
            pst.setString(24, entrada.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n" + ex.getMessage());
        }
    }

    public void EditarProceso(Garantias garantia) {
        try {
            //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE garantias SET fecha_entrada=?,cliente=?,nit=?,modelo=?,primera_serie=?,serie_vieja=?,estado=? WHERE numero = ?");
            pst.setString(1, garantia.getFecha_entrada());
            pst.setString(2, garantia.getCliente());
            pst.setString(3, garantia.getNit());
            pst.setString(4, garantia.getModelo());
            pst.setString(5, garantia.getPrimera_serie());
            pst.setString(6, garantia.getSerie_vieja());
            pst.setString(7, garantia.getEstado());
            pst.setString(8, garantia.getNumero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al editar:\n" + ex.getMessage());
        }
    }

    public void Asignar(Garantias garantia) {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE garantias SET fecha_garantia=?, rma=?, numero_caso=?, serie_nueva=? WHERE id_entra = ?");
            pst.setString(1, garantia.getFecha_garantia());
            pst.setString(2, garantia.getRma());
            pst.setString(3, garantia.getNumero_caso());
            pst.setString(4, garantia.getSerie_nueva());
            pst.setInt(5, garantia.getId_entra());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizado exitosamente");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al actualizar:\n" + ex.getMessage());
        }
    }

    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void RevisionAProcesoEntrada(Entradas entrada) {
        try {
            //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE entradas SET estado=? WHERE id_entra = ?");
            pst.setString(1, entrada.getEstado());
            pst.setInt(2, entrada.getId_entrada());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Grarantia en proceso");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al pasar a proceso:\n" + ex.getMessage());
        }
    }

    public void RevisionAProcesoGarantia(Garantias garantia) {
        try {
            //(FECHA, ELEMENTO, POTENCIA, MARCA, MODELO, SERIE, EMPRESA, NIT, PERSONA_REMITE, CIUDAD, DIRECCION, NOMBRE_CONTACTO, TELEFONO_CONTACTO, CORREO, MOTIVO, TARJETA_RED, PARRILLA, BASES_PLASTICAS, CONECTOR_ORIGI, GARANTIA, ESTADO_CARCASA, OBSERVACIONES)
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE garantias SET estado=? WHERE id_entra = ?");
            pst.setString(1, garantia.getEstado());
            pst.setInt(2, garantia.getId_entra());
            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Grarantia en proceso");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al pasar a proceso:\n" + ex.getMessage());
        }
    }

    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void estadoEntrada(Entradas entrada) {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE entradas SET estado=? WHERE id_entra = ?");
            pst.setString(1, entrada.getEstado());
            pst.setInt(2, entrada.getId_entrada());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "LISTO");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en LISTO:\n" + ex.getMessage());
        }
    }

    public void estadoGarantia(Garantias garantia) {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE garantias SET estado=? WHERE id_entra = ?");
            pst.setString(1, garantia.getEstado());
            pst.setInt(2, garantia.getId_entra());

            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en LISTO:\n" + ex.getMessage());
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void RechazarEntrada(Entradas entrada) {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE entradas SET estado=? WHERE id_entra = ?");
            pst.setString(1, entrada.getEstado());
            pst.setInt(2, entrada.getId_entrada());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rechazado");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al rechazar:\n" + ex.getMessage());
        }
    }

    public void RechazarGarantia(Garantias garantia) {
        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("UPDATE garantias SET estado=? WHERE id_entra = ?");
            pst.setString(1, garantia.getEstado());
            pst.setInt(2, garantia.getId_entra());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rechazado");
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al rechazar:\n" + ex.getMessage());
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
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
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n" + ex.getMessage());
        }
    }

    public void EliminarGarantia(Garantias gar) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM entradas "
                    + " WHERE id_entra=?");
            pst.setInt(1, gar.getId_entra());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n" + ex.getMessage());
        }
    }
    
    public void EliminarGarantiaBack(Garantias gar) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM garantias "
                    + " WHERE id_entra=?");
            pst.setInt(1, gar.getId_entra());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(garantiaMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar:\n" + ex.getMessage());
        }
    }

}

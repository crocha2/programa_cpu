/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conMySql;

import clasesPrincipales.Entradas;
import clasesPrincipales.clientes;
import clasesPrincipales.cotizaciones;
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
public class cotizaMySql {

    public ArrayList<cotizaciones> ListCotizaciones() {
        ArrayList<cotizaciones> cotizacion = new ArrayList();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_coti, item_coti, fecha_coti, numero, cliente_coti, ciudad_coti, pais_coti, comentario_1, descripcion, valor_unitario, valor_total, fletes, iva, total, firma, validez_oferta, formato_pago, tiempo_entrega,id_cli FROM cotizaciones ORDER BY fecha_coti DESC");
            while (rs.next()) {
                cotizaciones cot = new cotizaciones();
                cot.setId_coti(rs.getInt("id_coti"));
                cot.setItem(rs.getInt("item_coti"));
                cot.setFecha_coti(rs.getString("fecha_coti"));
                cot.setNumero(rs.getString("numero"));
                cot.setCliente_coti(rs.getString("cliente_coti"));
                cot.setCiudad_coti(rs.getString("ciudad_coti"));
                cot.setPais_coti(rs.getString("pais_coti"));   
                cot.setComentario_1(rs.getString("comentario_1"));
                cot.setDescripcion(rs.getString("descripcion"));
                cot.setValor_unitario(rs.getInt("valor_unitario"));
                cot.setValor_total(rs.getInt("valor_total"));
                cot.setFletes(rs.getInt("fletes"));
                cot.setIva(rs.getInt("iva"));
                cot.setTotal(rs.getInt("total"));
                cot.setFirma(rs.getString("firma"));
                cot.setValidez_oferta(rs.getString("validez_oferta"));
                cot.setFormato_pago(rs.getString("forma_pago"));
                cot.setTiempo_entrega(rs.getString("tiempo_entrega"));
                cot.setId_cli(rs.getInt("id_cli"));
                cotizacion.add(cot);
            }
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en listado"+ex.getMessage());
        }
        return cotizacion;
    }

    //Codigo para INSERTAR DATOS.........................................................
    public void insertarCotizacion(cotizaciones cotizacion) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst =  cn.prepareStatement("INSERT INTO entradas(numero, fecha, elemento, potencia, marca, modelo, serie, empresa, nit, persona_remite, ciudad, direccion, contacto, telefono, correo, motivo, parrilla, bases_plas, conector_ori, garantia, estado_car, observaciones, tarjeta, estado, id_cli) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            /*
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
            
            
            
            
            
            cot.setId_coti(rs.getInt("id_coti"));
                cot.setItem(rs.getInt("item_coti"));
                cot.setFecha_coti(rs.getString("fecha_coti"));
                cot.setNumero(rs.getString("numero"));
                cot.setCliente_coti(rs.getString("cliente_coti"));
                cot.setCiudad_coti(rs.getString("ciudad_coti"));
                cot.setPais_coti(rs.getString("pais_coti"));   
                cot.setComentario_1(rs.getString("comentario_1"));
                cot.setDescripcion(rs.getString("descripcion"));
                cot.setValor_unitario(rs.getInt("valor_unitario"));
                cot.setValor_total(rs.getInt("valor_total"));
                cot.setFletes(rs.getInt("fletes"));
                cot.setIva(rs.getInt("iva"));
                cot.setTotal(rs.getInt("total"));
                cot.setFirma(rs.getString("firma"));
                cot.setValidez_oferta(rs.getString("validez_oferta"));
                cot.setFormato_pago(rs.getString("forma_pago"));
                cot.setTiempo_entrega(rs.getString("tiempo_entrega"));
                cot.setId_cli(rs.getInt("id_cli"));
            */
            
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al insertar");
        }
    }
    
    /*
    en.setFecha(txtFecha.getText().toUpperCase());
            en.setElemento(txtElemento.getText().toUpperCase());
            en.setMarca(txtMarca.getText().toUpperCase());
            en.setModelo(txtModelo.getText().toUpperCase());
            en.setSerie(txtSerie.getText().toUpperCase());
            en.setEmpresa(txtEmpresa.getText().toUpperCase());
            en.setNit(txtNitCliente.getText().toUpperCase());
            en.setTelefono_contacto(txtTelefonoCliente.getText().toUpperCase());
            en.setCorreo(txtCorreoCliente.getText().toUpperCase());
            en.setGarantia(txtGarantia.getText().toUpperCase());
            en.setObservaciones(areaObservaciones.getText().toUpperCase());
            en.setId_cli(Integer.parseInt(txtIdCli.getText()));
            */
    
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
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(cotizaMySql.class.getName()).log(Level.SEVERE, null, ex);
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
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(cotizaMySql.class.getName()).log(Level.SEVERE, null, ex);
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
        }

    }
    
    public void EliminarEntrada(Entradas en) {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("DELETE FROM entradas "
                    + " WHERE numero=?");
            pst.setString(1, en.getNumero());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(cotizaMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

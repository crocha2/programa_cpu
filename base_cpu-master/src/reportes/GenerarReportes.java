/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import conMySql.conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CPU_SYS
 */
public class GenerarReportes {

    public void reporteSalida(String nume) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("salida.jasper");
            Map parametro = new HashMap();

            parametro.put("log", this.getClass().getResourceAsStream("/imagenes/cpu.png"));
            parametro.put("log2", this.getClass().getResourceAsStream("/imagenes/cpu.png"));
            parametro.put("nume", nume);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE SALIDA");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportePrestamo(String nume) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("salida_1.jasper");
            Map parametro = new HashMap();

            parametro.put("log", this.getClass().getResourceAsStream("/imagenes/cpu.png"));
            parametro.put("log2", this.getClass().getResourceAsStream("/imagenes/cpu.png"));
            parametro.put("nume", nume);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE SALIDA");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteEntrada(String nume) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("entrada.jasper");
            Map parametro = new HashMap();

            parametro.put("log", this.getClass().getResourceAsStream("/imagenes/cpu.png"));
            parametro.put("log2", this.getClass().getResourceAsStream("/imagenes/cpu.png"));
            parametro.put("nume", nume);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE ENTRADA");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteEnvio(String nume) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("envio.jasper");
            Map parametro = new HashMap();

            parametro.put("cpu", this.getClass().getResourceAsStream("/imagenes/Bienvenido.png"));
            parametro.put("fondo", this.getClass().getResourceAsStream("/imagenes/fondo.png"));
            parametro.put("data", this.getClass().getResourceAsStream("/imagenes/data.png"));
            parametro.put("apc", this.getClass().getResourceAsStream("/imagenes/apc.png"));
            parametro.put("nume", nume);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE ENVIO");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteGarantia(String txtFe1, String txtFe2) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("garantias.jasper");
            Map parametro = new HashMap();

            parametro.put("logo", this.getClass().getResourceAsStream("/imagenes/cpu_med.png"));
            parametro.put("fe1", txtFe1);
            parametro.put("fe2", txtFe2);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE GARANTIAS");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteIMAGEN(int id) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("imagen.jasper");
            Map parametro = new HashMap();

            //HAY QUE TRAER LA IMAGEN Y SU LONGITUD...
            //parametro.put("image", this.getClass().getTypeParameters());
            parametro.put("id_imagen", id);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reporteIMAGEN_SALIDA(int id) {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://69.73.129.251:3306/cpusysc1_cpudb", "cpusysc1_root", "c8020123496");
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject("imagen_salida.jasper");
            Map parametro = new HashMap();

            //HAY QUE TRAER LA IMAGEN Y SU LONGITUD...
            //parametro.put("image", this.getClass().getTypeParameters());
            parametro.put("id_salid", id);

            JasperPrint j;
            
            j = JasperFillManager.fillReport(reporte, parametro, cn);
            System.out.println("conectado correctamente");

            JasperViewer jv = new JasperViewer(j, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
            //jv.show();
            cn.close();
        } catch (JRException e) {
            System.out.println("Error: \n" + e);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

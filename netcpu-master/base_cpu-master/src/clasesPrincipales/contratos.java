/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesPrincipales;

/**
 *
 * @author JR
 */
public class contratos {

    int id_contrato;
    String numero;
    String fecha_inicio;
    String fecha_fin;
    String cliente;
    String nit_ced;
    String Responsable;
    
    public contratos() {
    }

    public contratos(int id_contrato, String numero, String fecha_inicio, String fecha_fin, String cliente, String nit_ced, String Responsable) {
        this.id_contrato = id_contrato;
        this.numero = numero;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cliente = cliente;
        this.nit_ced = nit_ced;
        this.Responsable = Responsable;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNit_ced() {
        return nit_ced;
    }

    public void setNit_ced(String nit_ced) {
        this.nit_ced = nit_ced;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }
    
    

    
    
}

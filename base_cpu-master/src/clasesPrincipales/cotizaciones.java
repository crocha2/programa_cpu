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
public class cotizaciones {
    
    int id_coti;
    int item;
    String fecha_coti;
    String numero;
    String cliente_coti;
    String ciudad_coti;
    String pais_coti;
    String comentario_1;
    String descripcion;
    int valor_unitario;
    int valor_total;
    int fletes;
    int iva;
    int total;
    String firma;
    String validez_oferta;
    String formato_pago;
    String tiempo_entrega;
    int id_cli;

    public cotizaciones() {
    }

    public cotizaciones(int id_coti, int item, String fecha_coti, String numero, String cliente_coti, String ciudad_coti, String pais_coti, String comentario_1, String descripcion, int valor_unitario, int valor_total, int fletes, int iva, int total, String firma, String validez_oferta, String formato_pago, String tiempo_entrega, int id_cli) {
        this.id_coti = id_coti;
        this.item = item;
        this.fecha_coti = fecha_coti;
        this.numero = numero;
        this.cliente_coti = cliente_coti;
        this.ciudad_coti = ciudad_coti;
        this.pais_coti = pais_coti;
        this.comentario_1 = comentario_1;
        this.descripcion = descripcion;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.fletes = fletes;
        this.iva = iva;
        this.total = total;
        this.firma = firma;
        this.validez_oferta = validez_oferta;
        this.formato_pago = formato_pago;
        this.tiempo_entrega = tiempo_entrega;
        this.id_cli = id_cli;
    }

    public int getId_coti() {
        return id_coti;
    }

    public void setId_coti(int id_coti) {
        this.id_coti = id_coti;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getFecha_coti() {
        return fecha_coti;
    }

    public void setFecha_coti(String fecha_coti) {
        this.fecha_coti = fecha_coti;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente_coti() {
        return cliente_coti;
    }

    public void setCliente_coti(String cliente_coti) {
        this.cliente_coti = cliente_coti;
    }

    public String getCiudad_coti() {
        return ciudad_coti;
    }

    public void setCiudad_coti(String ciudad_coti) {
        this.ciudad_coti = ciudad_coti;
    }

    public String getPais_coti() {
        return pais_coti;
    }

    public void setPais_coti(String pais_coti) {
        this.pais_coti = pais_coti;
    }

    public String getComentario_1() {
        return comentario_1;
    }

    public void setComentario_1(String comentario_1) {
        this.comentario_1 = comentario_1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(int valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public int getFletes() {
        return fletes;
    }

    public void setFletes(int fletes) {
        this.fletes = fletes;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getValidez_oferta() {
        return validez_oferta;
    }

    public void setValidez_oferta(String validez_oferta) {
        this.validez_oferta = validez_oferta;
    }

    public String getFormato_pago() {
        return formato_pago;
    }

    public void setFormato_pago(String formato_pago) {
        this.formato_pago = formato_pago;
    }

    public String getTiempo_entrega() {
        return tiempo_entrega;
    }

    public void setTiempo_entrega(String tiempo_entrega) {
        this.tiempo_entrega = tiempo_entrega;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    
    
}

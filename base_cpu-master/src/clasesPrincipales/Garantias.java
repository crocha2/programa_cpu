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
public class Garantias {
    
    int id_garantia;
    String fecha_entrada;
    String fecha_garantia;
    String numero;
    String rma;
    String numero_caso;
    String cliente;
    String nit;
    String modelo;
    String serie_vieja;
    String serie_nueva;
    String primera_serie;
    String estado;
    int id_entra;

    public Garantias() {
    }

    public Garantias(int id_garantia, String fecha_entrada, String fecha_garantia, String numero, String rma, String numero_caso, String cliente, String nit, String modelo, String serie_vieja, String serie_nueva, String primera_serie, String estado, int id_entra) {
        this.id_garantia = id_garantia;
        this.fecha_entrada = fecha_entrada;
        this.fecha_garantia = fecha_garantia;
        this.numero = numero;
        this.rma = rma;
        this.numero_caso = numero_caso;
        this.cliente = cliente;
        this.nit = nit;
        this.modelo = modelo;
        this.serie_vieja = serie_vieja;
        this.serie_nueva = serie_nueva;
        this.primera_serie = primera_serie;
        this.estado = estado;
        this.id_entra = id_entra;
    }
    
    public Garantias(int id_garantia, String fecha_entrada, String cliente, String nit, String modelo, String serie_vieja, String primera_serie, String estado, int id_entra) {
        this.id_garantia = id_garantia;
        this.fecha_entrada = fecha_entrada;
        this.cliente = cliente;
        this.nit = nit;
        this.modelo = modelo;
        this.serie_vieja = serie_vieja;
        this.primera_serie = primera_serie;
        this.estado = estado;
        this.id_entra = id_entra;
    }

    public int getId_garantia() {
        return id_garantia;
    }

    public void setId_garantia(int id_garantia) {
        this.id_garantia = id_garantia;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_garantia() {
        return fecha_garantia;
    }

    public void setFecha_garantia(String fecha_garantia) {
        this.fecha_garantia = fecha_garantia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRma() {
        return rma;
    }

    public void setRma(String rma) {
        this.rma = rma;
    }

    public String getNumero_caso() {
        return numero_caso;
    }

    public void setNumero_caso(String numero_caso) {
        this.numero_caso = numero_caso;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie_vieja() {
        return serie_vieja;
    }

    public void setSerie_vieja(String serie_vieja) {
        this.serie_vieja = serie_vieja;
    }

    public String getSerie_nueva() {
        return serie_nueva;
    }

    public void setSerie_nueva(String serie_nueva) {
        this.serie_nueva = serie_nueva;
    }

    public String getPrimera_serie() {
        return primera_serie;
    }

    public void setPrimera_serie(String primera_serie) {
        this.primera_serie = primera_serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_entra() {
        return id_entra;
    }

    public void setId_entra(int id_entra) {
        this.id_entra = id_entra;
    }
    
    
    
    
}

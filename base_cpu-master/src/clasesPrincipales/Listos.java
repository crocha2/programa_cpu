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
public class Listos {
    
    int id_entra;
    String numero;
    String fecha_entrada;
    String fecha_garantia;
    String cliente;
    String nit;
    String ciudad;
    String garantia;
    String elemento;
    String marca;
    String modelo;
    String serie_vieja;
    String serie_nueva;
    String numero_caso;
    String rma;
    String primera_serie;
    String observacion;
    String estado;
    int id_cli;

    public Listos() {
    }
    
    public Listos(int id_entra, String numero, String fecha_entrada, String fecha_garantia, String cliente, String nit, String ciudad, String garantia, String elemento, String marca, String modelo, String serie_vieja, String serie_nueva, String numero_caso, String rma, String primera_serie, String observacion, String estado, int id_cli) {
        this.id_entra = id_entra;
        this.numero = numero;
        this.fecha_entrada = fecha_entrada;
        this.fecha_garantia = fecha_garantia;
        this.cliente = cliente;
        this.nit = nit;
        this.ciudad = ciudad;
        this.garantia = garantia;
        this.elemento = elemento;
        this.marca = marca;
        this.modelo = modelo;
        this.serie_vieja = serie_vieja;
        this.serie_nueva = serie_nueva;
        this.numero_caso = numero_caso;
        this.rma = rma;
        this.primera_serie = primera_serie;
        this.observacion = observacion;
        this.estado = estado;
        this.id_cli = id_cli;
    }

    public int getId_entra() {
        return id_entra;
    }

    public void setId_entra(int id_entra) {
        this.id_entra = id_entra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public String getNumero_caso() {
        return numero_caso;
    }

    public void setNumero_caso(String numero_caso) {
        this.numero_caso = numero_caso;
    }

    public String getRma() {
        return rma;
    }

    public void setRma(String rma) {
        this.rma = rma;
    }

    public String getPrimera_serie() {
        return primera_serie;
    }

    public void setPrimera_serie(String primera_serie) {
        this.primera_serie = primera_serie;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesPrincipales;

/**
 *
 * @author CPU_SYS
 */
public class Salidas {
    
    int id_salida;
    String numero;
    String fecha;
    String empresa;
    String ciudad;
    String direccion;
    String contacto;
    String telefono;
    String correo;
    String equipo;
    String modelo;
    String serie;
    String comentario;
    String prestamo;
    int id_cli;
    

    public Salidas() {
    }

    public Salidas(int id_salida, String numero, String fecha, String empresa, String ciudad, String direccion, String contacto, String telefono, String correo, String equipo, String modelo, String serie, String comentario, String prestamo, int id_cli) {
        this.id_salida = id_salida;
        this.fecha = fecha;
        this.empresa = empresa;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.equipo = equipo;
        this.modelo = modelo;
        this.serie = serie;
        this.comentario = comentario;
        this.numero = numero;
        this.prestamo = prestamo;
        this.id_cli = id_cli;
    }

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }
    
    
    
}

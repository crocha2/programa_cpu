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
public class Envios {
    int id_envio;
    String fecha;
    String destinatario;
    String ATN;
    String direccion;
    String telefono;
    String ciudad;
    String comentario;
    String numero;
    int id_cli;
    
public Envios(int id_envio, String numero, String fecha, String destinatario, String ATN, String direccion, String telefono, String ciudad, String comentario, int id_cli) {
        this.id_envio = id_envio;
        this.fecha = fecha;
        this.destinatario = destinatario;
        this.ATN = ATN;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.comentario = comentario;
        this.numero = numero;
        this.id_cli = id_cli;
    }

    public Envios() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getATN() {
        return ATN;
    }

    public void setATN(String ATN) {
        this.ATN = ATN;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }
    
    

}

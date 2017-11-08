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
public class clientes {
    
    int id_cliente;
    String nit_cliente;
    String nombre_cliente;
    String telefono_cliente;
    String direccion_cliente;
    String ciudad_cliente;
    String correo_cliente;
    String nombre_contacto;

    public clientes() {
    }

    public clientes(int id_cliente, String nit_cliente, String nombre_cliente, String telefono_cliente, String direccion_cliente, String ciudad_cliente, String correo_cliente, String nombre_contacto) {
        this.id_cliente = id_cliente;
        this.nit_cliente = nit_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
        this.direccion_cliente = direccion_cliente;
        this.ciudad_cliente = ciudad_cliente;
        this.correo_cliente = correo_cliente;
        this.nombre_contacto = nombre_contacto;
    }

     public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getCiudad_cliente() {
        return ciudad_cliente;
    }

    public void setCiudad_cliente(String ciudad_cliente) {
        this.ciudad_cliente = ciudad_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    
    
}

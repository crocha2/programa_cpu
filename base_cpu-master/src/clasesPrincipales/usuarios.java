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
public class usuarios {
    
    int id_usuario;
    String nombre;
    String password;
    int tipoUsuario;

    public usuarios() {
    }
    
    
    public usuarios(int id_usuario, String nombre, String password, int tipoUsuario) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesPrincipales;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author JR
 */
public class imagen_salida {
    
    
    FileInputStream imagen;
    int longitud;
    int id_salida;

    public imagen_salida() {
    }

    public imagen_salida(FileInputStream imagen, int longitud, int id_salida) {
        this.imagen = imagen;
        this.longitud = longitud;
        this.id_salida = id_salida;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
    }

    
    
}

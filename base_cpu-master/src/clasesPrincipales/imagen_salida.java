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
    
    int id_imagen;
    String numero;
    FileInputStream imagen;
    int longitud;
    int id_salida;

    public imagen_salida() {
    }

    public imagen_salida(int id_imagen, String numero, FileInputStream imagen, int longitud, int id_salida) {
        this.id_imagen = id_imagen;
        this.numero = numero;
        this.imagen = imagen;
        this.longitud = longitud;
        this.id_salida = id_salida;
    }

    public imagen_salida(String numero, FileInputStream imagen, int longitud, int id_salida) {
        this.numero = numero;
        this.imagen = imagen;
        this.longitud = longitud;
        this.id_salida = id_salida;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

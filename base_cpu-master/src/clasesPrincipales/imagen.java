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
public class imagen {
    
    int id_imagen;
    String numero;
    FileInputStream imagen;
    int longitud;
    int id_entra;
    int id_salida;

    public imagen(int id_imagen, FileInputStream imagen, int longitud) {
        this.id_imagen = id_imagen;
        this.imagen = imagen;
        this.longitud = longitud;
    }
    
    public imagen(FileInputStream imagen, int longitud) {
        this.imagen = imagen;
        this.longitud = longitud;
    }

    public imagen(String numero, FileInputStream imagen, int longitud, int id_entra) {
        this.numero = numero;
        this.imagen = imagen;
        this.longitud = longitud;
        this.id_entra = id_entra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId_entra() {
        return id_entra;
    }

    public void setId_entra(int id_entra) {
        this.id_entra = id_entra;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public imagen() {
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }



    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }
    
    
    
}

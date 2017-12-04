/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daniel
 */
public class Marcador {
    
    private String idMarcadores,Nombre,Latitud,Longitud;

    
    public Marcador() {

    }

    public Marcador(String idMarcadores ,String Nombre, String Latitud, String Longitud){
        this.idMarcadores = idMarcadores;
        this.Nombre=Nombre;
        this.Latitud=Latitud;
        this.Longitud=Longitud;
        
    }
    
    public String getIdMarcadores() {
        return idMarcadores;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getLatitud() {
        return Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }
    
      public void setIdMarcadores(String idMarcadores) {
        this.idMarcadores = idMarcadores;
    }
 
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }

}
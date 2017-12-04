/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Diego
 */
public class Participante {
    
    private String idMatricula,nombre,apellidoP,apellidoM,correo,edad,genero,telefono,nivelEstudio,proyecto;
   

    
    public Participante() {

}

    public Participante(String idMatricula, String nombre, String apellidoP,String apellidoM,String correo,String edad,String genero,String telefono,String nivelEstudio,String proyecto){
    
        this.idMatricula=idMatricula;
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.correo=correo;
        this.edad=edad;
        this.genero=genero;
        this.telefono=telefono;
        this.nivelEstudio=nivelEstudio;
        this.proyecto=proyecto;
    }
    public String getidMatricula() {
        return idMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }
    
    public String getProyecto(){
        return proyecto;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }
    
    public void setProyecto(String proyecto){
    
        this.proyecto = proyecto;
    }

    
    
}
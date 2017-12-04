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
public class Comentario {
    
    private String nombre,email,tema,asunto,comentario;


public Comentario() {

}

public Comentario(String nombre, String email, String tema,String asunto,String comentario){
    
        this.nombre=nombre;
        this.email=email;
        this.tema=tema;
        this.asunto=asunto;
        this.comentario=comentario;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTema() {
        return tema;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}


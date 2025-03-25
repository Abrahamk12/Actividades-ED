package com.mycompany.actividadesed;
public class Persona {
    private String nombres, apellidos;
    private int edad;
    public Persona(){}
    public Persona(String nombres){ 
        this.nombres = nombres; 
    }
    public Persona(String nombres, String apellidos, int edad){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    public void setPersona(String nombres, String apellidos, int edad){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    public String getNombres(){
        return this.nombres;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public int getEdad(){
        return this.edad;
    }
    @Override
    public String toString() { // Sobrescribir toString para imprimir fácilmente
        return this.nombres + " " + this.apellidos + ", edad:" + this.edad;
    }
}

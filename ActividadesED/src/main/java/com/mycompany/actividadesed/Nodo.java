package com.mycompany.actividadesed;
import java.util.ArrayList;
import java.util.List;
public class Nodo {
    Persona persona;
    List<Nodo> hijos;

    public Nodo(){ this.hijos = new ArrayList<>(); }
    
    public Nodo(Persona persona) {
        this.persona = persona;
        this.hijos = new ArrayList<>();
    }

    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }
}

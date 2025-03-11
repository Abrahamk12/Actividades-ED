package com.mycompany.actividadesed;
public class ActividadesED {
    public static void main(String[] args) {
        Persona personas [] = new Persona[3];
        Nodo raiz = new Nodo(new Persona("Raiz"));
        Nodo hijos [] = new Nodo[3];
        personas[0] = new Persona("Juan Peres", "Patata Potatos",15);
        personas[1] = new Persona("Tomate Jitomate", "Vegeteal",10);
        personas[2] = new Persona("Rrez Costillas", "Carnes",20);
        
        // Crear nodos para cada persona y agregarlos como hijos
        for (int i = 0; i < personas.length; i++) {
            hijos[i] = new Nodo(personas[i]); // Crear nodo para cada Persona
            raiz.agregarHijo(hijos[i]);      // Agregar el nodo como hijo de la raíz
        }
        imprimirArbol(raiz, "");
    }
    public static void imprimirArbol(Nodo nodo, String prefijo) {
        System.out.println(prefijo + nodo.persona.toString());
        for (Nodo hijo : nodo.hijos) {
            imprimirArbol(hijo, prefijo + "  ");
        }
    }
}

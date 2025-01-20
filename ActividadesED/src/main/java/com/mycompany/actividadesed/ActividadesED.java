package com.mycompany.actividadesed;
import java.util.HashSet;
import java.util.Set;
public class ActividadesED {
    public static void main(String[] args) {
        Set<String> palabras = new HashSet<>();
        palabras.add("Prueba1");
        palabras.add("Manzana");
        
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
        
        palabras.forEach(palabra -> System.out.println(palabra));
    }
}

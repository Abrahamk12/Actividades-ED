package com.mycompany.actividadesed;

import java.util.Scanner;

public class ActividadesED {
    public static void main(String[] args) {
        /*
        Operaciones op = new Operaciones();
        op.setDimension(2);
        op.setDatosArreglo(5, 1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int numero = sc.nextInt();
        System.out.println("Ingrese un texto");
        String t = sc.nextLine();
        System.out.println(numero + "\nTexto: " + t);
        */
        imprimirNumeros(0, 15);
    }
    
    public static void imprimirNumeros(int inicio, int fin){
        if(inicio <= fin){
            System.out.println(inicio);
            imprimirNumeros(inicio + 1, fin);
        }
    }
}

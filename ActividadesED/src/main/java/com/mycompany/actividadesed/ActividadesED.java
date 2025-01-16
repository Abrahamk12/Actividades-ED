/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividadesed;

/**
 *
 * @author super
 */
public class ActividadesED {

    public static void main(String[] args) {
        int [] numeros = {4, 7, 3, 10, 1, 15, 2};
        int [] numeros2 = new int[7];
        int mayor = 0, indice = 0;
        for (int i = 0; i < 7; i++) {
            //System.out.println("El valor de i = " + i +"\n");
            for (int j = 0; j < 7; j++) {
                 //System.out.println("El valor de j = " + j +"\n");
                if (mayor < numeros[j]) {
                    mayor = numeros[j];
                    indice = j;
                    //System.out.println("El valor de j en el if= "+j+"\nMayor = "+mayor);
                }
            }
            numeros[indice] = 0;
            numeros2[i] = mayor;
            System.out.println(numeros2[i]);
        }
    }
}

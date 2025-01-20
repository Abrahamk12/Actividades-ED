package com.mycompany.actividadesed;

public class Operaciones {
    int numero1, numero2;
    double numero1d, numero2d;
    int enteros [];
    public Operaciones(){
        
    }
    public void setDimension(int tamaño){
        enteros = new int[tamaño];
    }
    public void setDatosArreglo(int dato, int posicion){
        this.enteros[posicion] = dato;
    }
    public void setNumerosE1(int numero){
        this.numero1 = numero;
    }
    public void setNumeroD1(double numero){
        this.numero1d = numero;
    }
    
    public int getNumero1(){
        return this.numero1;
    }
    
    public int getDatoArreglo(int posicion){
        return this.enteros[posicion];
    }
}

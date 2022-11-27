/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Valeria
 */
public class Pila {
    
    private NodoPila tope;
    
    public Pila(){
        tope = null;
    }
    
    public void Insertar(NodoArbol elemento){
        NodoPila nuevo;
        nuevo = new NodoPila(elemento);
        nuevo.siguiente = tope;
        tope = nuevo;
    }
    
    public boolean PilaVacia(){
        return tope == null;
    }
    
    public NodoArbol TopePila(){
        return tope.dato;
    }
    
    public void ReiniciarPila(){
        tope = null;
    }
    
    public NodoArbol Quitar(){
        NodoArbol aux = null;
        if(!PilaVacia()){
            aux = tope.dato;
            tope = tope.siguiente;
        }
        return aux;  
    }
}

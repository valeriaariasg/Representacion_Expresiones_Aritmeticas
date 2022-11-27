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
    
    private NodoPila cima;
    
    public Pila(){
        cima = null;
    }
    
    public void Insertar(NodoArbol elemento){
        NodoPila nuevo;
        nuevo = new NodoPila(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    
    public boolean PilaVacia(){
        return cima == null;
    }
    
    public NodoArbol CimaPila(){
        return cima.dato;
    }
    
    public void ReiniciarPila(){
        cima = null;
    }
    
    public NodoArbol Quitar(){
        NodoArbol aux = null;
        if(!PilaVacia()){
            aux = cima.dato;
            cima = cima.siguiente;
        }
        return aux;  
    }
}

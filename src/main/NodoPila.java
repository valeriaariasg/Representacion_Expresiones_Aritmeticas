/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Crea el nodo de una pila
 * @author Valeria Arias, Jesus Perez
 */
public class NodoPila {
    
    NodoArbol dato;
    NodoPila siguiente;
    
    /**
    * Crea un nodo para la pila, clase constructor
    * @param x El nodo que se desa crear
    * @author Valeria Arias, Jesus Perez
    */
    public NodoPila(NodoArbol x){
        dato = x;
        siguiente = null;
    }
}

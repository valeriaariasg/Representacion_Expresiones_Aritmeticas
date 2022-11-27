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
public class NodoPila {
    
    NodoArbol dato;
    NodoPila siguiente;
    
    public NodoPila(NodoArbol x){
        dato = x;
        siguiente = null;
    }
}

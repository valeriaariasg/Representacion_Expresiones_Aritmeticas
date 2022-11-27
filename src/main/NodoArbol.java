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
public class NodoArbol {
    
    Object dato;
    NodoArbol izquierdo;
    NodoArbol derecho;
    
    public NodoArbol(Object x){
        dato = x;
        izquierdo = null;
        derecho = null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Crea la pila y sus primitivas
 * @author Valeria Arias, Jesus Perez
 */
public class Pila {
    
    private NodoPila cima;
    
    /**
    * Crea la pila, clase constructor
    * @author Valeria Arias, Jesus Perez
    */
    public Pila(){
        cima = null;
    }
    
    /**
    * Inserta un nodo en la pila
    * @param elemento el nodo que se desea insertar
    * @author Valeria Arias, Jesus Perez
    */
    public void Insertar(NodoArbol elemento){
        NodoPila nuevo;
        nuevo = new NodoPila(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    
    /**
    * Verifica si la pila esta vacia
    * @return retorna un bool
    * @author Valeria Arias, Jesus Perez
    */
    public boolean PilaVacia(){
        return cima == null;
    }
    
    /**
    * Devuelve la cima de la pila
    * @return retorna un dato de tipo NodoArbol
    * @author Valeria Arias, Jesus Perez
    */
    public NodoArbol CimaPila(){
        return cima.dato;
    }
    
    /**
    * Reinicia la pila
    * @author Valeria Arias, Jesus Perez
    */
    public void ReiniciarPila(){
        cima = null;
    }
    
    /**
    * Quita un nodo de la pila
    * @return retorna un dato de tipo NodoArbol
    * @author Valeria Arias, Jesus Perez
    */
    public NodoArbol Quitar(){
        NodoArbol aux = null;
        if(!PilaVacia()){
            aux = cima.dato;
            cima = cima.siguiente;
        }
        return aux;  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.lang.model.SourceVersion;

/**
 * Crea el nodo de un arbol
 * @author Valeria Arias, Jesus Perez
 */
public class NodoArbol {
    
    Object dato;
    NodoArbol izquierdo;
    NodoArbol derecho;
    
    /**
    * Crea un nodo para el arbol, clase constructor
    * @param x El nodo que se desa crear
    * @author Valeria Arias, Jesus Perez
    */
    public NodoArbol(Object x){
        dato = x;
        izquierdo = null;
        derecho = null;
    }
    
    /**
    * Los nodos del arbol
    * @param n El nodo del arbol
    * @author Valeria Arias, Jesus Perez
    */
    public int nodosCompletos(NodoArbol n) {
        if (n == null)
            return 0;
        else {
            if (n.izquierdo!= null && n.derecho != null)
                return nodosCompletos(n.izquierdo) + nodosCompletos(n.derecho) + 1;
            return nodosCompletos(n.izquierdo) + nodosCompletos(n.derecho);
        }
    }
    
    /**
    * Para obtener la ultima version de la fuente
    * @return return un dato de tipo SourceVersion
    * @author Valeria Arias, Jesus Perez
    */
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}

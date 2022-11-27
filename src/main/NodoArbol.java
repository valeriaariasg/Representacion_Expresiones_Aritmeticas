/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.lang.model.SourceVersion;

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
    
    public int nodosCompletos(NodoArbol n) {
        if (n == null)
            return 0;
        else {
            if (n.izquierdo!= null && n.derecho != null)
                return nodosCompletos(n.izquierdo) + nodosCompletos(n.derecho) + 1;
            return nodosCompletos(n.izquierdo) + nodosCompletos(n.derecho);
        }
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}

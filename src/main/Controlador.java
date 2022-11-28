/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


/**
 * Crea la vista y el modelo del lienzo
 * @author Valeria Arias, Jesus Perez
 */
public class Controlador {
    private Lienzo objLienzo; //VISTA
    private ArbolBinario objArbol; //MODELO

    /**
    * Crea el controlador
    * @param objLienzo un objeto del lienzo
    * @param objArbol un objeto del arbol binario
    * @author Valeria Arias, Jesus Perez
    */
    public Controlador(Lienzo objLienzo, ArbolBinario objArbol) {
        this.objLienzo = objLienzo;
        this.objArbol = objArbol;
    }
    
    /**
    * Inicializa el lienzo y la representacion grafica del arbol en la interfaz grafica
    * @author Valeria Arias, Jesus Perez
    */
    public void iniciar() {
        objLienzo.setObjArbol(objArbol);
    }
}

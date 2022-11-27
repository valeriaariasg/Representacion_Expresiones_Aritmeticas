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
public class Controlador {
    private Lienzo objLienzo; //VISTA
    private ArbolBinario objArbol; //MODELO

    public Controlador(Lienzo objLienzo, ArbolBinario objArbol) {
        this.objLienzo = objLienzo;
        this.objArbol = objArbol;
    }
    
    public void iniciar() {
        objLienzo.setObjArbol(objArbol);
    }
}

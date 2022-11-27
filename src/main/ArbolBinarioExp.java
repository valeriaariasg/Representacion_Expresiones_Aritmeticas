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
public class ArbolBinarioExp {
    
    NodoArbol raiz;
    
    /**
     *
     */
    public ArbolBinarioExp(){
        raiz = null;
    }
    
    /**
     *
     * @param cadena
     */
    public ArbolBinarioExp(String cadena){
        raiz = CrearArbolBE(cadena);
        
    }
    
    /**
     *
     */
    public void ReiniciaArbol(){
        raiz = null;
    }
    
    /**
     *
     * @param dato
     */
    public void CrearNodo(Object dato){
        raiz = new NodoArbol(dato);
    }
    
    /**
     *
     * @param dato2
     * @param dato1
     * @param operador
     * @return
     */
    public NodoArbol CreaSubArbol(NodoArbol dato2, NodoArbol dato1, NodoArbol operador){
        operador.izquierdo = dato1;
        operador.derecho = dato2;
        return operador;
    }
    
    /**
     *
     * @return
     */
    public boolean ArbolVacio(){
        return raiz == null;
    }
    
    /**
     *
     * @param subArbol
     * @param c
     * @return
     */
    public String PreOrden(NodoArbol subArbol, String c){
        String cadena;
        cadena = "";
        if(subArbol != null){
           cadena = c + subArbol.dato.toString()+"\n"+PreOrden(subArbol.izquierdo, c)+ PreOrden(subArbol.derecho, c);
        }
        return cadena;
    }
    
    /**
     *
     * @param subArbol
     * @param c
     * @return
     */
    public String InOrden(NodoArbol subArbol, String c){
        String cadena;
        cadena = "";
         if(subArbol != null){
           cadena = c + InOrden(subArbol.izquierdo, c)+ subArbol.dato.toString()+"\n"+InOrden(subArbol.derecho,c);
        }
        return cadena;
    }
    
    /**
     *
     * @param subArbol
     * @param c
     * @return
     */
    public String PosOrden(NodoArbol subArbol, String c){
        String cadena;
        cadena = "";
         if(subArbol != null){
           cadena = c + PosOrden(subArbol.izquierdo, c)+ PosOrden(subArbol.derecho,c) + subArbol.dato.toString()+"\n";
        }
        return cadena;
    }
    
    /**
     *
     * @param a
     * @return
     */
    public String Imprimir(int a){
        String cadena = "";
        switch(a){
            case 0: 
                cadena = PreOrden(raiz, cadena);
                break;
            case 1:
                cadena = InOrden(raiz, cadena);
                break;
            case 2: 
                cadena = PosOrden(raiz, cadena);
                break;
        }
        return cadena;
    }
    
    private int Prioridad(char c){
        int p = 100;
        switch(c){
            case '^':
                p = 30;
                break;
            case '*':
                p = 20;
                break;
            case '/':
                p = 20;
                break;
            case '+':
            case '-':
                p = 10;
                break;
            default:
                p = 0;
        }
        return p;
    } 
    
    private boolean EsOperador(char c){
        boolean resultado;
        switch(c){
            case '(':
            case ')':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                resultado = true;
                break;
            default:
                resultado = false;
        }
        return resultado;
    }
    
    private NodoArbol CrearArbolBE(String cadena){
        
        PilaArbolExp PilaOperadores;
        PilaArbolExp PilaExpresiones;
        
        NodoArbol token;
        NodoArbol op1;
        NodoArbol op2;
        NodoArbol op;
        
        PilaOperadores = new PilaArbolExp();
        PilaExpresiones = new PilaArbolExp();
        
        char caracterEvaluado;
        for(int i = 0; i < cadena.length(); i++){
            caracterEvaluado = cadena.charAt(i);
            token = new NodoArbol(caracterEvaluado);
            if(!EsOperador(caracterEvaluado)){
                PilaExpresiones.Insertar(token);
            }
            else{
                switch(caracterEvaluado){
                    case '(':
                        PilaOperadores.Insertar(token);
                        break;
                    case ')':
                        while(!PilaOperadores.PilaVacia() && !PilaOperadores.TopePila().dato.equals('(')){
                            op2 = PilaExpresiones.Quitar();
                            op1 = PilaExpresiones.Quitar();
                            op = PilaOperadores.Quitar();
                            op = CreaSubArbol(op2, op1, op);
                            PilaExpresiones.Insertar(op);
                        }
                        PilaOperadores.Quitar();
                        break;
                    default:
                        while(!PilaOperadores.PilaVacia() && Prioridad(caracterEvaluado)<= (PilaOperadores.TopePila().dato.toString().charAt(0))){
                            op2 = PilaExpresiones.Quitar();
                            op1 = PilaExpresiones.Quitar();
                            op = PilaOperadores.Quitar();
                            op = CreaSubArbol(op2, op1, op);
                            PilaExpresiones.Insertar(op);
                        }
                        PilaOperadores.Insertar(token);
                }
            }
            
        }
        while(!PilaOperadores.PilaVacia()){
            op2 = PilaExpresiones.Quitar();
            op1 = PilaExpresiones.Quitar();
            op = PilaOperadores.Quitar();
            op = CreaSubArbol(op2, op1, op);
            PilaExpresiones.Insertar(op);
        }
        op = PilaExpresiones.Quitar();
        return op;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Crea el arbol binario y sus primitivas
 * @author Valeria Arias, Jesus Perez
 */
public class ArbolBinario {
    
    NodoArbol raiz;
    
    /**
     * Crea el arbol binario, clase constructor
     * @author Valeria Arias, Jesus Perez
     * Crea el arbol con la raiz apuntando a null
     */
    public ArbolBinario(){
        raiz = null;
    }
    
    /**
     * Crea la raiz del arbol
     * @param cadena El str que se usara para crear la raiz y el arbol
     * @author Valeria Arias, Jesus Perez
     */
    public ArbolBinario(String cadena){
        raiz = CrearABE(cadena);
        
    }
    
    /**
     * Reinicia el arbol
     * @author Valeria Arias, Jesus Perez
     */
    public void ReiniciaArbol(){
        raiz = null;
    }
    
    /**
     * Crea un nodo
     * @param dato el dato del nodo
     * @author Valeria Arias, Jesus Perez
     */
    public void Nodo(Object dato){
        raiz = new NodoArbol(dato);
    }
    
    /**
     * Los sub-arboles del arbol binario
     * @param dato2 El operdaor derecho
     * @param dato1 El operador izquierdo
     * @param operador Lo que se va a retornar
     * @return Retorna un dato de tipo NodoArbol
     * @author Valeria Arias, Jesus Perez
     */
    public NodoArbol SubArbol(NodoArbol dato2, NodoArbol dato1, NodoArbol operador){
        operador.izquierdo = dato1;
        operador.derecho = dato2;
        return operador;
    }
    
    /**
     * Verifica si el arbol esta vacio
     * @return retorna un bool
     * @author Valeria Arias, Jesus Perez
     */
    public boolean ArbolVacio(){
        return raiz == null;
    }
    
    /**
     * Expresar el arbol en Preorden o infija
     * @param subArbol un sub-arbol del arbol binario
     * @param c un dato
     * @return Retorna un str
     * @author Valeria Arias, Jesus Perez
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
     * Expresar el arbol en Inorden o Polaca
     * @param subArbol un sub-arbol del arbol binario
     * @param c un dato
     * @return Retorna un str
     * @author Valeria Arias, Jesus Perez
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
     * Expresar el arbol en Posorden o Polaca Inversa
     * @param subArbol un sub-arbol del arbol binario
     * @param c un dato
     * @return Retorna un str
     * @author Valeria Arias, Jesus Perez
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
     * Imprime el arbol en sus 3 notaciones
     * @param a un dato para realizar el "switch"
     * @return retorna un str
     * @author Valeria Arias, Jesus Perez
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
    
    /**
     * Determina la prioridad de los operadores
     * @param c un dato para realizar el "switch"
     * @return retorna un int
     * @author Valeria Arias, Jesus Perez
     */
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
    
    /**
     * Verifica si el dato es o no un operador
     * @param c un dato para realizar el "switch"
     * @return retorna un bool
     * @author Valeria Arias, Jesus Perez
     */
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
    
    /**
     * Crea el arbol a traves de un dato str 
     * @param cadena el dato con el que se creara el arbol
     * @return retorna un dato de tipo NodoArbol
     * @author Valeria Arias, Jesus Perez
     */
    private NodoArbol CrearABE(String cadena){
        
        Pila Operadores;
        Pila Expresiones;
        
        NodoArbol token;
        NodoArbol op1;
        NodoArbol op2;
        NodoArbol op;
        
        Operadores = new Pila();
        Expresiones = new Pila();
        
        char caracterEvaluado;
        for(int i = 0; i < cadena.length(); i++){
            caracterEvaluado = cadena.charAt(i);
            token = new NodoArbol(caracterEvaluado);
            if(!EsOperador(caracterEvaluado)){
                Expresiones.Insertar(token);
            }
            else{
                switch(caracterEvaluado){
                    case '(':
                        Operadores.Insertar(token);
                        break;
                    case ')':
                        while(!Operadores.PilaVacia() && !Operadores.CimaPila().dato.equals('(')){
                            op2 = Expresiones.Quitar();
                            op1 = Expresiones.Quitar();
                            op = Operadores.Quitar();
                            op = SubArbol(op2, op1, op);
                            Expresiones.Insertar(op);
                        }
                        Operadores.Quitar();
                        break;
                    default:
                        while(!Operadores.PilaVacia() && Prioridad(caracterEvaluado)<= Prioridad(Operadores.CimaPila().dato.toString().charAt(0))){
                            op2 = Expresiones.Quitar();
                            op1 = Expresiones.Quitar();
                            op = Operadores.Quitar();
                            op = SubArbol(op2, op1, op);
                            Expresiones.Insertar(op);
                        }
                        Operadores.Insertar(token);
                }
            }
            
        }
        while(!Operadores.PilaVacia()){
            op2 = Expresiones.Quitar();
            op1 = Expresiones.Quitar();
            op = Operadores.Quitar();
            op = SubArbol(op2, op1, op);
            Expresiones.Insertar(op);
        }
        op = Expresiones.Quitar();
        return op;
    }
    
}

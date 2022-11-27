/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Valeria
 */
public class Lienzo extends JPanel {
    private ArbolBinario objArbol;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 20;

    public void setObjArbol(ArbolBinario objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, objArbol.raiz);
    }
    
    private void pintar(Graphics g, int x, int y, NodoArbol n) {
        if (n == null)
        {}
        else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.dato.toString(), x + 12, y + 18);
            if (null != n.izquierdo){
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            }
            if (null != n.derecho){
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            }
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.izquierdo);
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.derecho);
        }
    }
}

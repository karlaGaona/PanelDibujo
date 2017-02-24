package Tarea1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class Dibujo extends JPanel{
    private final Point[] puntos = new Point[10000];
    private int contador = 0;
    
    public Dibujo(){
        addMouseMotionListener(new Evento());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < contador; i++) {
            //Primero   Punto en x
            //Segundo   Punto en y
            //Tercero   Altura
            //Cuarto    Anchura
            g.fillOval(puntos[i].x, puntos[i].y, 5, 5);
            g.setColor(Color.BLACK);
        }
    }
    
    private class Evento extends MouseMotionAdapter{
    
        @Override
        public void mouseDragged(MouseEvent me){
            if (contador < puntos.length) {
                puntos[contador] = me.getPoint();
                contador++;
                repaint();
            }
        }
        
    }
    
}


package Tarea1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dibuj extends JPanel{
    private final Point[] puntos = new Point[10000];
    private final Point[] puntos2 = new Point[10000];
    private final JLabel posicion;
    private int contador = 0;
    
    public Dibuj(){
        posicion = new JLabel();
        posicion.setForeground(Color.BLACK);
        setLayout(new BorderLayout());
        add(posicion, BorderLayout.SOUTH);
        addMouseMotionListener(new Evento());
        addMouseListener(new Event());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int i = 0; i < contador; i++) {
            if (puntos[i].x > puntos2[i].x) {
                if (puntos[i].y > puntos2[i].y) {
                    g.drawRect(puntos2[i].x, puntos2[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                    g.drawOval(puntos2[i].x, puntos2[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                } else {
                    g.drawRect(puntos2[i].x, puntos[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                    g.drawOval(puntos2[i].x, puntos[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                }
            } else {
                if (puntos[i].y > puntos2[i].y) {
                    g.drawRect(puntos[i].x, puntos2[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                    g.drawOval(puntos[i].x, puntos2[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                } else {
                    g.drawRect(puntos[i].x, puntos[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                    g.drawOval(puntos[i].x, puntos[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y));
                }
            }
            g.setColor(Color.BLACK);
        }
    }
    
    private class Event extends MouseAdapter{
        
        @Override
        public void mousePressed(MouseEvent me){
            if (contador < puntos.length) {
                puntos[contador] = me.getPoint();
                contador++;
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent me){
            if (contador < puntos.length) {
                puntos2[contador - 1] = me.getPoint();
                repaint();
            }
        }
    }
    
    private class Evento extends MouseMotionAdapter{
        @Override
        public void mouseDragged(MouseEvent me) {
            if (contador < puntos.length) {
                puntos2[contador - 1] = me.getPoint();
                repaint();
            }
        }
        
    }
    
}


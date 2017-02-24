package Tarea1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel{
    private final Point[] puntos = new Point[10000];
    private final Point[] puntos2 = new Point[10000];
    private final JComboBox jcbColor, jcbFill, jcbFig;
    private final String colores[] = {"Negro", "Rojo", "Azul", "Verde", "Rosa", "Amarillo", "Naranja"};
    private final String figuras[] = {"Linea", "Rectangulo/Cuadrado", "Circulo"};
    private final String rellenar[] = {"No", "Si"};
    private final String colorFigura[] = new String[10000];
    private final String formaFigura[] = new String[10000];
    private final String rellenarFigura[] = new String[10000];
    private final JButton und, clear;
    private final JPanel pnorte;
    public int contador = 0;
    
    public PanelDibujo(){
        und = new JButton("Undo");
        clear = new JButton("Clear");
        jcbColor = new JComboBox(colores);
        jcbFill = new JComboBox(rellenar);
        jcbFig = new JComboBox(figuras);
        pnorte = new JPanel();
        add(pnorte, BorderLayout.NORTH);
        pnorte.setLayout(new GridLayout(1, 5, 10, 10));
        pnorte.add(und);
        pnorte.add(clear);
        pnorte.add(jcbFig);
        pnorte.add(jcbColor);
        pnorte.add(jcbFill);
        addMouseMotionListener(new Evento());
        addMouseListener(new Event());
        und.addActionListener(new undo());
        clear.addActionListener(new clear());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < contador; i++) {
            color(colorFigura[i], g);
            if (puntos[i].x > puntos2[i].x) {
                if (puntos[i].y > puntos2[i].y) {
                    if (formaFigura[i].equals("Linea")) {
                        figura(formaFigura[i], g, puntos[i].x, puntos[i].y, puntos2[i].x, puntos2[i].y, rellenarFigura[i]);
                    } else {
                        figura(formaFigura[i], g, puntos2[i].x, puntos2[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y), rellenarFigura[i]);
                    }
                } else {
                    if (formaFigura[i].equals("Linea")) {
                        figura(formaFigura[i], g, puntos[i].x, puntos[i].y, puntos2[i].x, puntos2[i].y, rellenarFigura[i]);
                    } else {
                        figura(formaFigura[i], g, puntos2[i].x, puntos[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y), rellenarFigura[i]);
                    }
                }
            } else {
                if (puntos[i].y > puntos2[i].y) {
                    if (formaFigura[i].equals("Linea")) {
                        figura(formaFigura[i], g, puntos[i].x, puntos[i].y, puntos2[i].x, puntos2[i].y, rellenarFigura[i]);
                    } else {
                        figura(formaFigura[i], g, puntos[i].x, puntos2[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y), rellenarFigura[i]);
                    }
                } else {
                    if (formaFigura[i].equals("Linea")) {
                        figura(formaFigura[i], g, puntos[i].x, puntos[i].y, puntos2[i].x, puntos2[i].y, rellenarFigura[i]);
                    } else {
                        figura(formaFigura[i], g, puntos[i].x, puntos[i].y, Math.abs(puntos2[i].x - puntos[i].x), Math.abs(puntos[i].y - puntos2[i].y), rellenarFigura[i]);
                    }
                }
            }
            
        }
    }
    
    private void figura(String fig, Graphics g, int a, int b, int c, int d, String fi){
        switch(fig){
            case "Linea": g.drawLine(a, b, c, d); break;
            case "Rectangulo/Cuadrado":
                if (fi.equals("Si")) {
                    g.fillRect(a, b, c, d);
                } else {
                    g.drawRect(a, b, c, d);
                }
                break;
            case "Circulo":
                if (fi.equals("Si")) {
                    g.fillOval(a, b, c, d);
                } else {
                    g.drawOval(a, b, c, d);
                }
                break;
        }
    }
    
    private void color(String color, Graphics g){
        switch(color){
            case "Negro": g.setColor(Color.BLACK); break;
            case "Rojo": g.setColor(Color.RED); break;
            case "Azul": g.setColor(Color.BLUE); break;
            case "Verde": g.setColor(Color.GREEN); break;
            case "Rosa": g.setColor(Color.PINK); break;
            case "Amarillo": g.setColor(Color.YELLOW); break;
            case "Naranja": g.setColor(Color.ORANGE); break;
        }
    }
    
    private class Event extends MouseAdapter{
        
        @Override
        public void mousePressed(MouseEvent me){
            if (contador < puntos.length) {
                puntos[contador] = me.getPoint();
                formaFigura[contador] = jcbFig.getSelectedItem().toString();
                colorFigura[contador] = jcbColor.getSelectedItem().toString();
                rellenarFigura[contador] = jcbFill.getSelectedItem().toString();
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
    
    private class undo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (contador == 0) {
                repaint();
            } else {
                contador--;
                repaint();
            }
        }
        
    }
    
    private class clear implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            contador = 0;
            repaint();
        }
        
    }
    
}
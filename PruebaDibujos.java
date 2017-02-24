package Tarea1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public final class PruebaDibujos {

    private final JFrame ventana;
    private final JPanel panelNorte;
    private final PanelDibujo panel;
    private final JLabel posicion;
    
    public PruebaDibujos(){
        ventana = new JFrame("Ventana de dibujo");
        panelNorte = new JPanel();
        ventana.setIconImage(new ImageIcon(getClass().getResource("paris.jpg")).getImage());
        posicion = new JLabel("");
        panel = new PanelDibujo();
        armado();
        asignar();
        personalizar();
        mostrar();
    }
    
    public void armado(){
        ventana.setLayout(new BorderLayout());
        ventana.add(panel, BorderLayout.CENTER);
        ventana.add(posicion, BorderLayout.SOUTH);
        ventana.add(panelNorte, BorderLayout.NORTH);
        
    }
    
    public void personalizar(){
        ventana.setSize(800, 550);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        panel.setBackground(Color.WHITE);
    }
    
    public void asignar(){
        panel.addMouseMotionListener(new posicionMouse());
    }
    
    public void mostrar(){
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class posicionMouse implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent me) {
            posicion.setText("(" + me.getX() + ", " + me.getY() + ")");
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            posicion.setText("(" + me.getX() + ", " + me.getY() + ")");
        }
        
    }
    
    public static void main(String[] args) {

        try {
            
        } catch (Exception e) {
        }

        PruebaDibujos v = new PruebaDibujos();
        
    }
    
}
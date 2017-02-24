package Tarea1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

public final class PruebaDibuj {

    private final JFrame ventana;
    private final Dibuj panel;
    
    public PruebaDibuj(){
        ventana = new JFrame("Ventana de dibujo");
        ventana.setIconImage(new ImageIcon(getClass().getResource("paris.jpg")).getImage());
        panel = new Dibuj();
        armado();
        personalizar();
        mostrar();
    }
    
    public void armado(){
        ventana.setLayout(new BorderLayout());
        ventana.add(panel, BorderLayout.CENTER);
    }
    
    public void personalizar(){
        ventana.setSize(700, 500);
        ventana.setLocationRelativeTo(null);
        panel.setBackground(Color.WHITE);
    }
    
    public void mostrar(){
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {

        try {
          
        } catch (Exception e) {
        }

        PruebaDibuj v = new PruebaDibuj();
        
    }
    
}
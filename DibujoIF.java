package Tarea1;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public final class DibujoIF extends JInternalFrame{
    
    private final PanelDibujoIF panel;
    
    public DibujoIF(){
        setFrameIcon(new ImageIcon("C:/Users/Usuario/Pictures/Icono.png"));
        panel = new PanelDibujoIF();
        add(panel);
        personalizar();
        mostrar();
    }
    
    public void personalizar(){
        setSize(300, 300);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
    }
    
    public void mostrar(){
        setVisible(true);
    }
    
}
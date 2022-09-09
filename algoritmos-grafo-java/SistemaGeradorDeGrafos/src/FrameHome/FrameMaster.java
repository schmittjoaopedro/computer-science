package FrameHome;

import FrameHome.Controller.GrafoAdjacenteController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameMaster extends JFrame{
    
    private JButton[] myButtons = {new JButton("Grafo Adjacente "),new JButton("Grafo Incidente ")};;
    
    public FrameMaster(){
        
        super("System Generator Grafos");
        setLayout(new BorderLayout());
        
        JPanel box = new JPanel();  
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS)); 
        
        for(JButton button : myButtons){
            button.setMinimumSize(new Dimension(150, 40));
            button.setPreferredSize(new Dimension(150, 40)); 
            button.setMaximumSize(new Dimension(150, 40)); 
            box.add(button, BorderLayout.EAST);
        }
        
        add(box);
        
        new GrafoAdjacenteController().executeGrafo(myButtons[0]);
        
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

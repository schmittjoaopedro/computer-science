package FrameHome.Controller;

import FrameGrafos.GrafoAdjacente;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GrafoAdjacenteController implements Implementation, Runnable {

    @Override
    public void executeGrafo(JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                run();
            }
        });
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new GrafoAdjacente(new GeneratorGrafos().inicarGrafio(8)),BorderLayout.CENTER);
        frame.setTitle("Grafo Adjacente");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}

package FrameGrafos;

import FrameHome.MasterMain;
import java.awt.Graphics;

public class GrafoAdjacente extends MasterMain {

    
    
    
    public GrafoAdjacente(boolean grafo[][]){
        super(grafo);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double posicao[][] = new double[getLogicalGrafo().length][2];
        int valores[] = new int[getLogicalGrafo().length];

        for (int i = 0; i < valores.length; i++) {
            valores[i] = i + 1;
        }

        for (int i = 0; i < getLogicalGrafo().length; i++) {
            double x = Math.random() * 400;
            double y = Math.random() * 400;
            posicao[i][0] = x;
            posicao[i][1] = y;
            g.drawOval((int) x - 5, (int) y - 5, 20, 20);
        }
        
        for (int i = 0; i < getLogicalGrafo().length; i++) {
            for (int j = 0; j < getLogicalGrafo()[i].length; j++) {
                if(getLogicalGrafo()[i][j]){
                    g.drawLine((int) posicao[i][0],(int) posicao[i][1],(int) posicao[j][0],(int) posicao[j][1]);
                }
            }
        }

    }
        
}

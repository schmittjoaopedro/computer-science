package catolica.joaoemiliano;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DijkstraPanel extends JPanel {

    DijkstraFrame.listaadj[] grafo;
    int flag = 0;

    public void setAdjacencia(DijkstraFrame.listaadj[] lista) {
        grafo = lista;
        flag = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (flag == 0) {
            if (grafo != null) {
                int[][][] valores = new int[grafo.length][grafo.length][2];
                double posicao[][] = new double[grafo.length][2];

                for (int i = 0; i < grafo.length; i++) {
                    for (int j = 0; j < grafo.length; j++) {
                        valores[i][j][0] = 0;
                    }
                }

                for (int i = 1; i < valores.length; i++) {
                    while (grafo[i].listav != null) {
                        for (int j = 1; j < valores.length; j++) {
                            if (grafo[i].listav.num == j) {
                                valores[i][j][0] = 1;
                                valores[i][j][1] = grafo[i].listav.peso;
                            }
                        }
                        grafo[i].listav = grafo[i].listav.prox;
                    }
                }

                int flag = 0;
                for (int i = 1; i < grafo.length; i++) {
                    for (int j = 1; j < grafo.length; j++) {
                        if (valores[i][j][0] == 0) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                    }
                    if (flag == 1) {
                        valores[i][0][0] = 1;
                    }
                }
                double x = 0;
                double y = 0;
                int val = 100;
                double flagMais = 2;
                double flagMenos = 1;
                int flagCount = 0;
                int meio = valores.length / 2;

                for (int i = 1; i < valores.length; i++) {

                    if (flagCount < meio) {
                        if (flagMais > flagMenos) {
                            x += validador() * (val * flagMais);
                            y = validador() * (val * flagMenos);
                            flagMenos = flagMenos + 2;
                        } else {
                            x = validador() * (val * flagMenos);
                            y += validador() * (val * flagMais);
                            flagMais = flagMais + 2;
                        }
                    }else{
                        if (flagMais > flagMenos) {
                            x -= validador() * (val * flagMais);
                            y = validador() * (val * flagMenos);
                            flagMenos = flagMenos + 2;
                        } else {
                            x -= validador() * (val * flagMenos);
                            y = validador() * (val * flagMais);
                            flagMais = flagMais + 2;
                        }
                    }
                    
                    posicao[i][0] = x;
                    posicao[i][1] = y;
                    g.drawOval((int) x - 15, (int) y - 15, 50, 50);
                }

                g.setFont(new Font("Arial", 1, 25));
                for (int i = 1; i < valores.length; i++) {
                    for (int j = 1; j < valores[i].length; j++) {
                        if (valores[i][j][0] == 1) {
                            g.drawLine((int) posicao[i][0], (int) posicao[i][1], (int) posicao[j][0], (int) posicao[j][1]);
                            g.drawString(String.valueOf(valores[i][j][1]),
                                    (int) ((posicao[i][0] + 10 + posicao[j][0]) / 2),
                                    (int) ((posicao[i][1] + 10 + posicao[j][1]) / 2));
                            g.drawString(String.valueOf(i), (int) posicao[i][0] + 5, (int) posicao[i][1] + 20);
                        }
                        if (valores[i][0][0] == 1) {
                            g.drawString(String.valueOf(i), (int) posicao[i][0] + 5, (int) posicao[i][1] + 20);
                        }
                    }
                }
            }
            flag++;
        }
    }
    
    double validador(){
        double value = 0;
        while(value < 0.3 || value > 0.6){
            value = Math.random();
        }
        return value;
    }
}

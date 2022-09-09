package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoSelectionSortTipo1 extends OrdenacaoAbstrata {

    private int eleito = 1;
    private int posicao = 0;
    private int menor = 0;
    private int pos = 0;

    public OrdenacaoSelectionSortTipo1(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }

    @Override
    public synchronized void ordenar() {
        setTempoInicial();
        for (posicao = 0; posicao < getOrdenaveis().length - 1; posicao++) {
            
            MostraStatusLoop();

            eleito = getOrdenaveis()[posicao];
            menor = getOrdenaveis()[posicao + 1];
            pos = posicao + 1;
            for (int j = posicao + 2; j < getOrdenaveis().length; j++) {
                setNumeroComparacoes();
                if (getOrdenaveis()[j] < menor) {
                    menor = getOrdenaveis()[j];
                    pos = j;
                }
            }
            if (menor < eleito) {
                setNumeroTrocas();
                getOrdenaveis()[posicao] = getOrdenaveis()[pos];
                getOrdenaveis()[pos] = eleito;
            }

            atualizarPainel();
            try {
                sleep(getTimeSleepValue());
            } catch (InterruptedException er) {
                JOptionPane.showMessageDialog(null, "Aplicativo encerrado inesperadamente");
            }
        }
        setTempoFinal();
    }
}

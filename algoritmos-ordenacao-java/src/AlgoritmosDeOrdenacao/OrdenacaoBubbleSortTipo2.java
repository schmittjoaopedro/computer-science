package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoBubbleSortTipo2 extends OrdenacaoAbstrata {

    public OrdenacaoBubbleSortTipo2(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }

    @Override
    public synchronized void ordenar() {
        try {
            setTempoInicial();
            for (int e = 0; e < getOrdenaveis().length; e++) {
                MostraStatusLoop();
                for (int i = e; i <= getOrdenaveis().length - 1; i++) {
                    setNumeroComparacoes();
                    if (getOrdenaveis()[i] > getOrdenaveis()[e]) {
                        setNumeroTrocas();
                        trocarPosicaoVetores(i, e);
                    }
                }
                atualizarPainel();
                sleep(getTimeSleepValue());
            }
            setTempoFinal();
        } catch (InterruptedException er) {
            JOptionPane.showMessageDialog(null, "Programa interrompido inesperadamente");
        }
    }
}

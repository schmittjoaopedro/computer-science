package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoBubbleSortTipo3 extends OrdenacaoAbstrata {
    
    public OrdenacaoBubbleSortTipo3(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }
    
    @Override
    public synchronized void ordenar() {
        try {           
            setTempoInicial();
            for (int cont = 0; cont < getOrdenaveis().length; cont++) {
                MostraStatusLoop();
                for (int i = getOrdenaveis().length - 1; i >= cont + 1; i--) {
                    setNumeroComparacoes();
                    if (getOrdenaveis()[i] < getOrdenaveis()[i - 1]) {
                        setNumeroTrocas();
                        trocarPosicaoVetores(i, (i - 1));
                    }
                }
                atualizarPainel();
                sleep(getTimeSleepValue());
            }
        } catch (InterruptedException er) {
            JOptionPane.showMessageDialog(null, "Aplicativo parou inesperadamente");
        }
        setTempoFinal();
    }
}

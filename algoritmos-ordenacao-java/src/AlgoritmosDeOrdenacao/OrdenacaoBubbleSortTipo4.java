package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoBubbleSortTipo4 extends OrdenacaoAbstrata {

    public OrdenacaoBubbleSortTipo4(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }

    @Override
    public synchronized void ordenar() {
        int troca = 1;
        int n = 0;
        setTempoInicial();
        while (n < getOrdenaveis().length && troca == 1) {
            troca = 0;
            MostraStatusLoop();
            for (int i = 0; i < getOrdenaveis().length - 1; i++) {
                setNumeroComparacoes();
                if (getOrdenaveis()[i] > getOrdenaveis()[i + 1]) {
                    setNumeroTrocas();
                    troca = 1;
                    trocarPosicaoVetores(i, (i + 1));
                }
            }
            atualizarPainel();
            n++;
            try{
                sleep(getTimeSleepValue());
            }catch(InterruptedException er){
                JOptionPane.showMessageDialog(null, "O Aplicativo parou inesperadamente");
            }
            setTempoFinal();
        }
    }
}

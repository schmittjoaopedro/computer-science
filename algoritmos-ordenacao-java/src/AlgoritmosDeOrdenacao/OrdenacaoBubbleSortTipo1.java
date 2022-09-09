package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoBubbleSortTipo1 extends OrdenacaoAbstrata {

    public OrdenacaoBubbleSortTipo1(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }

    @Override
    public synchronized void ordenar() {
        setTempoInicial();
        for (int flag = 0; flag < getOrdenaveis().length; flag++) {
            
            for(int item : getOrdenaveis())
                System.out.print(item + "-");
            System.out.println(" ");
        
            MostraStatusLoop();
            for (int i = flag; i < getOrdenaveis().length; i++) {
                setNumeroComparacoes();
                System.out.println("Teste");
                if (getOrdenaveis()[flag] > getOrdenaveis()[i]) {
                    setNumeroTrocas();
                    trocarPosicaoVetores(i, flag);
                }
            }
            atualizarPainel();
            try {
                sleep(getTimeSleepValue());
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Programa foi fechado inesperadamente!");
            }
        }
        setTempoFinal();
    }
}
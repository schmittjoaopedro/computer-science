package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoInsertionSortTipo1 extends OrdenacaoAbstrata {

    private int eleito = 1;
    private int posicao = 0;
    private int aux;

    public OrdenacaoInsertionSortTipo1(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }

    @Override
    public synchronized void ordenar() {
        setTempoInicial();
        for (posicao = 1; posicao < getOrdenaveis().length; posicao++) {
            MostraStatusLoop();
            eleito = getOrdenaveis()[posicao];
            aux = posicao - 1;
            setNumeroComparacoes();
            while (aux >= 0 && getOrdenaveis()[aux] > eleito) {
                setNumeroTrocas();
                getOrdenaveis()[aux + 1] = getOrdenaveis()[aux];
                aux--;
            }
            getOrdenaveis()[aux + 1] = eleito;
            atualizarPainel();
            setTempoFinal();
            try{
                sleep(getTimeSleepValue());
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, "Aplicativo encerrou inesperadamente");
            }
        }
    }
}

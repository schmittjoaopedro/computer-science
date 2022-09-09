package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoQuickSort extends OrdenacaoAbstrata {

    public OrdenacaoQuickSort(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }
    
    @Override
    public void ordenar() {
        setTempoInicial();
        quickSort(getOrdenaveis(), 0, getOrdenaveis().length - 1, 0);
        setTempoFinal();
    }
    
        
    public synchronized void quickSort(int vet[], int ini, int fim, int cont) {
        int meio;
 
        if (ini < fim) {
            meio = partition(vet, ini, fim);
            quickSort(vet, ini, meio, cont);
            quickSort(vet, meio + 1, fim, cont);
        }
        
        MostraStatusLoop();
            atualizarPainel();
            try{
                sleep(getTimeSleepValue());
            }catch(InterruptedException er){
                JOptionPane.showMessageDialog(null, "O Aplicativo Parou Inesperadamente");
            }
    }
 
    public int partition(int vet[], int ini, int fim) {
        int pivo, topo, i;
        pivo = vet[ini];
        topo = ini;
 
        for (i = ini + 1; i <= fim; i++) {
            setNumeroComparacoes();
            if (vet[i] < pivo) {
                setNumeroTrocas();
                vet[topo] = vet[i];
                vet[i] = vet[topo + 1];
                topo++;
            }
        }
        vet[topo] = pivo;
        return topo;
    }
}

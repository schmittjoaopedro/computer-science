package AlgoritmosDeOrdenacao;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class OrdenacaoMergeSort extends OrdenacaoAbstrata{
    
    public OrdenacaoMergeSort(int[] ordenaveis, JTextArea textArea,int tempoDefinido) {
        super(ordenaveis, textArea, tempoDefinido);
    }

    @Override
    public synchronized void ordenar() {
        int cont = 0;
        setTempoInicial();
        merge(getOrdenaveis(), 0, getOrdenaveis().length-1, cont);
        setTempoFinal();
    }
    
    public void merge(int vetor[], int inicio, int fim, int cont){
        int meio;
        cont++;
        if(inicio < fim){
            meio = (inicio + fim) /2;
            merge(vetor, inicio, meio,cont);
            merge(vetor, meio + 1, fim,cont);
            intercalar(vetor, inicio, meio, fim);
        }
            MostraStatusLoop();
            atualizarPainel();
            try{
                sleep(getTimeSleepValue());
            }catch(InterruptedException er){
                JOptionPane.showMessageDialog(null, "O Aplicativo Parou Inesperadamente");
            }
    }
    
    public void intercalar(int vetor[], int inicio, int meio, int fim){
        int posLivre = inicio;
        int inicioVetor1= inicio;
        int inicioVetor2 = meio + 1;
        int aux[] = new int[vetor.length];
        
        while(inicioVetor1 <= meio && inicioVetor2 <= fim){
            setNumeroComparacoes();
            if(vetor[inicioVetor1] <= vetor[inicioVetor2]){
                setNumeroTrocas();
                aux[posLivre] = vetor[inicioVetor1];
                inicioVetor1++;
            }else{
                setNumeroTrocas();
                aux[posLivre] = vetor[inicioVetor2];
                inicioVetor2++;
            }
            posLivre++;
        }
        for (int i = inicioVetor1; i <= meio; i++) {
            setNumeroTrocas();
            aux[posLivre] = vetor[i];
            posLivre++;
        }
        for (int i = inicioVetor2; i <= fim; i++) {
            setNumeroTrocas();
            aux[posLivre] = vetor[i];
            posLivre++;
        }
        for (int i = inicio; i <= fim; i++) {
            vetor[i] = aux[i];
        }
    }
    
}

package AlgoritmosDeOrdenacao;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextArea;

public abstract class OrdenacaoAbstrata extends Thread {

    private int[] ordenaveis;
    private int timeSleepValue = 500;
    private JTextArea textArea;
    private int numeroTrocas = 0;
    private int numeroComparacoes = 0;
    private long tempoInicial = 0;
    private long tempoFinal = 0;

    public OrdenacaoAbstrata(int[] ordenaveis, JTextArea textArea, int tempoAtualizacao) {
        this.ordenaveis = ordenaveis;
        this.textArea = textArea;
        setTimeSleepValue(tempoAtualizacao);
    }

    protected void setTimeSleepValue(int value){
        this.timeSleepValue = value;
    }
    
    protected final int getTimeSleepValue() {
        return this.timeSleepValue;
    }

    protected JTextArea getPainelOrdenacaoTextArea(){
        return this.textArea;
    }

    public int getNumeroTrocas() {
        return numeroTrocas;
    }

    public void setNumeroTrocas() {
        this.numeroTrocas++;
    }

    public int getNumeroComparacoes() {
        return numeroComparacoes;
    }

    public void setNumeroComparacoes() {
        this.numeroComparacoes++;
    }

    public long getTempoInicial() {
        return tempoInicial;
    }

    public void setTempoInicial() {
        this.tempoInicial = System.currentTimeMillis();
    }

    public long getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal() {
        double tempoDecorrido =  (System.currentTimeMillis() - getTempoInicial()) / 1000;
        MostraStatusLoop();
        this.textArea.append("Tempo de decorrio: " + tempoDecorrido + " segundos\n");
        atualizarPainel();
    }
    
    protected long tempoDecorrido(){
        return getTempoFinal() - getTempoInicial();
    }
    
    @Override
    public void run() {
        this.ordenar();
    }

    public abstract void ordenar();

    public int[] getOrdenaveis() {
        return this.ordenaveis;
    }

    public void atualizarPainel() {
        for (int i = 0; i < ordenaveis.length; i++) {
            this.textArea.append(String.format("%02d - ", ordenaveis[i]));
            for (int x = 0; x < ordenaveis[i]; x++) {
                this.textArea.append("[]");
            }
            this.textArea.append("\n");
        }
    }

    public void trocarPosicaoVetores(int indice1, int indice2) {

        int aux = ordenaveis[indice1];
        ordenaveis[indice1] = ordenaveis[indice2];
        ordenaveis[indice2] = aux;

    }

    public void MostraStatusLoop() {
        this.textArea.setText("");
        this.textArea.append("Número de trocas: " + getNumeroTrocas() + "\n");
        this.textArea.append("Número de comparações: " + getNumeroComparacoes() + "\n");
    }
}

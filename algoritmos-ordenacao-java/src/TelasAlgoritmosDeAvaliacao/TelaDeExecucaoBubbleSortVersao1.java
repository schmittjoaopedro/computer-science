package TelasAlgoritmosDeAvaliacao;

import AlgoritmosDeOrdenacao.OrdenacaoBubbleSortTipo1;
import javax.swing.JOptionPane;

public class TelaDeExecucaoBubbleSortVersao1 extends TelaPadraoDeExecucao {

    public TelaDeExecucaoBubbleSortVersao1() {
        super("Algoritmo de Ordenacao Bubble Sorte Tipo 1");
    }

    @Override
    public void run() {
        try {
            
            int arrayOrdenavel[] = gerarArray();
            
            Thread executar = new OrdenacaoBubbleSortTipo1(arrayOrdenavel, areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao, Integer.parseInt(getTempoDelay().getValue().toString()));
            executar.start();
            
        } catch (NumberFormatException er) {
            JOptionPane.showMessageDialog(null, "Reinicie a janela e digite um numero valido");
        }
    }
}

package TelasAlgoritmosDeAvaliacao;

import AlgoritmosDeOrdenacao.OrdenacaoBubbleSortTipo4;
import GeradorDeVetores.GerarVetoresAleatorios;
import javax.swing.JOptionPane;

public class TelaDeExecucaoBubbleSortVersao4 extends TelaPadraoDeExecucao {

    public TelaDeExecucaoBubbleSortVersao4() {
        super("Algoritmo de Ordenacao Bubble Sorte Tipo 4");
    }

    @Override
    public void run() {
        try {

            int arrayOrdenavel[] = gerarArray();

            Thread executar = new OrdenacaoBubbleSortTipo4(arrayOrdenavel, areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao, Integer.parseInt(getTempoDelay().getValue().toString()));
            executar.start();

        } catch (NumberFormatException er) {
            JOptionPane.showMessageDialog(null, "Reinicie a janela e digite um numero valido");
        }
    }
}

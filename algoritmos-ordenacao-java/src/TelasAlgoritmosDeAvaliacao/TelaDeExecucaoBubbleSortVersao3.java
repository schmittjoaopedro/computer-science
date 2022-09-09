package TelasAlgoritmosDeAvaliacao;

import AlgoritmosDeOrdenacao.OrdenacaoBubbleSortTipo3;
import GeradorDeVetores.GerarVetoresAleatorios;
import javax.swing.JOptionPane;

public class TelaDeExecucaoBubbleSortVersao3 extends TelaPadraoDeExecucao {

    public TelaDeExecucaoBubbleSortVersao3() {
        super("Algoritmo de Ordenacao Bubble Sorte Tipo 3");
    }

    @Override
    public void run() {
        try {

            int arrayOrdenavel[] = gerarArray();

            Thread executar = new OrdenacaoBubbleSortTipo3(arrayOrdenavel, areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao, Integer.parseInt(getTempoDelay().getValue().toString()));
            executar.start();

        } catch (NumberFormatException er) {
            JOptionPane.showMessageDialog(null, "Reinicie a janela e digite um numero valido");
        }
    }
}

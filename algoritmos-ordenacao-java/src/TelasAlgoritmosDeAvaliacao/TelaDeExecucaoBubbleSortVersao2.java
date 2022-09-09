package TelasAlgoritmosDeAvaliacao;

import AlgoritmosDeOrdenacao.OrdenacaoBubbleSortTipo2;
import GeradorDeVetores.GerarVetoresAleatorios;
import javax.swing.JOptionPane;

public class TelaDeExecucaoBubbleSortVersao2 extends TelaPadraoDeExecucao {

    public TelaDeExecucaoBubbleSortVersao2() {
        super("Algoritmo de Ordenacao Bubble Sorte Tipo 2");
    }

    @Override
    public void run() {
        try {

            int arrayOrdenavel[] = gerarArray();

            Thread executar = new OrdenacaoBubbleSortTipo2(arrayOrdenavel, areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao, Integer.parseInt(getTempoDelay().getValue().toString()));
            executar.start();

        } catch (NumberFormatException er) {
            JOptionPane.showMessageDialog(null, "Reinicie a janela e digite um numero valido");
        }
    }
}

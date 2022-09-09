package TelasAlgoritmosDeAvaliacao;

import AlgoritmosDeOrdenacao.OrdenacaoInsertionSortTipo1;
import GeradorDeVetores.GerarVetoresAleatorios;
import javax.swing.JOptionPane;

public class TelaDeExecucaoInsertionSortVersao1 extends TelaPadraoDeExecucao {

    public TelaDeExecucaoInsertionSortVersao1() {
        super("Ordenacao Algoritmo Insertion Sort");
    }

    @Override
    public void run() {
        try {

            int arrayOrdenavel[] = gerarArray();

            Thread executar = new OrdenacaoInsertionSortTipo1(arrayOrdenavel, areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao, Integer.parseInt(getTempoDelay().getValue().toString()));
            executar.start();

        } catch (NumberFormatException er) {
            JOptionPane.showMessageDialog(null, "Reinicie a janela e digite um numero valido");
        }
    }
}

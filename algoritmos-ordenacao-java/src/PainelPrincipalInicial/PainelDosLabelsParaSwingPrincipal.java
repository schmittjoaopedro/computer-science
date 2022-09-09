package PainelPrincipalInicial;

import java.awt.Font;
import javax.swing.JLabel;

public class PainelDosLabelsParaSwingPrincipal extends PainelContendoPadroesDeFormatacao {

    private JLabel abrirPainelDeAvaliacaoBubbleSortTipo1JLabel;
    private JLabel abrirPainelDeAvaliacaoBubbleSortTipo2JLabel;
    private JLabel abrirPainelDeAvaliacaoBubbleSortTipo3JLabel;
    private JLabel abrirPainelDeAvaliacaoBubbleSortTipo4JLabel;
    private JLabel abrirPainelDeAvaliacaoInsertionSortJLabel;
    private JLabel abrirPainelDeAvaliacaoSelectionSortJLabel;
    private JLabel abrirPainelDeAvaliacaoMergeSortJLabel;
    private JLabel abrirPainelDeAvaliacaoQuickSortJLabel;
    private Font fonteDeFormatacaoDoTextoDosLabels;

    public PainelDosLabelsParaSwingPrincipal() {

        fonteDeFormatacaoDoTextoDosLabels = new Font("Sans Serif", Font.PLAIN, 20);

        abrirPainelDeAvaliacaoBubbleSortTipo1JLabel = new JLabel("Bubble Sort Tipo 1");
        abrirPainelDeAvaliacaoBubbleSortTipo2JLabel = new JLabel("Bubble Sort Tipo 2");
        abrirPainelDeAvaliacaoBubbleSortTipo3JLabel = new JLabel("Bubble Sort Tipo 3");
        abrirPainelDeAvaliacaoBubbleSortTipo4JLabel = new JLabel("Bubble Sort Tipo 4");
        abrirPainelDeAvaliacaoInsertionSortJLabel = new JLabel("Insertion Sort");
        abrirPainelDeAvaliacaoSelectionSortJLabel = new JLabel("Selection Sort");
        abrirPainelDeAvaliacaoMergeSortJLabel = new JLabel("Merge Sort");
        abrirPainelDeAvaliacaoQuickSortJLabel = new JLabel("Quick Sort");

        abrirPainelDeAvaliacaoBubbleSortTipo1JLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoBubbleSortTipo2JLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoBubbleSortTipo3JLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoBubbleSortTipo4JLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoInsertionSortJLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoSelectionSortJLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoMergeSortJLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);
        abrirPainelDeAvaliacaoQuickSortJLabel.setFont(fonteDeFormatacaoDoTextoDosLabels);

        getBoxLayout().add(abrirPainelDeAvaliacaoBubbleSortTipo1JLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoBubbleSortTipo2JLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoBubbleSortTipo3JLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoBubbleSortTipo4JLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoInsertionSortJLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoSelectionSortJLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoMergeSortJLabel);
        getBoxLayout().add(abrirPainelDeAvaliacaoQuickSortJLabel);

        add(getBoxLayout());

    }
}

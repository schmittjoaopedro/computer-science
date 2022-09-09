package PainelPrincipalInicial;

import javax.swing.JButton;

public class PainelDosBotoesParaSwingPrincipal extends PainelContendoPadroesDeFormatacao {

    private JButton botaoAcionamentoInterfaceBubbleSort1;
    private JButton botaoAcionamentoInterfaceBubbleSort2;
    private JButton botaoAcionamentoInterfaceBubbleSort3;
    private JButton botaoAcionamentoInterfaceBubbleSort4;
    private JButton botaoAcionamentoInterfaceInsertionSort;
    private JButton botaoAcionamentoInterfaceSelectionSort;
    private JButton botaoAcionamentoInterfaceMergeSort;
    private JButton botaoAcionamentoInterfaceQuickSort;

    public PainelDosBotoesParaSwingPrincipal() {

        botaoAcionamentoInterfaceBubbleSort1 = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceBubbleSort2 = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceBubbleSort3 = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceBubbleSort4 = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceInsertionSort = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceSelectionSort = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceMergeSort = new JButton("Abrir Aplicacao");
        botaoAcionamentoInterfaceQuickSort = new JButton("Abrir Aplicacao");

        getBoxLayout().add(botaoAcionamentoInterfaceBubbleSort1);
        getBoxLayout().add(botaoAcionamentoInterfaceBubbleSort2);
        getBoxLayout().add(botaoAcionamentoInterfaceBubbleSort3);
        getBoxLayout().add(botaoAcionamentoInterfaceBubbleSort4);
        getBoxLayout().add(botaoAcionamentoInterfaceInsertionSort);
        getBoxLayout().add(botaoAcionamentoInterfaceSelectionSort);
        getBoxLayout().add(botaoAcionamentoInterfaceMergeSort);
        getBoxLayout().add(botaoAcionamentoInterfaceQuickSort);

        add(getBoxLayout());

    }

    protected JButton getBotaoAcionamento1() {
        return this.botaoAcionamentoInterfaceBubbleSort1;
    }

    protected JButton getBotaoAcionamento2() {
        return this.botaoAcionamentoInterfaceBubbleSort2;
    }

    protected JButton getBotaoAcionamento3() {
        return this.botaoAcionamentoInterfaceBubbleSort3;
    }

    protected JButton getBotaoAcionamento4() {
        return this.botaoAcionamentoInterfaceBubbleSort4;
    }

    protected JButton getBotaoAcionamentoInsertionSort() {
        return this.botaoAcionamentoInterfaceInsertionSort;
    }

    protected JButton getBotaoAcionamentoSelectionSort() {
        return this.botaoAcionamentoInterfaceSelectionSort;
    }
    
    protected JButton getBotaoAcionamentoMergeSort(){
        return this.botaoAcionamentoInterfaceMergeSort;
    }
    
    protected JButton getBotaoAcionamentoQuickSort(){
        return this.botaoAcionamentoInterfaceQuickSort;
    }
}

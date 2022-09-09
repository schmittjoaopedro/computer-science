package TelasAlgoritmosDeAvaliacao;

import GeradorDeVetores.GerarVetoresAleatorios;
import GeradorDeVetores.GerarVetoresIntercalados;
import GeradorDeVetores.GerarVetoresOrdenados;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public abstract class TelaPadraoDeExecucao extends JFrame implements Runnable {

    protected JTextField areaParaInsersaoDoTamanhoDoArrayJTextField;
    protected JLabel informacaoSobreCampoParaInsersaoDoTamanhoDoArrayJLabel;
    protected JTextArea areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao;
    private JPanel rodape;
    protected JRadioButton radioOrdenado;
    protected JRadioButton radioInverso;
    protected JRadioButton radioAleatorio;
    protected ButtonGroup radioGroup;
    protected JSpinner tempoDelay;

    public TelaPadraoDeExecucao(String nomeJFrame) {

        super(nomeJFrame);
        setLayout(new BorderLayout());

        areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao = new JTextArea(100, 100);
        informacaoSobreCampoParaInsersaoDoTamanhoDoArrayJLabel = new JLabel("Entre com o tamanho do array para ser ordenado");
        areaParaInsersaoDoTamanhoDoArrayJTextField = new JTextField(20);
        setRadioOrdenado(new JRadioButton("Ordenado", false));
        setRadioInverso(new JRadioButton("Intercalado", false));
        setRadioAleatorio(new JRadioButton("Aleatorio", true));

        radioGroup = new ButtonGroup();
        radioGroup.add(getRadioAleatorio());
        radioGroup.add(getRadioInverso());
        radioGroup.add(getRadioOrdenado());
        
        SpinnerModel sm = new SpinnerNumberModel(10, 0, 1000, 50); 
        tempoDelay = new JSpinner(sm);

        rodape = new JPanel();
        rodape.add(informacaoSobreCampoParaInsersaoDoTamanhoDoArrayJLabel);
        rodape.add(areaParaInsersaoDoTamanhoDoArrayJTextField);
        rodape.add(new JLabel("Tempo de atualização do frame"));
        rodape.add(tempoDelay);
        
        JPanel cabecario = new JPanel();
        cabecario.add(radioOrdenado);
        cabecario.add(radioInverso);
        cabecario.add(radioAleatorio);

        add(new JScrollPane(areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao), BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);
        add(cabecario, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setVisible(true);

    }

    public JSpinner getTempoDelay() {
        return tempoDelay;
    }

    public JRadioButton getRadioOrdenado() {
        return radioOrdenado;
    }

    public void setRadioOrdenado(JRadioButton radioOrdenado) {
        this.radioOrdenado = radioOrdenado;
    }

    public JRadioButton getRadioInverso() {
        return radioInverso;
    }

    public void setRadioInverso(JRadioButton radioInverso) {
        this.radioInverso = radioInverso;
    }

    public JRadioButton getRadioAleatorio() {
        return radioAleatorio;
    }

    public void setRadioAleatorio(JRadioButton radioAleatorio) {
        this.radioAleatorio = radioAleatorio;
    }

    protected void setTextoArea(String texto) {
        areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao.setText(texto);
    }

    protected int valorDigitadoPeloUsuario() {
        return Integer.parseInt(areaParaInsersaoDoTamanhoDoArrayJTextField.getText());
    }

    public ButtonGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(ButtonGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public JTextArea getAreaImpressao() {
        return areaParaImpressaoDoSistemaDeImpressaoDoAlgoritmoDeOrdenacao;
    }

    protected int[] gerarArray() {
        if (getRadioOrdenado().isSelected()) {
            return new GerarVetoresOrdenados().getVetorGerado(valorDigitadoPeloUsuario());
        } else if (getRadioInverso().isSelected()) {
            return new GerarVetoresIntercalados().gerarVetorInverso(valorDigitadoPeloUsuario());
        } else if(getRadioAleatorio().isSelected()) {
            return new GerarVetoresAleatorios(valorDigitadoPeloUsuario()).getArrayDesordenadoComValoresDefinidos();
        } else {
            return null;
        }
    }
}

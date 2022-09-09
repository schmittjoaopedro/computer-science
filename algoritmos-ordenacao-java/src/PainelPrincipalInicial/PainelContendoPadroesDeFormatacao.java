package PainelPrincipalInicial;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JPanel;

public class PainelContendoPadroesDeFormatacao extends JPanel {

    private Box boxLayout;

    public PainelContendoPadroesDeFormatacao() {
        boxLayout = Box.createVerticalBox();
        boxLayout.add(Box.createRigidArea(new Dimension(12, 8)));
    }

    protected Box getBoxLayout() {

        return this.boxLayout;

    }
}

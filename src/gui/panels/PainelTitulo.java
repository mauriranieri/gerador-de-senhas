package gui.panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelTitulo extends JPanel {

    private final String caminhoImagem = "src/gui/images/cadeado.png";
    private JLabel geradorSenhaLabel;

    public PainelTitulo() {
        super(null);
        this.setBounds(0, 0, 500, 50);
        this.setBackground(Color.decode("#075873"));
        configurarGeradorSenhaLabel();
        this.add(geradorSenhaLabel);
    }

    private void configurarGeradorSenhaLabel() {
        geradorSenhaLabel = new JLabel("Gerador de Senhas");
        geradorSenhaLabel.setBounds(100, 2, 500, 50);
        geradorSenhaLabel.setFont(new Font("Arial", Font.BOLD, 28));
        geradorSenhaLabel.setForeground(Color.WHITE);
        geradorSenhaLabel.setIcon(new ImageIcon(caminhoImagem));
    }
}

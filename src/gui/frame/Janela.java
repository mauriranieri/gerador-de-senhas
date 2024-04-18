package gui.frame;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import gui.panels.PainelGeracaoSenha;
import gui.panels.PainelTitulo;

public class Janela extends JFrame {
    
    private Container contentJanela = this.getContentPane();
    private PainelTitulo painelTitulo = new PainelTitulo();
    private PainelGeracaoSenha painelGeracaoSenha = new PainelGeracaoSenha();

    public Janela() {

        configurarJanela();
        contentJanela.add(painelTitulo);
        contentJanela.add(painelGeracaoSenha);
        this.setVisible(true);
    }

    private void configurarJanela() {
        contentJanela.setLayout(null);
        contentJanela.setBackground(Color.decode("#d9d9d9"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}

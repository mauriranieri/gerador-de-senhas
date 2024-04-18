package gui.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import generator_password.GeradorSenha;
import gui.listeners.CopyClickHandler;
import gui.listeners.CustomSliderUI;
import gui.listeners.EnterKeyHandler;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class PainelGeracaoSenha extends JPanel {
    
    private final String caminhoImagem = "src/gui/images/copiar-arquivo.png";
    private JTextField senhaGeradaField = new JTextField();
    private JLabel tamanhoSenhaLabel = new JLabel();
    private JSlider tamanhoSenhaSlider = new JSlider();
    private JTextField tamanhoSenhaField = new JTextField();
    private JButton botaoCriarSenha = new JButton();
    private JLabel imageCopiaSenha = new JLabel(new ImageIcon(caminhoImagem));
    private JLabel senhaCopiadaLabel = new JLabel();

    public PainelGeracaoSenha() {
        super(null);
        configurarPainel();
        configurarComponentes();
        adicionarComponentes();
    }

    private void configurarPainel() {
        this.setBackground(Color.WHITE);
        this.setBounds(0, 60, 500, 330);
    }

    private void configurarComponentes() {
        configurarSenhaGeradaField(senhaGeradaField);
        configurarTamanhoSenhaLabel(tamanhoSenhaLabel);
        configurarTamanhoSenhaSlider(tamanhoSenhaSlider);
        configurarTamanhoSenhaField(tamanhoSenhaField);
        configurarBotaoCriarSenha(botaoCriarSenha);
        configurarSenhaCopiadaLabel(senhaCopiadaLabel);
    }

    private void configurarSenhaGeradaField(JTextField textField) {
        textField.setText("Senha a ser gerada...");
        textField.setBounds(30, 20, 380, 50);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setBackground(Color.WHITE);
        textField.setEditable(false);
        textField.setBorder(BorderFactory.createLineBorder(Color.decode("#352fad"), 3));
    }

    private void configurarTamanhoSenhaLabel(JLabel label) {
        label.setText("Quantidade de Caracteres");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBounds(80, 105, 270, 50);
    }

    private void configurarTamanhoSenhaSlider(JSlider slider) {
        slider.setMinimum(10);
        slider.setMaximum(25);
        slider.setValue(10);
        slider.setBounds(30, 154, 350, 40);
        slider.setOpaque(false);
        slider.setFocusable(false);
        slider.setBackground(Color.decode("#352fad"));
    }

    private void configurarTamanhoSenhaField(JTextField textField) {
        textField.setText("" + tamanhoSenhaSlider.getValue());
        textField.setBounds(395, 150, 60, 40);
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setBorder(BorderFactory.createLineBorder(Color.decode("#352fad"), 3));
    }

    private void configurarBotaoCriarSenha(JButton button) {
        button.setText("Criar Senha");
        button.setBounds(30, 210, 425, 50);
        button.setBackground(Color.decode("#352fad"));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void configurarSenhaCopiadaLabel(JLabel label) {
        label.setText("copiado!");
        label.setBounds(420, 65, 60, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        label.setVisible(false);
    }

    private void adicionarComponentes() {
        this.add(senhaGeradaField);
        this.add(tamanhoSenhaLabel);

        tamanhoSenhaSlider.addChangeListener(changeEvent -> {
            tamanhoSenhaField.setText("" + tamanhoSenhaSlider.getValue());
        });
        new CustomSliderUI().customSliderUI(tamanhoSenhaSlider);
        this.add(tamanhoSenhaSlider);

        tamanhoSenhaField.addKeyListener(new EnterKeyHandler(tamanhoSenhaField, tamanhoSenhaSlider));
        this.add(tamanhoSenhaField);

        botaoCriarSenha.addActionListener(actionEvent -> {
            String senha = new GeradorSenha().gerarSenha(tamanhoSenhaSlider.getValue());
            senhaGeradaField.setText(senha);
        });
        this.add(botaoCriarSenha);

        imageCopiaSenha.setBounds(428, 25, 40, 40);
        imageCopiaSenha.addMouseListener(new CopyClickHandler(senhaGeradaField, senhaCopiadaLabel));
        this.add(imageCopiaSenha);

        this.add(senhaCopiadaLabel);
    }
}

package gui.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class EnterKeyHandler implements KeyListener {

    private JTextField tamanhoSenhaField;
    private JSlider tamanhoSenhaSlider;

    public EnterKeyHandler(JTextField tamanhoSenhaField, JSlider tamanhoSenhaSlider) {
        this.tamanhoSenhaField = tamanhoSenhaField;
        this.tamanhoSenhaSlider = tamanhoSenhaSlider;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            int tamanhoSenhaValue = Integer.parseInt(tamanhoSenhaField.getText());

            if(tamanhoSenhaValue < 10) {
                tamanhoSenhaSlider.setValue(10);
                tamanhoSenhaField.setText("10");
            }
            else if(tamanhoSenhaValue > 25) {
                tamanhoSenhaSlider.setValue(25);
                tamanhoSenhaField.setText("25");
            }
            else {
                tamanhoSenhaSlider.setValue(tamanhoSenhaValue);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método não é utilizado
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Este método não é utilizado
    }
    
}

package gui.listeners;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CopyClickHandler implements MouseListener {

    private Timer timer;
    private JTextField senhaGeradaField;
    private JLabel senhaCopiadaLabel;

    public CopyClickHandler(JTextField senhaGeradaField, JLabel senhaCopiadaLabel) {
        this.senhaGeradaField = senhaGeradaField;
        this.senhaCopiadaLabel = senhaCopiadaLabel;

        this.timer = new Timer(4000, event -> {
            senhaCopiadaLabel.setVisible(false);
            ((Timer) event.getSource()).stop(); // Para o timer após 5 segundos
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        senhaCopiadaLabel.setVisible(true);
        timer.start();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        StringSelection selection = new StringSelection(senhaGeradaField.getText());

        clipboard.setContents(selection, null);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este método não é utilizado
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este método não é utilizado
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Este método não é utilizado
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Este método não é utilizado
    } 
}

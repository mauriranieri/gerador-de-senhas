import javax.swing.SwingUtilities;
import gui.frame.Janela;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->  new Janela());
    }
}

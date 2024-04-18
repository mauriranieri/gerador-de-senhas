package gui.listeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSliderUI extends BasicSliderUI {
    
    public void customSliderUI(JSlider tamanhoSenhaSlider) {

        tamanhoSenhaSlider.setUI(new BasicSliderUI(tamanhoSenhaSlider) {
            @Override
            protected Dimension getThumbSize() {
                return new Dimension(22, 22); // Define o tamanho do polegar do slider
            }

            @Override
            public void paintTrack(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setPaint(Color.decode("#352fad")); // Define a cor da barra do slider
                g2d.fillRect(trackRect.x, trackRect.y + (trackRect.height - 10) / 2, trackRect.width, 6);
                g2d.dispose();
            }
        });
    }
}

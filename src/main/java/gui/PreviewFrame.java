package gui;

import model.Image;
import javax.swing.*;
import java.awt.*;

public class PreviewFrame extends JFrame {

    private ImagePanel panel = new ImagePanel();

    public PreviewFrame(Image image) {

        ImagePanel preview = new ImagePanel(image,false,Color.BLACK);
        panel = preview;

        setMinimumSize(new java.awt.Dimension(200, 230));
        setPreferredSize(new java.awt.Dimension(200, 230));
        setTitle("preview");
        getContentPane().setBackground(Color.WHITE);
        setLocationByPlatform(true);
//        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        initPanels();
    }

    public void initPanels() {
        panel.setPreferredSize(new Dimension(16, 16));
        this.getContentPane().add(panel);
    }

    public void updateButtons(Image image) {
        panel.updateImageValues(image.getValues());
        panel.updateButtons();
    }
}

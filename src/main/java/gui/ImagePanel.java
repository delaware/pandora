package gui;

import model.Image;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ImagePanel extends JPanel {

    JButton[] buttons = new JButton[256];
    Image image;
    Color unselectedColor = Color.WHITE;
    Color selectedColor = Color.GREEN;
    boolean borders = true;

    public ImagePanel() {

    }

    public ImagePanel(Image image, boolean borders,Color selectedColor) {
        this.image = image;
        this.borders = borders;
        this.selectedColor = selectedColor;

        setSize(250,250);
        setLayout(new GridLayout(16,16));

        for(int index = 0; index<buttons.length; index++) {
            add(buttons[index] = new JButton());
            if(!borders) {
                buttons[index].setBorder(null);
            }
            if(image.getAt(index) == 0) {
                buttons[index].setBackground(unselectedColor);
            } else {
                buttons[index].setBackground(selectedColor);
            }

            final int r = index;
            final Color finalSelectedColor = selectedColor;

            buttons[index].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(buttons[r].getBackground() == finalSelectedColor) {
                        buttons[r].setBackground(unselectedColor);
                        updateImageValueAt(r,0);
                    } else {
                        buttons[r].setBackground(finalSelectedColor);
                        updateImageValueAt(r, 1);
                    }
                }
            });
        }
    }

    public void updateImageValueAt(int index, int value) {
        image.setAt(index,value);
    }

    public void updateImageValues(double[] values) {
        image.setValues(values);
    }

    public void updateButtons() {
        for(int index = 0; index<buttons.length; index++) {
            if(image.getAt(index) == 0) {
                buttons[index].setBackground(unselectedColor);
            } else {
                buttons[index].setBackground(selectedColor);
            }
        }
    }

    public Image getImage() {
        return this.image;
    }
}

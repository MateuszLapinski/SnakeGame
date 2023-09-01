package org.example.SecondVersion;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DefaultDefaultFactory implements ButtonFactory{
    @Override
    public JButton createButton(String label, int x, int y, int width, int height, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.addActionListener(actionListener);
        return button;
    }

    @Override
    public JLabel createBackgroundLabel(String imagePath, int width, int height) {
        JLabel label = new JLabel(new ImageIcon(imagePath));
        label.setSize(width, height);
        return label;
    }
}

package org.example.SecondVersion;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface ButtonFactory {
    JButton createButton(String label, int x, int y, int width, int height, ActionListener actionListener);
    JLabel createBackgroundLabel(String imagePath, int width, int height);
}

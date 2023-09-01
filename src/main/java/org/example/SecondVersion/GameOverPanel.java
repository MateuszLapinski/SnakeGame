package org.example.SecondVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {

    private static final int width = 600;
    private static final int height = 600;
    Score score= new Score();
    PlayAgainButton playAgainButton;

    GameOverPanel(){
        playAgainButton= new PlayAgainButton();
        setLayout(new BorderLayout());
        this.add(playAgainButton.createButton(), BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.lightGray);
        this.setFocusable(true);
    }


}

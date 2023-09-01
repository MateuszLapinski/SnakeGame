package org.example.SecondVersion;

import javax.swing.*;

public class GameOverFrame {
    JFrame frame=new JFrame();
    GameOverPanel gameOverPanel;
    GameOverFrame(){
        gameOverPanel=new GameOverPanel();
        frame.add(gameOverPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(615, 640);
        frame.setVisible(true);
        frame.setLayout(null);
    }
}

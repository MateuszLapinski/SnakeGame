package org.example.SecondVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameFrame {
    private JFrame frame=new JFrame();
    private JPanel currentPanel;
    private GameOverPanel gameOverPanel;
    private GamePanel gamePanel;

    public NewGameFrame(){
//        frame.add(gamePanel=new GamePanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(615, 640);
//        frame.setVisible(true);
//        frame.setLayout(null);

        addGamePanel();
}

    public void addGamePanel() {
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(615, 640);
        frame.setVisible(true);
        frame.setLayout(null);
    }

}
/*


*/


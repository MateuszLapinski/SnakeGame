package org.example.SecondVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JPanel implements ActionListener  {
    CheckGameState gameState = CheckGameState.getInstance();
    private JFrame frame=new JFrame();
    private JButton newGameButton;
    private JButton displayScoreButton;
    private JButton exitButton;
    private String backgroundPathWork= "F:\\Snake\\src\\main\\resources\\snake.jpg";
    private String backgroundPathHome="G:\\My Drive\\IdeaProjects\\Snake\\src\\main\\resources\\snake.jpg";


    LaunchPage(ButtonFactory buttonFactory){
        newGameButton = buttonFactory.createButton("New Game", 190, 250, 200, 40, this);
        displayScoreButton = buttonFactory.createButton("Score", 190, 300, 200, 40, openScore());
        exitButton = buttonFactory.createButton("Exit", 190, 350, 200, 40, closeApp());

        JLabel backgroundLabel = buttonFactory.createBackgroundLabel(backgroundPathHome, 600, 600);
        frame.add(newGameButton);
        frame.add(displayScoreButton);
        frame.add(exitButton);
        frame.add(backgroundLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            frame.dispose();
            if(gameState.isPlay()==true){
                NewGameFrame gameFrame = new NewGameFrame();
            } else{
                GameOverPanel gameOverPanel=new GameOverPanel();
            }


    }
    public ActionListener openScore() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ScoreFrame scoreFrame=new ScoreFrame();
            }
        };
    }
    public ActionListener closeApp() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }

}


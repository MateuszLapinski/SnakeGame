package org.example.FirstVersion;

import javax.swing.*;

public class Main extends JPanel {
    public static void main(String[] args) {

        SnakeGame snakeGame=new SnakeGame();
        JFrame frame= new JFrame("Snake Game");
        frame.add(snakeGame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
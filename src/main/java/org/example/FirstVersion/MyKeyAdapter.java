package org.example.FirstVersion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {
    private char direction = 'R';
    public MyKeyAdapter(char initialDirection){
        direction=initialDirection;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char newDirection = direction;

        if (keyCode == KeyEvent.VK_LEFT && direction != 'R') {
            newDirection = 'L';
        } else if (keyCode == KeyEvent.VK_RIGHT && direction != 'L') {
            newDirection = 'R';
        } else if (keyCode == KeyEvent.VK_UP && direction != 'D') {
            newDirection = 'U';
        } else if (keyCode == KeyEvent.VK_DOWN && direction != 'U') {
            newDirection = 'D';
        }
        direction=newDirection;
    }

    public char getDirection(){
        return direction;
    }
}

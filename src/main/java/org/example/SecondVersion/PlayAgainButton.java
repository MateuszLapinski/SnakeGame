package org.example.SecondVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAgainButton{


    public JButton createButton(){
        JButton playAgain= new JButton("Play Again");
        playAgain.setBounds(190,400,200,40);
        playAgain.addActionListener(playAgain());
        playAgain.setVisible(true);
        return playAgain;
    }

    private ActionListener playAgain() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NewGameFrame newGameFrame=new NewGameFrame();
            }
        };

    }

}

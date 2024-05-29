package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel {
    JButton newgame;
    public GameOverScreen(){
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        JLabel gameOver=new JLabel("Game Over",SwingConstants.CENTER);
        gameOver.setForeground(Color.WHITE);
        gameOver.setFont(new Font("Arial", Font.BOLD, 24));
        add(gameOver, BorderLayout.CENTER);

        JButton starOverButton = new JButton("Start New Game");
        starOverButton.setFont(new Font("Arial", Font.PLAIN, 18));
        starOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getInstance().startGame();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(starOverButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

}

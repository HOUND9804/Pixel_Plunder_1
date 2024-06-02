package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel {
    JButton startOverButton;
    public GameOverScreen(GamePanel gp){
        this.setLayout(new GridLayout(6,1));
        this.setPreferredSize(new Dimension(gp.screenWidth, gp.screenHeight));
        this.setBackground(new Color(43, 147, 72));

        JLabel gameOver=new JLabel("Game Over",SwingConstants.CENTER);
        gameOver.setForeground(Color.WHITE);
        gameOver.setFont(new Font("Arial", Font.BOLD, 24));

        startOverButton = new JButton("Start New Game");
        startOverButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getInstance().startGame();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(startOverButton);

        // for aligning the components
        this.add(new JLabel(""));
        this.add(gameOver);
        this.add(buttonPanel);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }

}

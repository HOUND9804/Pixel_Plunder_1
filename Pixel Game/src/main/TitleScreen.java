package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JPanel {
    JButton startButton;

    public TitleScreen(GamePanel gp) {
        this.setLayout(new GridLayout(6,1));
        this.setPreferredSize(new Dimension(gp.screenWidth, gp.screenHeight));
        this.setBackground(new Color(43, 147, 72));

        JLabel titleLabel = new JLabel("Pixel Plunder", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Monserrat", Font.BOLD, 56));

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Monserrat", Font.PLAIN, 26));
        startButton.addActionListener((e) -> {Main.getInstance().startGame();});
        startButton.setFocusable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setOpaque(false);
        buttonPanel.add(startButton);

        // for aligning the components
        this.add(new JLabel(""));
        this.add(titleLabel);
        this.add(buttonPanel);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }




    public JButton getStartButton() {
        return startButton;
    }
}

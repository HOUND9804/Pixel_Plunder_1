package main;

import javax.swing.*;

import javax.swing.*;

public class Main extends JFrame {
    private static Main instance;
    private GamePanel gamePanel;

    private Main() {
        setTitle("Pixel Plunder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        getContentPane().add(gamePanel);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void startGame() {
        gamePanel.startGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main.getInstance();
        });
    }
}


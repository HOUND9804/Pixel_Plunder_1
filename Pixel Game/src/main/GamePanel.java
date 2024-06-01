package main;

import Projectile.SuperProjectile;
import enemy.Enemy;
import enemy.EnemySetter;
import enemy.Lava_hound;
import entity.Player;
//import tile.Tile;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    final int originalTileSize =16;  // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    //WORLD SETTING
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth= tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;
    private long lastProjectileTime;
    public long projectileInterval = 1000 / 5;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();

    Thread gameThread;
    public CollisionChecker cChecker =new CollisionChecker(this);
    public TitleScreen titleScreen = new TitleScreen(this);
    public GameOverScreen gos=new GameOverScreen();
    public AssetSetter aSetter=new AssetSetter(this);
    public Player player = new Player(this, keyH);

    public EnemySetter e1=new EnemySetter(this);
    public Enemy enemies[]=new Enemy[3];
    public ArrayList<SuperProjectile>projectiles=new ArrayList<>();
    //obj
    public SuperObject obj[]=new SuperObject[10];


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        titleScreen.startButton = titleScreen.getStartButton();
        titleScreen.startButton.addActionListener(e -> startGame());
        add(gos,BorderLayout.CENTER);
        add(titleScreen, BorderLayout.CENTER);
        gos.setVisible(false);
    }
    public void setUpGame(){
        aSetter.setObject();
        e1.setEnemy();
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void startGame() {
        titleScreen.setVisible(false);
        setUpGame();
        startGameThread();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (!gameThread.interrupted()) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update() {
        if(player.health>0){
            player.update();
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastProjectileTime >= projectileInterval) {
                if (enemies[0].isPlayerInRange(this)) {
                    enemies[0].throwProjectile(this);
                }

                lastProjectileTime = currentTime;
            }
            for (int i = 0; i < projectiles.size(); i++) {
                SuperProjectile projectile = projectiles.get(i);
                projectile.update();
                if (projectile.isOutOfBounds(worldWidth, worldHeight)) {
                    projectiles.remove(i);
                    i--;
                }
            }
        }
        else{
            this.removeAll();
            gos.setVisible(true);
            this.revalidate();
            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (titleScreen.isVisible()) {
            // Draw title screen
            titleScreen.setVisible(true);
            return; // Don't draw game elements if title screen is visible
        } else {
            titleScreen.setVisible(false);
        }
        // Draw game elements
        tileM.draw(g2);
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        enemies[0].draw(g2, this);
        for (SuperProjectile projectile : projectiles) {
            projectile.draw(g2, this);
        }
        player.draw(g2);

        g2.dispose();
    }
}


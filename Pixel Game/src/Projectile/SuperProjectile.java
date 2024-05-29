package Projectile;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperProjectile {
    public BufferedImage image;
    public String name;
    public boolean collision =false;
    public int worldX,worldY;
    public double angle;
    public int speed=5;
    public Rectangle solidArea = new Rectangle(0,0,40,40);
    public int solidDefaultAreaX= 0;
    public int solidDefaultAreaY =0;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX= worldX - gp.player.worldX + gp.player.screenX;
        int screenY= worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize> gp.player.worldX- gp.player.screenX&& worldX - gp.tileSize< gp.player.worldX + gp.player.screenX&&
                worldY + gp.tileSize > gp.player.worldY- gp.player.screenY&& worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
    public void update() {
        worldX += speed * Math.cos(angle);
        worldY += speed * Math.sin(angle);
    }
    public boolean isOutOfBounds(int worldWidth, int worldHeight) {
        return (worldX < 0 || worldY < 0 || worldX > worldWidth || worldY > worldHeight);
    }
}

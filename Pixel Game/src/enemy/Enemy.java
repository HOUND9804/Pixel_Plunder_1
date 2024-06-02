package enemy;

import entity.Player;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public BufferedImage image;
    public String name;
    public boolean collision =false;
    public int worldX,worldY;
    public int projectileSpeed;
    public long lastShotTime;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
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
    public boolean isPlayerInRange(GamePanel gp) {
        double dx = gp.player.worldX - worldX;
        double dy = gp.player.worldY - worldY;
        double distance = Math.sqrt(dx*dx + dy*dy);
        int tileRadius = 4 * 16 * 3; // 4 tiles radius (16 pixels per tile, scaled by 3)
        return distance <= tileRadius;
    }

    public void throwProjectile(GamePanel gp) {
        double dx = gp.player.worldX - worldX;
        double dy = gp.player.worldY - worldY;
        double angle = Math.atan2(dy, dx);

    }

}
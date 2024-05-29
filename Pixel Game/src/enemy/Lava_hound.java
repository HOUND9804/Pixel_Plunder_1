package enemy;


import Projectile.FireBall;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Lava_hound extends Enemy{
    public double angle;
    public int x;
    public int y;
    public int speed=3;
    public Lava_hound() {
        name="Lava Hound";
        this.lastShotTime = System.currentTimeMillis();
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Enemy/enemy.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void throwProjectile(GamePanel gp){
        double dx = gp.player.worldX - worldX;
        double dy = gp.player.worldY - worldY;
        double angle = Math.atan2(dy, dx);
        FireBall fireBall = new FireBall(worldX,worldY,angle);
        gp.projectiles.add(fireBall);
    }
    public void update() {
        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }
}

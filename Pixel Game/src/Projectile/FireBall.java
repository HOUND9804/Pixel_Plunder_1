package Projectile;

import javax.imageio.ImageIO;
import java.io.IOException;

public class FireBall extends SuperProjectile{

    public FireBall(int x,int y,double angle){
        name="Fire ball";
        this.worldX=x;
        this.worldY=y;
        this.angle=angle;
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/projectiles/fire ball.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        worldX += speed * Math.cos(angle);
        worldY += speed * Math.sin(angle);
    }

}

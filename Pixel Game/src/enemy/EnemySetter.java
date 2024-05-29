package enemy;

import main.GamePanel;

public class EnemySetter {
    GamePanel gp;
    public EnemySetter(GamePanel gp){
        this.gp=gp;
    }
   public void setEnemy(){
       gp.enemies[0]=new Lava_hound();
       gp.enemies[0].worldX=8* gp.tileSize;
       gp.enemies[0].worldY=37* gp.tileSize;

   }
}

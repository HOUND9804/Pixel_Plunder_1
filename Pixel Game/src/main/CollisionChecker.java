package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp=gp;
    }

    public void checkTile(Entity entity) {
        int entityleftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityleftCol = entityleftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;
        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityleftCol = (entityleftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityleftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
        public int checkObject (Entity entity,Boolean player){
            int index = 999;
            for(int i=0;i<gp.obj.length;i++){
                if(gp.obj[i]!=null){
                    //get entity solid area
                    entity.solidArea.x= entity.worldX+entity.solidAreaDefaultX;
                    entity.solidArea.y= entity.worldY+entity.solidAreaDefaultY;
                    //get obj solid area
                    gp.obj[i].solidArea.x=gp.obj[i].worldX+gp.obj[i].solidDefaultAreaX;
                    gp.obj[i].solidArea.y=gp.obj[i].worldY+gp.obj[i].solidDefaultAreaY;
                    switch(entity.direction){
                        case"up":
                            entity.solidArea.y-=entity.speed;
                            if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                                if(gp.obj[i].collision=true){
                                    entity.collisionOn=true;
                                }
                                if(player==true){
                                    index=i;
                                }
                            }

                            break;
                        case"down":
                            entity.solidArea.y+=entity.speed;
                            if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                                if(gp.obj[i].collision=true){
                                    entity.collisionOn=true;
                                }
                                if(player==true){
                                    index=i;
                                }
                            }

                            break;
                        case"left":
                            entity.solidArea.x-=entity.speed;
                            if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                                if(gp.obj[i].collision=true){
                                    entity.collisionOn=true;
                                }
                                if(player==true){
                                    index=i;
                                }
                            }

                            break;
                        case"right":
                            entity.solidArea.x+=entity.speed;
                            if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision=true){
                                    entity.collisionOn=true;
                                }
                                if(player==true){
                                    index=i;
                                }
                            }
                            break;
                    }
                    entity.solidArea.x=entity.solidAreaDefaultX;
                    entity.solidArea.y=entity.solidAreaDefaultY;
                    gp.obj[i].solidArea.x=gp.obj[i].solidDefaultAreaX;
                    gp.obj[i].solidArea.y=gp.obj[i].solidDefaultAreaY;
                }
            }
            return index;
        }
    public int checkEnemy (Entity entity,Boolean player){
        int index = 999;
        for(int i=0;i<gp.enemies.length;i++){
            if(gp.enemies[i]!=null){
                //get entity solid area
                entity.solidArea.x= entity.worldX+entity.solidAreaDefaultX;
                entity.solidArea.y= entity.worldY+entity.solidAreaDefaultY;
                //get obj solid area
                gp.enemies[i].solidArea.x=gp.enemies[i].worldX+gp.enemies[i].solidDefaultAreaX;
                gp.enemies[i].solidArea.y=gp.enemies[i].worldY+gp.enemies[i].solidDefaultAreaY;
                switch(entity.direction){
                    case"up":
                        entity.solidArea.y-=entity.speed;
                        if(entity.solidArea.intersects(gp.enemies[i].solidArea)){
                            if(gp.enemies[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }

                        break;
                    case"down":
                        entity.solidArea.y+=entity.speed;
                        if(entity.solidArea.intersects(gp.enemies[i].solidArea)){
                            if(gp.enemies[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }

                        break;
                    case"left":
                        entity.solidArea.x-=entity.speed;
                        if(entity.solidArea.intersects(gp.enemies[i].solidArea)){
                            if(gp.enemies[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }

                        break;
                    case"right":
                        entity.solidArea.x+=entity.speed;
                        if(entity.solidArea.intersects(gp.enemies[i].solidArea)) {
                            if(gp.enemies[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }
                        break;
                }
                entity.solidArea.x=entity.solidAreaDefaultX;
                entity.solidArea.y=entity.solidAreaDefaultY;
                gp.enemies[i].solidArea.x=gp.enemies[i].solidDefaultAreaX;
                gp.enemies[i].solidArea.y=gp.enemies[i].solidDefaultAreaY;
            }
        }
        return index;
    }
    public int checkProjectile (Entity entity,Boolean player){
        int index = 999;
        for(int i=0;i<gp.projectiles.size();i++){
            if(gp.projectiles.get(i) !=null){
                //get entity solid area
                entity.solidArea.x= entity.worldX+entity.solidAreaDefaultX;
                entity.solidArea.y= entity.worldY+entity.solidAreaDefaultY;
                //get obj solid area
                gp.projectiles.get(i).solidArea.x= gp.projectiles.get(i).worldX+ gp.projectiles.get(i).solidDefaultAreaX;
                gp.projectiles.get(i).solidArea.y= gp.projectiles.get(i).worldY+ gp.projectiles.get(i).solidDefaultAreaY;
                switch(entity.direction){
                    case"up":
                        entity.solidArea.y-=entity.speed;
                        if(entity.solidArea.intersects(gp.projectiles.get(i).solidArea)){
                            if(gp.projectiles.get(i).collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }

                        break;
                    case"down":
                        entity.solidArea.y+=entity.speed;
                        if(entity.solidArea.intersects(gp.projectiles.get(i).solidArea)){
                            if(gp.projectiles.get(i).collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }

                        break;
                    case"left":
                        entity.solidArea.x-=entity.speed;
                        if(entity.solidArea.intersects(gp.projectiles.get(i).solidArea)){
                            if(gp.projectiles.get(i).collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }

                        break;
                    case"right":
                        entity.solidArea.x+=entity.speed;
                        if(entity.solidArea.intersects(gp.projectiles.get(i).solidArea)) {
                            if(gp.projectiles.get(i).collision=true){
                                entity.collisionOn=true;
                            }
                            if(player==true){
                                index=i;
                            }
                        }
                        break;
                }
                entity.solidArea.x=entity.solidAreaDefaultX;
                entity.solidArea.y=entity.solidAreaDefaultY;
                gp.projectiles.get(i).solidArea.x= gp.projectiles.get(i).solidDefaultAreaX;
                gp.projectiles.get(i).solidArea.y= gp.projectiles.get(i).solidDefaultAreaY;
            }
        }
        return index;
    }

}

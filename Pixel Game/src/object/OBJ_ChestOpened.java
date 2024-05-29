package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_ChestOpened extends SuperObject{
    public OBJ_ChestOpened(){
        name=" Open Chest";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/object/Chest_Opened.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

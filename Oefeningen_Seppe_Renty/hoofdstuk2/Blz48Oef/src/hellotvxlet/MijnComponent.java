package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import java.util.Timer;
import org.dvb.ui.*;

public class MijnComponent extends HComponent implements skyObserverInterface{
    
    int width = 100;
    int height = 100;
    int xpos = 100;
    int ypos = 0;
    Image imgjpg;
    HStaticText text;
    MediaTracker mtrack;
    Image mijnImage;
    
    HScene scene;
    
    public MijnComponent(int initXpos, int initYpos, int initWidth, int initHeight, String pictureName, HScene initScene){
        super();
        
       this.xpos=initXpos;
       this.ypos=initYpos;
       this.setLocation(xpos, ypos);
       
       scene = initScene;
       mijnImage =  this.getToolkit().getImage(pictureName);
       MediaTracker mt = new MediaTracker(this);
       mt.addImage(mijnImage, 1);
       try {
           mt.waitForAll();
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
 
       
       this.setBounds(0,ypos,initScene.getWidth(),initScene.getHeight());
        
            
    }
    
    public void update()
    {
       
       ypos-=10;
       this.setBounds(0,ypos,scene.getWidth(),scene.getHeight());
    }

    public void paint(Graphics g){
        g.drawImage(mijnImage, 0, 0, null);
    }
    
    

    

    
}
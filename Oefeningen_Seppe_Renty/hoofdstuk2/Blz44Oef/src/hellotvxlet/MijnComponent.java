package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent{
    
    int width = 100;
    int height = 100;
    int xpos = 100;
    int ypos = 100;
    Image imgjpg;
    HStaticText text;
    MediaTracker mtrack;
    
    HScene scene;
    
    public MijnComponent(int initXpos, int initYpos, int initWidth, int initHeight, String pictureName, HScene initScene){
        
        
        imgjpg = this.getToolkit().getImage(pictureName);
        mtrack = new MediaTracker(this);
        mtrack.addImage(imgjpg, 0);
        try{
            mtrack.waitForAll();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        this.scene = initScene;
        
      /* text = new HStaticText("Een tekst");
       text.setLocation(200,200);
       text.setSize(100,100);
       text.setBackground(new DVBColor(65,105,255,200));
       text.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
       scene.add(text);*/
       
  
        width = initWidth;
        height = initHeight;
        xpos = initXpos;
        ypos = initYpos;
        this.setBounds(xpos,ypos,width,height);
    }
    
    public MijnComponent()
    {
        this.setBounds(xpos, ypos, width, height);
    }
    
    public void paint(Graphics g){
        g.setColor(new DVBColor(65,105,255,200));
        g.fillRoundRect(0,0,100,100,50,50);
        
        g.setColor(new DVBColor(255,255,0,200));
        g.drawString("tekst1", 15,20);
        
        /*g.drawImage(imgjpg, 0,0,null);*/
    }
    
    public void moveUp()
    {
        ypos -= 10;
        this.setBounds(xpos, ypos, width, height);
 
    }
    
    public void moveDown()
    {
        ypos += 10;
        this.setBounds(xpos, ypos, width, height);
    }
    
    public void moveLeft()
    {
        xpos -= 10;
        this.setBounds(xpos, ypos, width, height);
    }
    
    public void moveRight()
    {
        xpos += 10;
        this.setBounds(xpos, ypos, width, height);
    }
    
    
}
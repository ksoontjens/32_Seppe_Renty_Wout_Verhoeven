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
    MediaTracker mtrack;
    
    public MijnComponent(int initXpos, int initYpos, int initWidth, int initHeight, String pictureName){
        
        
        imgjpg = this.getToolkit().getImage(pictureName);
        mtrack = new MediaTracker(this);
        mtrack.addImage(imgjpg, 0);
        try{
            mtrack.waitForAll();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
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
        /*g.setColor(new DVBColor(100,100,100,197));
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.drawString("tekst1", 15,20);*/
        g.drawImage(imgjpg, 0,0,null);
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
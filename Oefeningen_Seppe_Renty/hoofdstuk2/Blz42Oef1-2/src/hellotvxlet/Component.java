/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;



/**
 * 
 * @author student
 */
public class Component extends HComponent{
    
    int width;
    int height;
    private Image imgjpg;
    private MediaTracker mtrack;

    public Component(String bitmapnaam, int x, int y)
    {
        
        imgjpg = this.getToolkit().getImage("pizza1.jpeg");
        mtrack = new MediaTracker(this);
        mtrack.addImage(imgjpg, 0);
        
        try
        {
            mtrack.waitForAll();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        
       this.setBounds(x, y, imgjpg.getWidth(null), imgjpg.getWidth(null));
        
    }
    
    public void paint(Graphics g)
    {
      /* g.setColor(new DVBColor(100,100,100,179));
        g.fillRect(0,0,200,200);
        g.setColor(Color.white);
        g.drawString("tekst1", 15, 20);*/
        System.out.println("paint");
        g.drawImage(imgjpg, 0, 0, null);
        
    }

}

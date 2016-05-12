package hellotvxlet;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


    
    
public class HelloTVXlet implements Xlet
      
{
 SnakeXlet gxlet;
 XletContext ctx;

 
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
            // Start de GameXlet
          
            this.ctx=ctx;
            gxlet=new SnakeXlet(this);
           
           gxlet.initXlet(ctx);
            gxlet.startXlet();
    }

    public void pauseXlet() {

    }

    public void startXlet() throws XletStateChangeException {
    
    }
 
    public void respawn() throws XletStateChangeException
    {
        System.out.println("Restart Xlet!!!");
        gxlet.destroyXlet(true);
        gxlet=new SnakeXlet(this);
        gxlet.initXlet(ctx);
        gxlet.startXlet();
    }


    
}
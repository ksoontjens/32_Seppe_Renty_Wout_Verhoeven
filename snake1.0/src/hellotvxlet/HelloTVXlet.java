package hellotvxlet;

import hellotvxlet.*;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet
{

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
       
        
        scene.validate();
        scene.setVisible(true);
        
        Publisher pub = new Publisher();
        pub.setScene(scene);
        Timer t = new Timer();
        t.scheduleAtFixedRate(pub,0,10);
        
        for(int x=0;x<10;x++)
        {
            for(int y=0; y<5; y++)
            {
                SnakeComponent comp = new SnakeComponent(x*60, y*60);
                pub.register(comp);
                scene.add(comp);
            }
        }
        
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
    }
    
}
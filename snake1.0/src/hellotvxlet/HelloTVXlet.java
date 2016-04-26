package hellotvxlet;

import hellotvxlet.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.*;
import org.dvb.event.*;
import org.dvb.event.UserEventListener;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener
{
 SnakeChain snake;
 CoinHandler coinManager;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
       
        
        scene.validate();
        scene.setVisible(true);
        
        Publisher pub = new Publisher();
        pub.setScene(scene);
        Timer t = new Timer();
        t.scheduleAtFixedRate(pub,0,75);
        
         
           snake = new SnakeChain(scene, pub);
           pub.register(snake);

           coinManager = new CoinHandler(scene, snake);
           pub.register(coinManager);
        
         EventManager manager = EventManager.getInstance();
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        
        manager.addUserEventListener(this, repository);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
    }

    
    public void userEventReceived(UserEvent e) {
        
        if(e.getType()== KeyEvent.KEY_PRESSED)
        {
           
            switch(e.getCode()){
                case HRcEvent.VK_UP:
                    snake.moveUp();
                    
                    break;
                case HRcEvent.VK_DOWN:
                    
                    snake.moveDown();
                    
                    break;
                case HRcEvent.VK_LEFT:
                    
                    snake.moveLeft();
                    break;
                case HRcEvent.VK_RIGHT:
                    
                    snake.moveRight();
                    break;
            }
        }
        
    }
    
    
}
package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import org.dvb.event.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, UserEventListener{
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    
    private MijnComponent mc;
    
    
    public void initXlet(XletContext context) {
         this.actueleXletContext = context;
         
         if(debug){System.out.println("xlet initialiseren");}
        
        sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION,
            new HScreenDimension(1.0f,1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
         
        sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f,0.0f), org.havi.ui.HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
      
        mc = new MijnComponent(100,100,300,300, "pizza1.jpg", scene);
        scene.add(mc);
        
        EventManager manager = EventManager.getInstance();
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
        
       
    }
    
     public void startXlet() throws XletStateChangeException {
        scene.validate();
        scene.setVisible(true);
    }
     
    public void pauseXlet() {
        
    }

   

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
      
        if(unconditional){
            System.out.println("systeem moet beeindigt worden");
        }
        else{
           System.out.println("De mogelijk heid bestaat door het werpen van een exeptie de " +
                   "de xlet in leven te houden");
           throw new XletStateChangeException("laat me leven");
        }
        
        
    }

    public void userEventReceived(UserEvent e) {
        
        if(e.getType()== KeyEvent.KEY_PRESSED)
        {
           
            switch(e.getCode()){
                case HRcEvent.VK_UP:
                    System.out.println("up pressed");
                    mc.moveUp();
                    scene.repaint();
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("down pressed");
                    mc.moveDown();
                    scene.repaint();
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("left pressed");
                    mc.moveLeft();
                    scene.repaint();
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("right pressed");
                    mc.moveRight();
                    scene.repaint();
                    break;
            }
        }
        
    }

    


    


    
}
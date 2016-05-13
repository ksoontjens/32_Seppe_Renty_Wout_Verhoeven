package hellotvxlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HScreenDimension;
import org.havi.ui.HScreenPoint;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


    
    
public class HelloTVXlet implements Xlet, HActionListener
      
{
    HStaticText scoreLabel;
 SnakeXlet gxlet;
 XletContext ctx;
 private HScene scene;
 private HSceneTemplate sceneTemplate = new HSceneTemplate();
 private HTextButton startButton;

 
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
       
        HSceneFactory.getInstance().dispose(scene);
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
            // Start de GameXlet
          
            this.ctx=ctx;
            gxlet=new SnakeXlet(this);
           
            sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION,
            new HScreenDimension(1.0f,1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
            sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f,0.0f), org.havi.ui.HSceneTemplate.REQUIRED);
            scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
             
            startButton = new HTextButton("Start Game");
            startButton.setLocation(100,100);
            startButton.setSize(500,100);
            startButton.setBackground(new DVBColor(255,255,255,179));
            startButton.setBackgroundMode(HVisible.BACKGROUND_FILL);     
            
            startButton.setActionCommand("startGame");
            startButton.addHActionListener(this);
            scene.add(startButton);
            startButton.requestFocus();
    }

    public void pauseXlet() {

    }

    public void startXlet() throws XletStateChangeException {
       scene.validate();
       scene.setVisible(true);
    }
 
    public void respawn(int score) throws XletStateChangeException
    {
        System.out.println("Restart Xlet!!!" + score);
        gxlet.destroyXlet(true);
        gxlet=new SnakeXlet(this);
        
       
        
        this.initXlet(ctx);
        this.startXlet();
        
        
    }

    public void actionPerformed(ActionEvent arg0) {
        
        String answer = arg0.getActionCommand();
        
        System.out.println(answer);
        
        if(answer.equals("startGame")) {
            try {

                gxlet.initXlet(ctx);
                gxlet.startXlet();
            } catch (XletStateChangeException ex) {
                ex.printStackTrace();
            }
            
        }
        
    }


    
}
package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.*;
import org.havi.ui.*;



public class HelloTVXlet implements Xlet{
    
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
        
      
    SterrenPubslisher pub = new SterrenPubslisher();
       
      
       
        Timer t = new Timer();
        t.scheduleAtFixedRate(pub,0,80);
        pub.setScene(scene);
       skySpawner spawner = new skySpawner(scene, pub);
        pub.register(spawner);
              
      
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

    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;
import org.havi.ui.HScene;

/**
 *
 * @author student
 */
public class skySpawner implements skyObserverInterface{
    
    HScene scene;
    
    SterrenPubslisher publisher;
    MijnComponent firstComp;
    
    ArrayList skyen = new ArrayList();
    
    boolean newCompCreated = false;
    
    
    public skySpawner(HScene initScene, SterrenPubslisher initPublisher)
    {
        this.scene = initScene;
        this.publisher = initPublisher;
        firstComp = new MijnComponent(0,0,300,300, "sky.jpg", scene);
        scene.add(firstComp);
        
        skyen.add(firstComp);
        
        publisher.register(firstComp);
        
        System.out.println(scene.getHeight() + " " + scene.getWidth());
    }
    
    public void update() {
        
        
            MijnComponent comp = (MijnComponent) skyen.get(skyen.size()-1);
            if((comp.getY())<0)
            {
                
                    newCompCreated = true;
                    MijnComponent newComp = new MijnComponent(0,scene.getHeight()-10,300,300, "sky.jpg", scene);
                    scene.add(newComp);
                    skyen.add(newComp);
                    publisher.register(newComp);
               
            }
            
            for(int i  =0; i<skyen.size(); i++)
            {
                MijnComponent otherComp = (MijnComponent) skyen.get(i);
                
                int height = otherComp.getY() + scene.getHeight();
                if( height < 0)
                {
                    scene.remove(otherComp);
                    publisher.unregister(otherComp);
                }
            }
            
          
        
            
        
        
       
    }

}

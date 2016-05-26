/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;
import java.util.TimerTask;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;

/**
 *
 * @author student
 */
public class SterrenPubslisher extends TimerTask{

    int counter = 0;
    HScene scene;
    ArrayList mijnComponenten = new ArrayList();
    

    
    
    public void run() {
        int teller = 0;
        if(mijnComponenten.size()>0)
        {
             for( int i = 0; i<mijnComponenten.size();i++)
          {
                 teller++;
            ((skyObserverInterface)mijnComponenten.get(i)).update();
          }       
          
        }

        scene.repaint();
    }
    
    public void register(skyObserverInterface newComp)
    {
        mijnComponenten.add(newComp);
    }
    
    public void unregister(skyObserverInterface remComp)
    {
        mijnComponenten.remove(remComp);
    }
    public void setScene(HScene initscene)
    {
        this.scene = initscene;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;
import java.util.TimerTask;
import org.havi.ui.HScene;

/**
 *
 * @author student
 */
public class Publisher extends TimerTask implements PublisherInterface{
    
    //Lijst met al de geregistreerde Observers
    
    ArrayList observerdb = new ArrayList();
    int tijd  = 0;
    HScene scene;
    public void setScene(HScene s)
    {
        scene=s;
    }
    
    
    public void run() //Deze methode wordt door de timer aangestuurd 
    {
        
       tijd++;
    
      for( int i = 0; i<observerdb.size();i++)
      {
            ((ObserverInterface)observerdb.get(i)).update(tijd);
      }
       
       scene.repaint();
    }

    public void register(ObserverInterface observer) {
        observerdb.add(observer);
    }

    public void unregister(ObserverInterface observer) {
        observerdb.remove(observer);
    }

    

    
    

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Image;
import org.havi.ui.HIcon;

/**
 *
 * @author student
 */
public abstract class Sprite extends HIcon implements ObserverInterface
{
    Image mijnimage;
    int x,y;
    
    public Sprite(int x, int y)
    {
       super(); //roept contructor op van HICOn (superklasse) dit moet op eerste regel
       this.x=x;
       this.y=y;
       this.setLocation(x, y);
       this.setBordersEnabled(false);
        
    }

    public abstract void update(int tijd);
        
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.MediaTracker;

/**
 *
 * @author student
 */
public class SnakeComponent extends Sprite
{
    public SnakeComponent(int x, int y)
    {
       super(x,y); //roep contrstructor van sprite aan
       this.setSize(50,50);
       mijnimage=  this.getToolkit().getImage("pizza1.jpg");
       MediaTracker mt = new MediaTracker(this);
       mt.addImage(mijnimage, 1);
        try {

            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
       
      //this.setSize(mijnimage.getWidth(this), mijnimage.getHeight(this));
       this.setGraphicContent(mijnimage, this.NORMAL_STATE);
    }

    public void update(int tijd)
    {
        y+=2;
        this.setLocation(x,y);
    }
    
    
}

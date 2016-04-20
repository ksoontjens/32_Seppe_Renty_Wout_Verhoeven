/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */


import java.util.ArrayList;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;

public class SnakeChain extends HComponent implements ObserverInterface{

    HScene scene;
    Publisher pub;
    ArrayList chain = new ArrayList();
    int chainLength = 100;
    
    boolean moveDown = false;
    boolean moveLeft = false;
    boolean moveRight = false;
    boolean moveUp = false;
    
    SnakeComponent compie;
    public SnakeChain(HScene initScene, Publisher initPub)
    {
        scene = initScene;
        pub = initPub;
        
        compie = new SnakeComponent(60,60);
        chain.add(compie);
       
    }
    
    public void move(int tijd)
    {
        
            if(chain.size() >= chainLength)
            {
                
                scene.remove((HComponent)chain.get(0));
                chain.remove(0);
                
            }
            
            SnakeComponent lastChain = (SnakeComponent) chain.get(chain.size()-1);
            int x = lastChain.getX();
            int y = lastChain.getY();
            int width = lastChain.getWidth();
            int height = lastChain.getHeight();
            SnakeComponent comp;
            if(moveDown)
            {
            comp = new SnakeComponent(x, (y+height));
            System.out.println("down");
            }
            else if(moveUp)
            {
            comp = new SnakeComponent(x, (y-height));
            System.out.println("up");
            }
            
            else if(moveLeft)
            {
            comp = new SnakeComponent((x-width), y);
            System.out.println("left");
            }
            
            else if(moveRight)
            {
            comp = new SnakeComponent((x+width), y);
            System.out.println("right");
            }
            
           
            else
            {
            comp = new SnakeComponent(x, (y+height));
            }
            
            chain.add(comp);
            updateChain();
           
    }
    
   
    
    
    
    public void updateChain()
    {
        for(int i = 0; i < chain.size(); i++)
        {
            /*pub.register((ObserverInterface) chain.get(i));*/
            scene.add((HComponent)chain.get(i));
        }
    }

    public void update(int tijd) {
        
        move(tijd);
        
        scene.repaint();
    }
    
     public void moveUp()
    {
         if(!moveDown)
         {
        moveUp = true;
        moveLeft = false;
        moveRight = false;
        moveDown = false;
         }
    }
    
    public void moveDown()
    {
        if(!moveUp)
        {
        moveUp = false;
        moveLeft = false;
        moveRight = false;
        moveDown = true;
        }
    }
    public void moveLeft()
    {
        if(!moveRight)
        {
        moveUp = false;
        moveLeft = true;
        moveRight = false;
        moveDown = false;
        }
    }
    public void moveRight()
    {
        if(!moveLeft)
        {
        moveUp = false;
        moveLeft = false;
        moveRight = true;
        moveDown = false;
        }
    }
    
}

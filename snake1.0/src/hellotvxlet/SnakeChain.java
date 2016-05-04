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

public class SnakeChain implements ObserverInterface{

    HScene scene;
    Publisher pub;
    ArrayList chain = new ArrayList();
    int chainLength = 4;    
    boolean moveDown = true;
    boolean moveLeft = false;
    boolean moveRight = false;
    boolean moveUp = false;
    
    boolean gameOver = false;
    String componentImage = "snakePart.png";
    
    SnakeComponent firstComp;
    public SnakeChain(HScene initScene, Publisher initPub)
    {
        scene = initScene;
        pub = initPub;
        firstComp = new SnakeComponent(60,60, componentImage);
        chain.add(firstComp);
       
    }
    
    public void restart()
    {
        removeChain();
        chain = new ArrayList();
        chainLength = 4;
        moveDown = true;
        moveLeft = false;
        moveRight = false;
        moveUp = false;
        gameOver = false;
        
        firstComp = new SnakeComponent(60,60, componentImage);
        chain.add(firstComp);
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
            
            int sceneWidth = scene.getWidth();
            int sceneHeight = scene.getHeight();
            
            SnakeComponent comp;
            if(moveDown)
            {
                if(y>=(sceneHeight-height))
                {
                    comp = new SnakeComponent(x, 0,componentImage);
                }
                else
                {
                    comp = new SnakeComponent(x, (y+height),componentImage);
                }
            
            }
            else if(moveUp)
            {
                if(y<=0)
                {  
                    comp = new SnakeComponent(x, (580-height),componentImage);
                }
                else
                {    
                 comp = new SnakeComponent(x, (y-height), componentImage);
                }
            
            }
            
            else if(moveLeft)
            {
                if(x<=0)
                {
                    comp = new SnakeComponent((sceneWidth-width), y, componentImage);
                    System.out.println(sceneWidth);
                }
                
                else
                {
                    comp = new SnakeComponent((x-width), y, componentImage);
                }
            
            }
            
            else if(moveRight)
            {
                if(x>=(sceneWidth-width))
                {
                    
                    comp = new SnakeComponent((0), y, componentImage);
                    System.out.println(sceneWidth);
                }
                else
                {
                    
                    comp = new SnakeComponent((x+width), y, componentImage);
                }
            
            }
            
           
            else
            {
            comp = new SnakeComponent(x, (y+height), componentImage);
            }
            
            chain.add(comp);
            updateChain();
           
    }
    
    public void checkTailCollision()
    {
        SnakeComponent head = (SnakeComponent)chain.get(chain.size()-1);
        for(int i = 0; i< (chain.size()-1); i++)
        {
            SnakeComponent tailComp = (SnakeComponent)chain.get(i);
            if(head.getBounds().intersects(tailComp.getBounds()))
            {
                System.out.println("Hit");
                gameOver = true;
            }
        }
    }
    
   
    public void removeChain()
    {
        for(int i = 0; i < chain.size(); i++)
        {
            /*pub.register((ObserverInterface) chain.get(i));*/
            scene.remove((HComponent)chain.get(i));
        }
    }
    
    
    
    public void updateChain()
    {
        for(int i = 0; i < chain.size(); i++)
        {
            /*pub.register((ObserverInterface) chain.get(i));*/
            scene.add((HComponent)chain.get(i));
        }
    }

    public void update(int tijd) 
    {
        if(!gameOver)
        {
        move(tijd);
        checkTailCollision();
        }
        
    }
    
    public void pointUp()
    {
        chainLength+=1;
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

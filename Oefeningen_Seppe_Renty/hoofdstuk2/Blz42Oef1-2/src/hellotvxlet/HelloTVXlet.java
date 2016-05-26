package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.dvb.ui.*;
import java.awt.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, HActionListener{
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private HSceneTemplate sceneTemplate = new HSceneTemplate();
    private HStaticText tekstLabel;
    private HStaticText answerLabel;
    private HTextButton button1, button2, button3, button4, button5;
    
    
    
    public void initXlet(XletContext context) {
         this.actueleXletContext = context;
         
         if(debug){System.out.println("xlet initialiseren");}
        
        sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION,
            new HScreenDimension(1.0f,1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
         
        sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f,0.0f), org.havi.ui.HSceneTemplate.REQUIRED);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
       tekstLabel = new HStaticText("Met hoeveel letters spel je 'koe'?");
       tekstLabel.setLocation(0,0);
       tekstLabel.setSize(500,100);
       tekstLabel.setBackground(new DVBColor(0,0,0,255));
       tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
       scene.add(tekstLabel);
       
       
       button5 = new HTextButton("Hulplijn aanvragen");
       button5.setLocation(400,100);
       button5.setSize(200,100);
       button5.setBackground(new DVBColor(255,255,255,179));
       button5.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
      
       
       
       button1 = new HTextButton("1");
       button1.setLocation(200,100);
       button1.setSize(100,100);
       button1.setBackground(new DVBColor(255,255,255,179));
       button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       
        button2 = new HTextButton("2");
       button2.setLocation(300,100);
       button2.setSize(100,100);
       button2.setBackground(new DVBColor(255,255,255,179));
       button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
        button3 = new HTextButton("3");
       button3.setLocation(200,200);
       button3.setSize(100,100);
       button3.setBackground(new DVBColor(255,255,255,179));
       button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
        button4 = new HTextButton("4");
       button4.setLocation(300,200);
       button4.setSize(100,100);
       button4.setBackground(new DVBColor(255,255,255,179));
       button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
       
       
       
       button1.setFocusTraversal(button3, button3, button5, button2);
       button2.setFocusTraversal(button4, button4, button1, button5);
       button5.setFocusTraversal(null, null, button2, button1);
       button3.setFocusTraversal(button1, button1, button4, button4);
       button4.setFocusTraversal(button2, button2, button3, button3);
       
       button1.setActionCommand("knop1Klik");
       button2.setActionCommand("knop2Klik");
        button3.setActionCommand("knop3Klik");
       button4.setActionCommand("knop4Klik");
       button5.setActionCommand("knop5Klik");
       
       button1.addHActionListener(this);
       button2.addHActionListener(this);
       button3.addHActionListener(this);
       button4.addHActionListener(this);
       button5.addHActionListener(this);
       
       
               
       scene.add(button1);
       scene.add(button2);
       scene.add(button3);
       scene.add(button4);
       scene.add(button5);
        
       
       button1.requestFocus();
        
       
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

    public void actionPerformed(ActionEvent arg0) {
       
        
        String answer = arg0.getActionCommand();
        
         System.out.println(answer);
        
        if(answer.equals("knop1Klik")) {
            falseAnswer();
        }
        else if(answer.equals("knop2Klik")) {
            falseAnswer();
        }
        else if(answer.endsWith("knop3Klik")){
           
              correctAnswer();
        }
        else if(answer.equals("knop4Klik")) {
           falseAnswer();
        }
         
         else if(answer.equals("knop5Klik")) {
            deleteTwo();
        }
         
         
         
    }
    
    public void correctAnswer()
    {
       System.out.println("correct");
        answerLabel = new HStaticText("correct");
        answerLabel.setLocation(200,300);
        answerLabel.setSize(200,100);
      
        answerLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        answerLabel.setBackground(new DVBColor(0,0,0,255));
        scene.add(answerLabel);
        scene.repaint();
       
    }

    private void deleteTwo() {
        scene.remove(button2);
        scene.remove(button4);
        scene.repaint();
    }

    private void falseAnswer() {
        System.out.println("false");
        answerLabel = new HStaticText("false");
        answerLabel.setLocation(200,300);
        answerLabel.setSize(200,100);
      
        answerLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        answerLabel.setBackground(new DVBColor(0,0,0,255));
        scene.add(answerLabel);
        scene.validate();
        scene.repaint();
       
    }

    


    
}
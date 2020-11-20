/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oval1;

import java.applet.Applet;
import static java.awt.Color.RED;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Oval1 extends Applet implements Runnable {
  
    public  int xsteps=5;
    public  int ysteps=5 ;
   
    public   int  x=20;
    public   int y=20;
    Thread th ;

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        th=new Thread(this);
        th.start();

    }
    
    public void paint(Graphics g)
    {
        g.getColor();
        g.drawOval(x, y, 20, 20);
        g.fillOval(x, y, 20, 20);
        
    }
    

    @Override
    public void run() {
        while(true)
        {
            x+=xsteps;
            y+=ysteps;
            if(y<=0){ ysteps*=-1;}
              if(y>=getHeight()){ ysteps*=-1;}
                if(x<=0){ xsteps*=-1;}
                  if(x>=getWidth()){ xsteps*=-1;}
          
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Oval1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    }

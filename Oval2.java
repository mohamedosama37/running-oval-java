/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oval;

import java.applet.Applet;

import java.applet.Applet;
import java.awt.Button;
import static java.awt.Color.RED;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


public class Oval2 extends Applet implements Runnable {
 public  int xsteps=5;
    public  int ysteps=5 ;
   
    public   int  x=20;
    public   int y=20;
    Thread th ;
    int z;
  Button b1;
  Button b2;
  
    public void init() {
     super.init(); //To change body of generated methods, choose Tools | Templates.
        th=new Thread(this);
        
            b1 = new Button ("stop ");
        b1.addActionListener(
                new ActionListener (){
                   public void actionPerformed (ActionEvent e){
                    th.suspend();
                       repaint();
                   }
                }
                
        );
        add(b1);
        
        
        
         b2 = new Button ("active");
        b2.addActionListener(
                new ActionListener (){
                   public void actionPerformed (ActionEvent e){
                       if (th.getState()== Thread.State.NEW)
                       {th.start();}
                        if (th.getState()== Thread.State.TIMED_WAITING)
                        {th.resume();}
                       repaint();
                   }
                }
                
        );
        add(b2);
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
                Logger.getLogger(Oval2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    }


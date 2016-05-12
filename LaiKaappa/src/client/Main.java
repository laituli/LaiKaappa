/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lai
 */
public class Main {
    
    
    public static void main(String[] args){
        start();
        //asetukset
        //listeners
        
        try {
            Robot robot = new Robot();
            Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            robot.createScreenCapture(rect);
            
        } catch (AWTException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void _main_(String[] args){
        _start_();
    }
    
    void _start_(){
        
    }
    
    
}

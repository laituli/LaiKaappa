package toiminnot.kuvanotot;


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laituli
 */
public class KuvanOttaja {
    private KuvanOttaja(){
    }
    
    public static BufferedImage otaKuva(int x, int y, int leveys, int korkeus) {
        try {
            System.out.println("ota screenshot");
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(x, y, leveys, korkeus));
            System.out.println("otettu screenshot");
            return image;
        } catch (AWTException ex) {
            Logger.getLogger(KuvanOttaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

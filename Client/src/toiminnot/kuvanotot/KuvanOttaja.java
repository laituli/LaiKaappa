package toiminnot.kuvanotot;

import asetustiedosto.Asetus;
import asetustiedosto.AsetusUtil;
import asetustiedosto.BinaryAsetus;
import asetustiedosto.IntAsetus;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;
import toiminnot.Odottaja;
import toiminnot.Piilottaja;

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

    private KuvanOttaja() {
    }
    
    public static void register() {
    }

    public static BufferedImage otaKuva(int x, int y, int leveys, int korkeus) {
        Piilottaja.piilota();
        Odottaja.odota();
        BufferedImage image = null;
        try {
            System.out.println("ota screenshot");
            image = new Robot().createScreenCapture(new Rectangle(x, y, leveys, korkeus));
            System.out.println("otettu screenshot");
        } catch (AWTException ex) {
            Logger.getLogger(KuvanOttaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        Piilottaja.palauta();
        return image;
    }
}

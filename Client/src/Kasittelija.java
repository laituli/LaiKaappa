/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Laituli
 */
public class Kasittelija {

    public BufferedImage otaKuva(int x, int y, int leveys, int korkeus) {
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(x, y, leveys, korkeus));
            return image;
        } catch (AWTException ex) {
            Logger.getLogger(Kasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void tallennaKuva(BufferedImage image, String name) {
        try {
            File file = new File(polku + "/" + name + ".png");
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(Kasittelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tallennaKuva(BufferedImage image) {
        tallennaKuva(image, generoiNimi());
    }

    public void lahetaKuva(BufferedImage image) {
        throw new UnsupportedOperationException("ei voi lähetä viel mtn");
    }
    
    private String polku = "savedImage";

    public boolean setPolku(String path) {
        if (tsekkaaPolunNimi(path)) {
            this.polku = path;
            return true;
        }
        return false;
    }

    public String getPolku() {
        return polku;
    }

    public String generoiNimi() {
        return Long.toHexString(System.nanoTime());
    }

    public boolean tsekkaaPolunNimi(String pathName) {
        return true;
    }



}

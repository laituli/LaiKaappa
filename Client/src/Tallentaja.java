
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laituli
 */
public class Tallentaja {
    
    public void tallennaKuva(BufferedImage image, String name) {
        try {
            File file = new File(polku + "/" + name + ".png");
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(Tallentaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tallennaKuva(BufferedImage image) {
        tallennaKuva(image, generoiNimi());
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

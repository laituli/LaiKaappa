/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palvelin;

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
public class Tallentaja {
    private String polku = "savedImage";
    public void tallennaKuva(BufferedImage image, String name) {
        System.out.println("koetetaan tallentaa");
        try {
            File file = new File(polku + "/" + name + ".png");
            ImageIO.write(image, "png", file);
            System.out.println("tallentaminen onnistuu");
        } catch (IOException ex) {
            System.out.println("tallentaminen epäonnistuu");
            Logger.getLogger(Tallentaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tallennaKuva(BufferedImage image) {
        tallennaKuva(image, generoiNimi());
    }
    
    private String generoiNimi(){
        return Long.toHexString(System.nanoTime());
    }
}

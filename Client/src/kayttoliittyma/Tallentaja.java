package kayttoliittyma;


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
    public Tallentaja() {
        kansio = new File(System.getProperty("user.home") + File.separator + "laikaappa_savedImage");
        kansio.mkdir();
    }
    public void tallennaKuva(BufferedImage image, String name) {
        System.out.println("koetetaan tallentaa");
        try {
            File file = new File(kansio, name+".png");
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
    private File kansio;

    public String generoiNimi() {
        return Long.toHexString(System.nanoTime());
    }
}

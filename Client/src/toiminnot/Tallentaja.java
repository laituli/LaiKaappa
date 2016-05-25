package toiminnot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

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

    private Tallentaja() {
    }
    private static File kansio;

    public static void register() {
        kansio = new File(System.getProperty("user.home") + File.separator + "laikaappa_savedImage");
        kansio.mkdir();
    }

    private static String generoiNimi() {
        return Long.toHexString(System.nanoTime());
    }

    public static void tallennaKuva(BufferedImage image) {
        tallennaKuva(image, generoiNimi());
    }

    public static void tallennaKuva(BufferedImage image, String name) {
        SwingUtilities.invokeLater(
                new TallentajaRun(image, name)
        );
    }

    private static class TallentajaRun implements Runnable {

        private BufferedImage image;
        private String name;

        private TallentajaRun(BufferedImage image, String name) {
            this.image = image;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("koetetaan tallentaa");
            try {
                File file = new File(kansio, name + ".png");
                ImageIO.write(image, "png", file);
                System.out.println("tallentaminen onnistuu");
            } catch (IOException ex) {
                System.out.println("tallentaminen epäonnistuu");
                Logger.getLogger(Tallentaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

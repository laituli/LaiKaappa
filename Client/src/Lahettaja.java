
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
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
public class Lahettaja {

    private String osoite = "88.195.156.217";
    private int port = 8888;

    public void lahetaKuva(BufferedImage image) {
        try {
            Socket socket = new Socket(osoite, port);
            ImageIO.write(image, "png", socket.getOutputStream());
            System.out.println("kuva lähetetty");
        } catch (IOException ex) {
            System.out.println("lahettaminen epäonnistuu");
            Logger.getLogger(Lahettaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

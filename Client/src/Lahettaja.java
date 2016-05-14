
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sun.swing.PrintColorUIResource;

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
    private final int port = 30101;

    public void lahetaKuva(BufferedImage image) {
        try {
            System.out.println("luo socket");
            Socket socket = new Socket(osoite, port);
            System.out.println("luotu socket");
            ImageIO.write(image, "png", socket.getOutputStream());
            System.out.println("kuva lähetetty");
            socket.close();
        } catch (IOException ex) {
            System.out.println("lahettaminen epäonnistuu");
            Logger.getLogger(Lahettaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

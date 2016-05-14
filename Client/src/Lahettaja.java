
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
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

    public void lahetaKuva(BufferedImage image, Socket socket) throws IOException {
        ImageIO.write(image, "png", socket.getOutputStream());
        System.out.println("kuva lähetetty");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palvelin;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Laituli
 */
public class Vastaanottaja {
    
    public BufferedImage vastaanottaa(Socket socket) {
        System.out.println("koetetaan vastaanottaa kuva");
        try {
            InputStream stream = socket.getInputStream();
            BufferedImage image = ImageIO.read(stream);
            System.out.println("vastaanotto onnistui");
            return image;
        } catch (IOException ex) {
            System.out.println("vastaanotto epäonnistui");
            Logger.getLogger(Vastaanottaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

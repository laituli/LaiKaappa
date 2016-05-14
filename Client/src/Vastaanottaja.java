
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laituli
 */
public class Vastaanottaja {

    public String vastaanottaa(Socket socket){    
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("koetetaan vastaanottaa viesti");
            String viesti = br.readLine();
            System.out.println("viestin vastaanotto onnistuu");
            br.close();
            return viesti;
        } catch (IOException ex) {
            System.out.println("viestin vastaanotto epäonnistuu");
            Logger.getLogger(Vastaanottaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

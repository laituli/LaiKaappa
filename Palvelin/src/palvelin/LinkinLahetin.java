/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palvelin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laituli
 */
public class LinkinLahetin {

    private final String aloitus = "http://88.195.156.217/laikuvat/";

    public void lahetaLink(String name, Socket socket) {
        try {
            String link = getLink(name);
            System.out.println("koetetaan lähettää linkki");
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write(link);
            System.out.println("linkin lähetys onnistuu");
        } catch (IOException ex) {
            System.out.println("linkin lähetys epäonnistuu");
            Logger.getLogger(LinkinLahetin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getLink(String name) {
        return aloitus + name;
    }

    public void lahetaError(Socket socket) {
        PrintWriter pw = null;
        System.out.println("koetetaan lähettää error");
        try {
            pw = new PrintWriter(socket.getOutputStream());
            pw.write(errorViesti());
            System.out.println("error lähetys onnistuu");
        } catch (IOException ex) {
            System.out.println("error lähetys epäonnistuu");
            Logger.getLogger(LinkinLahetin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    private String errorViesti() {
        return "kuvan tallennus palvelimella epäonnistui\n";
    }
}

package yhteys;

import muu_toiminnot.Kopioija;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Kommunikaattori {

    private static final String osoite = "88.195.156.217";
    private static final int port = 30101;
    private static Lahettaja lahettaja;
    private static Vastaanottaja vastaanottaja;
    private static final String errorViesti = "kuvan tallennus palvelimella epäonnistui\n";

    private Kommunikaattori() {

    }

    public static void register() {
        lahettaja = new Lahettaja();
        vastaanottaja = new Vastaanottaja();
    }

    public static void kommunikoiKuva(BufferedImage image) {
        SwingUtilities.invokeLater(new KommunikoiRun(image));
    }

    private static class KommunikoiRun implements Runnable {

        private BufferedImage image;

        public KommunikoiRun(BufferedImage image) {
            this.image = image;
        }

        @Override
        public void run() {
            try {
                System.out.println("luo socket");
                Socket socket = new Socket(osoite, port);
                System.out.println("luotu socket");
                lahettaja.lahetaKuva(image, socket);
                String viesti = vastaanottaja.vastaanottaa(socket);
                if (viesti == null || viesti.equals(errorViesti)) {
                    System.out.println("ei kopioida");
                } else {
                    Kopioija.kopioi(viesti);
                }
                socket.close();
            } catch (IOException ex) {
                System.out.println("lahettaminen epäonnistuu");
                Logger.getLogger(Kommunikaattori.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

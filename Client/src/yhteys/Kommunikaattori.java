package yhteys;


import kayttoliittyma.Kopioija;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
public class Kommunikaattori {

    private String osoite = "88.195.156.217";
    private final int port = 30101;
    private Lahettaja lahettaja;
    private Vastaanottaja vastaanottaja;
    private Kopioija kopioija;

    public Kommunikaattori(Kopioija kopioija) {
        lahettaja = new Lahettaja();
        vastaanottaja = new Vastaanottaja();
        this.kopioija = kopioija;
    }

    public void kommunikoiKuva(BufferedImage image) {
        try {
            System.out.println("luo socket");
            Socket socket = new Socket(osoite, port);
            System.out.println("luotu socket");
            lahettaja.lahetaKuva(image, socket);
            String viesti = vastaanottaja.vastaanottaa(socket);
            if (viesti == null || viesti.equals(errorViesti())) {
                System.out.println("ei kopioida");
            } else {
                kopioija.kopioi(viesti);
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println("lahettaminen epäonnistuu");
            Logger.getLogger(Kommunikaattori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String errorViesti() {
        return "kuvan tallennus palvelimella epäonnistui\n";
    }
}

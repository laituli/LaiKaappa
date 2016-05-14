/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palvelin;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Laituli
 */
public class Palvelin {

    public Vastaanottaja getVastaanottaja() {
        return vastaanottaja;
    }

    public Tallentaja getTallentaja() {
        return tallentaja;
    }

    public LinkinLahetin getLinkinLahetin() {
        return linkinLahetin;
    }

    public Palvelin(Vastaanottaja vastaanottaja, Tallentaja tallentaja, LinkinLahetin linkinLahetin) {
        this.vastaanottaja = vastaanottaja;
        this.tallentaja = tallentaja;
        this.linkinLahetin = linkinLahetin;
    }

    private Vastaanottaja vastaanottaja;
    private Tallentaja tallentaja;
    private LinkinLahetin linkinLahetin;
    public final int port = 30101;

    public void kaynnista() throws IOException {
        ServerSocket palvelinsocket = new ServerSocket(port, 10);
        System.out.println("palvelin kaynnistyy");
        while (true) {
            System.out.println("odota socket");
            Socket socket = palvelinsocket.accept();
            System.out.println("get socket");
            BufferedImage image = vastaanottaja.vastaanottaa(socket);
            if (image != null) {
                String kuvanNimi = tallentaja.tallennaKuva(image);
                if (kuvanNimi != null) {
                    linkinLahetin.lahetaLink(kuvanNimi, socket);
                } else {
                    linkinLahetin.lahetaError(socket);
                }
            }
            socket.close();
            System.out.println("close socket");
        }
    }
}

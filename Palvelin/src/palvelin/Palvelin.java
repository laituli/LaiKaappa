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

    public final int port;
    private Vastaanottaja vastaanottaja;
    private Tallentaja tallentaja;

    public Vastaanottaja getVastaanottaja() {
        return vastaanottaja;
    }

    public Tallentaja getTallentaja() {
        return tallentaja;
    }

    public Palvelin(Vastaanottaja vastaanottaja, Tallentaja tallentaja) {
        //korjaa
        //korjaa
        //korjaa
        port = 2345;
        //korjaa
        //korjaa
        //korjaa
        this.vastaanottaja = vastaanottaja;
        this.tallentaja = tallentaja;
    }

    public void kaynnista() throws IOException {
        ServerSocket palvelinsocket = new ServerSocket(port, 10);
        System.out.println("palvelin kaynnistyy");
        while (true) {
            Socket socket = palvelinsocket.accept();
            BufferedImage image = vastaanottaja.vastaanottaa(socket);
            if(image!=null){
                tallentaja.tallennaKuva(image);
            }
        }
    }
}

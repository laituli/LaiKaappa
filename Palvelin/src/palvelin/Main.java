/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palvelin;

import java.io.IOException;

/**
 *
 * @author Laituli
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("start");
        new Palvelin(new Vastaanottaja(), new Tallentaja()).kaynnista();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lai
 */
public class TulosteTiedosto {

    public static final String nimi = "output.txt";

    private TulosteTiedosto() {
    }

    private static StringBuilder sb;

    public static void register() {
        sb = new StringBuilder();
    }

    public static void println(Object o) {
        sb.append((String) o).append("\n");
    }

    public static void print(Object o) {
        sb.append((String) o);
    }
    
    public static void close(){
        try {
            FileWriter fw = new FileWriter(nimi, false);
            fw.append(sb);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(TulosteTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

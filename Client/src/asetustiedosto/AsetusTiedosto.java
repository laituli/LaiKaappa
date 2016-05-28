package asetustiedosto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lai
 */
public class AsetusTiedosto {

    public static final String nimi = "client_asetukset";

    public static List<String> rivit = null;

    public static final void lue() {
        if (rivit == null) {
            rivit = new ArrayList<>();
        } else {
            rivit.clear();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(nimi));
            String str = null;
            while ((str = br.readLine()) != null) {
                rivit.add(str);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AsetusTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AsetusTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String rivitYhteen() {
        StringBuilder sb = new StringBuilder();
        for (String string : rivit) {
            sb.append(string + "\n");
        }
        return sb.toString();
    }

    public static final void kirjoita() {
        if (rivit == null) {
            return;
        }
        try {
            FileWriter fw = new FileWriter(nimi, false);
            String sisalto = rivitYhteen();
            fw.append(sisalto);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AsetusTiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

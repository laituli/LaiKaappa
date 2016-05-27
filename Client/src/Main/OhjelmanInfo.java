package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import asetustiedosto.Asetukset;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 *
 * @author Laituli
 */
public class OhjelmanInfo {

    public static int leveys;
    public static int korkeus;

    public static void register() {
        leveys = Toolkit.getDefaultToolkit().getScreenSize().width;
        korkeus = Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    public static void quit() {
        Asetukset.exportTiedostoon();
        
        try {
            if (GlobalScreen.isNativeHookRegistered()) {
                GlobalScreen.unregisterNativeHook();
            }
        } catch (NativeHookException ex) {
            Logger.getLogger(OhjelmanInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
    /*
    private static BinaryAsetus piilottaako = new BinaryAsetus("piilottaako", Boolean.FALSE);
    private static BinaryAsetus tallennako = new BinaryAsetus("tallennako", Boolean.TRUE);
    private static BinaryAsetus lahetako = new BinaryAsetus("lahetako", Boolean.TRUE);
    private static BinaryAsetus kopioiko = new BinaryAsetus("kopioiko", Boolean.TRUE);

    public static BinaryAsetus getPiilottaako() {
        return piilottaako;
    }

    public static BinaryAsetus getTallennako() {
        return tallennako;
    }

    public static BinaryAsetus getLahetako() {
        return lahetako;
    }

    public static BinaryAsetus getKopioiko() {
        return kopioiko;
    }*/

}

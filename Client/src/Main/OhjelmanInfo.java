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
        TulosteTiedosto.close();
        System.exit(0);
    }
}

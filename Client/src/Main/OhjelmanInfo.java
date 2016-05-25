package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        try {
            if (GlobalScreen.isNativeHookRegistered()) {
                GlobalScreen.unregisterNativeHook();
            }
        } catch (NativeHookException ex) {
            Logger.getLogger(OhjelmanInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    public static Option piilottaako = Option.FALSE;
    public static Option tallennako = Option.TRUE;
    public static Option lahetako = Option.TRUE;
    public static Option kopioiko = Option.TRUE;

    public static Option getPiilottaako() {
        return piilottaako;
    }

    public static Option getTallennako() {
        return tallennako;
    }

    public static int getKorkeus() {
        return korkeus;
    }

    public static Option getLahetako() {
        return lahetako;
    }

    
}

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
public class OhjelmanInfo{

    public static int leveys;
    public static int korkeus;
    private static boolean tallennako = true;
    private static boolean lahetako = true;

    public static void register() {
        leveys = Toolkit.getDefaultToolkit().getScreenSize().width;
        korkeus = Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    public static boolean isTallennako() {
        return tallennako;
    }

    public static void setTallennako(boolean tallennako) {
        OhjelmanInfo.tallennako = tallennako;
    }

    public static boolean isLahetako() {
        return lahetako;
    }

    public static void setLahetako(boolean lahetako) {
        OhjelmanInfo.lahetako = lahetako;
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
}

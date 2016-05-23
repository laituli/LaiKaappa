/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 *
 * @author lai
 */
public class NappaimistonKasittelija {

    private NappaimistonKasittelija() {
    }
    private static Pikanappaimet pn;
    private static PikanappainKuuntelija pk;

    public static void register() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pn = new Pikanappaimet();
                disablePrint();
                try {
                    if (!GlobalScreen.isNativeHookRegistered()) {
                        GlobalScreen.registerNativeHook();
                    }
                } catch (NativeHookException ex) {
                    System.out.println(ex.getMessage());
                }
                pk = new PikanappainKuuntelija(pn);
                GlobalScreen.addNativeKeyListener(pk);
            }
        });
        //run
    }

    private static void disablePrint() {
        // Get the logger for "org.jnativehook" and set the level to warning.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        // Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);
    }

    private static boolean enable = true;

    public static boolean isEnable() {
        return enable;
    }

    public static void setEnable(boolean enable) {
        NappaimistonKasittelija.enable = enable;
    }
}

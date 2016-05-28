/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import asetustiedosto.AsetusUtil;
import asetustiedosto.BinaryAsetus;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;

/**
 *
 * @author lai
 */
public class Piilottaja {

    private Piilottaja() {
    }
    private static BinaryAsetus piilotako = null;

    public static void register() {
        piilotako = (BinaryAsetus) AsetusUtil.etsiAsetus("piilotako");
    }

    private static boolean palautako = false;

    public static void piilota() {
        palautako = piilotako != null && piilotako.getArvo() && LaikaappaGUI.isPaalla();
        System.out.println("palautako "+ palautako);
        if (palautako) {
            LaikaappaGUI.paalle(false);
        }
    }

    public static void palauta() {
        LaikaappaGUI.paalle(palautako || LaikaappaGUI.isPaalla() );
        palautako = false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import asetustiedosto.AsetusUtil;
import asetustiedosto.IntAsetus;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lai
 */
public class Odottaja {

    private Odottaja() {
    }
    private static IntAsetus viive = null;

    public static void register() {
        viive = (IntAsetus) AsetusUtil.etsiAsetus("viive");
    }

    public static void odota() {
        if (viive != null && viive.getArvo() > 0) {
            try {
                Thread.sleep(viive.getArvo());
            } catch (InterruptedException ex) {
                Logger.getLogger(Odottaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

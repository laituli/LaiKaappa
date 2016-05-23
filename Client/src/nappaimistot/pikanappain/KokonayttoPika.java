/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot.pikanappain;

import Main.OhjelmanInfo;
import muu_toiminnot.OtaTallennaLahetaKopioi;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author lai
 */
public class KokonayttoPika extends Pikanappain {

    private static final int defaultCode = NativeKeyEvent.VC_Q;
    private static final boolean defaultShift = true;
    private static final boolean defaultAlt = false;
    private static final boolean defaultCtrl = true;

    public KokonayttoPika() {
        super(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }

    @Override
    public void tee() {
        System.out.println("pika nappain: ota screenshot");
        OtaTallennaLahetaKopioi.kokonaytto();
    }

    @Override
    protected void setDefault() {
        setNappain(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }
}

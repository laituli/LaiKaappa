/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot.pikanappain;

import kayttoliittyma.tyokalupalkki.LaikaappaGUI;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author lai
 */
public class GUIPika extends Pikanappain {

    private static final int defaultCode = NativeKeyEvent.VC_G;
    private static final boolean defaultShift = true;
    private static final boolean defaultAlt = false;
    private static final boolean defaultCtrl = true;

    public GUIPika() {
        super(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }

    @Override
    public void tee() {
        System.out.println("pika nappain: GUI päälle");
        LaikaappaGUI.paalle(true);
    }

    @Override
    protected void setDefault() {
        setNappain(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }

}

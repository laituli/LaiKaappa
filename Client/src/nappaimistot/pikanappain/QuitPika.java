/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot.pikanappain;

import Main.OhjelmanInfo;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author lai
 */
public class QuitPika extends Pikanappain{
    private static final int defaultCode = NativeKeyEvent.VC_L;
    private static final boolean defaultShift = true;
    private static final boolean defaultAlt = false;
    private static final boolean defaultCtrl = true;

    public QuitPika() {
        super(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }

    @Override
    public void tee() {
        System.out.println("pika nappain: quit ohjelma");
        OhjelmanInfo.quit();
    }

    @Override
    protected void setDefault() {
        setNappain(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }
}

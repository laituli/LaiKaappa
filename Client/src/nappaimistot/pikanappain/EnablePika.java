/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot.pikanappain;

import nappaimistot.NappaimistonKasittelija;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author lai
 */
public class EnablePika extends Pikanappain {

    private static final int defaultCode = NativeKeyEvent.VC_P;
    private static final boolean defaultShift = true;
    private static final boolean defaultAlt = false;
    private static final boolean defaultCtrl = true;

    public EnablePika() {
        super(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }

    @Override
    public void tee() {
        NappaimistonKasittelija.setEnable(!NappaimistonKasittelija.isEnable());
        System.out.println("pikanappain " + NappaimistonKasittelija.isEnable());
    }

    @Override
    protected void setDefault() {
        setNappain(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }
}

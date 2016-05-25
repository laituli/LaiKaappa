/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot.pikanappain;

import toiminnot.kuvanotot.alueenotto.AlueenOtto;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author lai
 */
public class QuitAlueenOttoPika extends Pikanappain{
    private static final int defaultCode = NativeKeyEvent.VC_ESCAPE;
    private static final boolean defaultShift = false;
    private static final boolean defaultAlt = false;
    private static final boolean defaultCtrl = false;

    public QuitAlueenOttoPika() {
        super(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }

    @Override
    public void tee() {
        System.out.println("pika nappain: quit alueen otto");
        AlueenOtto.close();
    }

    @Override
    protected void setDefault() {
        setNappain(defaultCode, defaultShift, defaultCtrl, defaultAlt);
    }    
}

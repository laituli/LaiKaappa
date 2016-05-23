/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot.pikanappain;

import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author lai
 */
public abstract class Pikanappain {

    protected int keycode;
    protected boolean shift;
    protected boolean alt;
    protected boolean ctrl;

    public Pikanappain(int keycode, boolean shift, boolean ctrl, boolean alt) {
        setNappain(keycode, shift, ctrl, alt);
    }

    public abstract void tee();

    public boolean vastaa(NativeKeyEvent nke) {
        if (nke.getKeyCode() != keycode) {
            return false;
        }
        int modifiers = nke.getModifiers();
        if ((modifiers & NativeKeyEvent.ALT_MASK) != 0 != alt) {
            return false;
        }
        if ((modifiers & NativeKeyEvent.SHIFT_MASK) != 0 != shift) {
            return false;
        }
        if ((modifiers & NativeKeyEvent.CTRL_MASK) != 0 != ctrl) {
            return false;
        }
        return true;
    }

    public void setNappain(int code, boolean shift, boolean ctrl, boolean alt) {
        this.keycode = code;
        this.shift = shift;
        this.alt = alt;
        this.ctrl = ctrl;
    }

    protected abstract void setDefault();
}

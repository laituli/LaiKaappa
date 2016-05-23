/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot;

import nappaimistot.pikanappain.Pikanappain;
import java.util.Set;
import java.util.TreeSet;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author lai
 */
class PikanappainKuuntelija implements NativeKeyListener {

    private Set<Integer> painatut;
    private Pikanappaimet pn;

    PikanappainKuuntelija(Pikanappaimet pn) {
        this.painatut = new TreeSet<>();
        this.pn = pn;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        if (painatut.add(nke.getKeyCode())) {
            Pikanappain aktivoi = pn.getEnablePikanappain();
            if (aktivoi.vastaa(nke)) {
                aktivoi.tee();
                return;
            }
            if (NappaimistonKasittelija.isEnable()) {
                for (Pikanappain pikanappain : pn.getNappaimet()) {
                    if (pikanappain.vastaa(nke)) {
                        pikanappain.tee();
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        painatut.remove(nke.getKeyCode());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }

}

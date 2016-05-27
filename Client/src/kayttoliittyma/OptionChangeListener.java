/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import asetustiedosto.Asetus;
import javax.swing.event.ChangeListener;

/**
 *
 * @author lai
 */
public abstract class OptionChangeListener implements ChangeListener {

    private Asetus o;

    public OptionChangeListener(Asetus o) {
        this.o = o;
    }
    
    
    
}

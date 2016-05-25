/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author lai
 */
public class Option {

    static final Option TRUE = new Option(true);
    static final Option FALSE = new Option(false);
    private boolean bool;

    private Option(boolean b) {
        this.bool = b;
    }

    public void set(boolean b) {
        this.bool = b;
    }

    public boolean bool() {
        return bool;
    }
}

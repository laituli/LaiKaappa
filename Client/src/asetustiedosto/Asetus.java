/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asetustiedosto;

/**
 *
 * @author lai
 */
public abstract class Asetus<T> {

    protected final String tag;
    protected T arvo;

    public Asetus(String tag, T arvo) {
        this.tag = tag;
        this.arvo = arvo;
    }

    public abstract T stringToArvo(String str);

    public String arvoToString() {
        return arvo.toString();
    }

    public T getArvo() {
        return arvo;
    }

    public void setArvo(T arvo) {
        if (arvo != null) {
            this.arvo = arvo;
        }
    }

    public void setArvoByString(String str) {
        setArvo(stringToArvo(str));
    }

    @Override
    public String toString() {
        return tag + " " + arvoToString();
    }

}

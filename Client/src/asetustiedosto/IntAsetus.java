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
public class IntAsetus extends Asetus<Integer>{

    public IntAsetus(String tag, Integer arvo) {
        super(tag, arvo);
    }
    
    @Override
    public Integer stringToArvo(String str) {
        return Integer.parseInt(str);
    }
    
}

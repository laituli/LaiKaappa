/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.asetukset.sivut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.basic.BasicMenuUI;
import kayttoliittyma.OptionChangeListener;

/**
 *
 * @author lai
 */
public class OptionsSivu {

    public static String nimi() {
        return "options";
    }

    public static JPanel panel() {
        JPanel panel = new JPanel();
        JCheckBox htoc = new JCheckBox("hide toolbar on capture");
        panel.add(htoc);
        
        
        
        return panel;
    }
}

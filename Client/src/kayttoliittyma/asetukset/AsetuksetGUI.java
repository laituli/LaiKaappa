/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.asetukset;

import java.awt.Container;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import kayttoliittyma.asetukset.sivut.OptionsSivu;

/**
 *
 * @author lai
 */
public class AsetuksetGUI {

    private static GUI gui;

    public static void register() {
        gui = new GUI();
    }

    public static void paalle(boolean paalle) {
        if (gui != null) {
            gui.setVisible(paalle);
        }
    }

    private static class GUI extends JFrame {

        private GUI() {
            super("Asetukset");
            setBounds(300, 150, 600, 600);
            setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            luoKomponentit();
        }

        private void luoKomponentit() {
            Container container = getContentPane();
            container.setLayout(null);
            JTabbedPane tabbedPane = new JTabbedPane();
            
            tabbedPane.addTab(OptionsSivu.nimi(), OptionsSivu.panel());
            tabbedPane.addTab("empty", new Panel());
            
            tabbedPane.setBounds(10, 10, 550, 530);
            container.add(tabbedPane);
        }
    }
}

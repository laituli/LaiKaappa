/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.toolbar;

import Main.OhjelmanInfo;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import kayttoliittyma.toolbar.buttons.AlueenOttoButton;
import kayttoliittyma.toolbar.buttons.KokoNaytonOttoButton;
import kayttoliittyma.toolbar.buttons.QuitButton;

/**
 *
 * @author lai
 */
public class LaikaappaGUI {

    private LaikaappaGUI() {
    }

    private static GUI gui;

    public static void register() {
        gui = new GUI();
    }

    public static void paalle(boolean paalle) {
        if (gui != null) {
            gui.setVisible(true);
        }
    }

    private static class GUI extends JFrame {

        private JToggleButton tallennus, lahetys;

        private GUI() {
            super("Laikaappa");
            setBounds(10, 200, 200, 400);
            setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            luoKomponentit();
            setVisible(true);
        }

        private void luoKomponentit() {
            Container container = getContentPane();
            container.setLayout(null);

            tallennus = new JToggleButton();
            tallennus.setText("save");
            tallennus.setBounds(10, 280, 80, 30);
            tallennus.setSelected(OhjelmanInfo.isTallennako());
            tallennus.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    OhjelmanInfo.setTallennako(tallennus.isSelected());
                }
            });

            lahetys = new JToggleButton();
            lahetys.setText("upload");
            lahetys.setBounds(90, 280, 80, 30);
            lahetys.setSelected(true);
            lahetys.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    OhjelmanInfo.setLahetako(lahetys.isSelected());
                }
            });

            container.add(tallennus);
            container.add(lahetys);

            KokoNaytonOttoButton knob = new KokoNaytonOttoButton(10, 10, 160, 40);
            container.add(knob);

            AlueenOttoButton aob = new AlueenOttoButton(10, 60, 160, 40);
            container.add(aob);

            QuitButton qb = new QuitButton(10, 320, 160, 40);
            container.add(qb);
        }
    }
}

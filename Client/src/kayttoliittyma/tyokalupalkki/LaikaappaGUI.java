/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tyokalupalkki;

import asetustiedosto.AsetusUtil;
import kayttoliittyma.tyokalupalkki.buttons.HideButton;
import asetustiedosto.BinaryAsetus;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import kayttoliittyma.tyokalupalkki.buttons.AlueenOttoButton;
import kayttoliittyma.tyokalupalkki.buttons.AsetuksetButton;
import kayttoliittyma.tyokalupalkki.buttons.KokoNaytonOttoButton;
import kayttoliittyma.tyokalupalkki.buttons.QuitButton;
import kayttoliittyma.tyokalupalkki.buttons.SiirraButton;

/**
 *
 * @author lai
 */
public class LaikaappaGUI {

    private LaikaappaGUI() {
    }

    private static GUI gui;

    private static BinaryAsetus vaaka;
    public static int iconKoko = 30;
    private static int buttonVali = 5;

    public static void register() {
        vaaka = (BinaryAsetus) AsetusUtil.etsiAsetus("vaaka");
        gui = new GUI();
    }

    public static boolean isPaalla() {
        if (gui != null) {
            return gui.isVisible();
        }
        return false;
    }

    public static void paalle(boolean paalle) {
        if (gui != null) {
            gui.setVisible(paalle);
        }
    }

    public static JFrame getGUI() {
        return gui;
    }

    public static int buttonMaara = 6;

    public static void applyVaaka() {
        if (vaaka.getArvo()) {
            gui.setBounds(10, 200, iconKoko * buttonMaara + buttonVali * (buttonMaara + 1), iconKoko + buttonVali * 2);
            gui.getContentPane().setLayout(new GridLayout(1, 6, buttonVali, buttonVali));
        } else {
            gui.setBounds(10, 200, iconKoko + buttonVali * 2, iconKoko * buttonMaara + buttonVali * (buttonMaara + 1));
            gui.getContentPane().setLayout(new GridLayout(6, 1, buttonVali, buttonVali));
        }
    }

    private static class GUI extends JFrame {

        private static Color lapinakyva = new Color(0, 0, 0, 0);
        private static Color nakyva = new Color(0, 0, 0, .5f);

        private GUI() {
            super("Laikaappa");
            setUndecorated(true);
            setBackground(lapinakyva);
            setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            luoKomponentit();
            addMouseListener(new LapinakyvaListener());
            applyVaaka();
            setVisible(true);
        }

        private void luoKomponentit() {
            Container container = getContentPane();
            ((JPanel) container).setBorder(BorderFactory.createEmptyBorder(buttonVali, buttonVali, buttonVali, buttonVali));
            JPanel panel = new JPanel();
            KokoNaytonOttoButton knob = new KokoNaytonOttoButton();
            AlueenOttoButton aob = new AlueenOttoButton();
            AsetuksetButton ab = new AsetuksetButton();
            SiirraButton sb = new SiirraButton();
            HideButton hb = new HideButton();
            QuitButton qb = new QuitButton();

            container.add(knob);
            container.add(aob);
            container.add(ab);
            container.add(sb);
            container.add(hb);
            container.add(qb);

            NakevaButtonListener nbl = new NakevaButtonListener();
            for (Component component : container.getComponents()) {
                component.addMouseListener(new NakevaButtonListener());
            }
        }

        private void applyVaaka() {
            if (vaaka.getArvo()) {
                setBounds(10, 200, iconKoko * buttonMaara + buttonVali * (buttonMaara + 1), iconKoko + buttonVali * 2);
                getContentPane().setLayout(new GridLayout(1, 6, buttonVali, buttonVali));
            } else {
                setBounds(10, 200, iconKoko + buttonVali * 2, iconKoko * buttonMaara + buttonVali * (buttonMaara + 1));
                getContentPane().setLayout(new GridLayout(6, 1, buttonVali, buttonVali));
            }
        }

    }

    private static class NakevaButtonListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            gui.setBackground(GUI.nakyva);
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }

    private static class LapinakyvaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
            gui.setBackground(GUI.lapinakyva);
        }

    }

    public static ImageIcon icon(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image i = icon.getImage();
        BufferedImage tag = new BufferedImage(LaikaappaGUI.iconKoko, LaikaappaGUI.iconKoko, BufferedImage.TYPE_INT_ARGB);
        tag.getGraphics().drawImage(i, 0, 0, LaikaappaGUI.iconKoko, LaikaappaGUI.iconKoko, null);
        ImageIcon ret = new ImageIcon(tag);
        return ret;
    }
}

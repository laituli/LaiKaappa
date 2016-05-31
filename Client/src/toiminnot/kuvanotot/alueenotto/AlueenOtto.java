/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot.kuvanotot.alueenotto;

import Main.OhjelmanInfo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import toiminnot.OtaTallennaLahetaKopioi;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import toiminnot.Odottaja;
import toiminnot.Piilottaja;

/**
 *
 * @author lai
 */
public class AlueenOtto {

    private AlueenOtto() {
    }

    private static Piirtaja piirtaja;
    private static Juokseja juokseja;
    private static Kuuntelija kuuntelija;
    private static boolean kaynnissa = false;

    public static void register() {
        kuuntelija = new Kuuntelija();
        juokseja = new Juokseja();
        piirtaja = null;
    }

    public static void otakuva() {
        kaynnissa = false;
        Piilottaja.piilota();
        Odottaja.odota();
        SwingUtilities.invokeLater(juokseja);
    }

    public static void close() {
        Piilottaja.palauta();
        if (piirtaja != null) {
            piirtaja.close();
        }
        GlobalScreen.removeNativeMouseListener(kuuntelija);
        GlobalScreen.removeNativeMouseMotionListener(kuuntelija);
    }

    private static class Juokseja implements Runnable {

        private Juokseja() {
        }

        @Override
        public void run() {
            try {
                if (!GlobalScreen.isNativeHookRegistered()) {
                    GlobalScreen.registerNativeHook();
                }
            } catch (NativeHookException ex) {
                System.out.println(ex.getMessage());
            }

            GlobalScreen.addNativeMouseListener(kuuntelija);
            GlobalScreen.addNativeMouseMotionListener(kuuntelija);
        }
    }

    private static class Kuuntelija implements NativeMouseListener, NativeMouseMotionListener {

        @Override
        public void nativeMouseMoved(NativeMouseEvent nme) {

        }

        @Override
        public void nativeMouseDragged(NativeMouseEvent nme) {
            if (piirtaja != null) {
                piirtaja.repaint();
            }
        }

        @Override
        public void nativeMouseClicked(NativeMouseEvent nme) {

        }

        @Override
        public void nativeMousePressed(NativeMouseEvent nme) {
            System.out.println("pressed " + nme.paramString());
            piirtaja = new Piirtaja(nme.getPoint());
        }

        @Override
        public void nativeMouseReleased(NativeMouseEvent nme) {
            if (piirtaja != null) {
                piirtaja.close();
                int x = piirtaja.getStart().x;
                int y = piirtaja.getStart().y;
                int x1 = MouseInfo.getPointerInfo().getLocation().x;
                int y1 = MouseInfo.getPointerInfo().getLocation().y;
                int x2 = x < x1 ? x1 : x;
                int y2 = y < y1 ? y1 : y;
                x1 = x < x1 ? x : x1;
                y1 = y < y1 ? y : y1;
                OtaTallennaLahetaKopioi.custom(x1, y1, x2 - x1, y2 - y1);
                AlueenOtto.close();
                System.out.println("kuvan kaappaus päättyy");
            }
        }
    }

    private static class Piirtaja extends JFrame {

        private static Color tausta = new Color(0, 0, 0, 0);
        private static Color reuna = new Color(.5f, .5f, .5f, .5f);
        private static Color sisalto = new Color(1.0f, 1.0f, 1.0f, 0.5f);
        private Point start;

        public Point getStart() {
            return start;
        }

        public Piirtaja(Point start) {
            super();
            this.start = start;
            setAlwaysOnTop(true);
            setUndecorated(true);
            setBackground(new Color(0, 0, 0, 0));
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setResizable(false);
            setVisible(true);
        }

        @Override
        public void paint(Graphics grphcs) {
            super.paint(grphcs);
            grphcs.setColor(tausta);
            grphcs.fillRect(0, 0, OhjelmanInfo.leveys, OhjelmanInfo.korkeus);
            int x1 = MouseInfo.getPointerInfo().getLocation().x;
            int y1 = MouseInfo.getPointerInfo().getLocation().y;
            int x2 = start.x < x1 ? x1 : start.x;
            int y2 = start.y < y1 ? y1 : start.y;
            x1 = start.x < x1 ? start.x : x1;
            y1 = start.y < y1 ? start.y : y1;
            grphcs.setColor(sisalto);
            grphcs.fillRect(x1, y1, x2 - x1, y2 - y1);
            grphcs.setColor(reuna);
            grphcs.drawRect(x1, y1, x2 - x1, y2 - y1);
        }

        public void close() {
            dispose();
        }
    }
}


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laituli
 */
public class AlueenOtto extends Thread implements MouseListener {

    JFrame frame;
    Kayttoliittyma kayttoliittyma;

    public AlueenOtto(Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
        frame = new JFrame();
        frame.setEnabled(false);
        frame.addMouseListener(this);
    }

    int mspf = 1000;

    @Override
    public void run() {
        frame.setEnabled(true);
        while (jatkuu) {
            if (painattu) {
                System.out.println("ei piirrä vielä");
                //piirrä
            }
            try {
                Thread.sleep(mspf);
            } catch (InterruptedException ex) {
                Logger.getLogger(AlueenOtto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        frame.dispose();
    }
    boolean jatkuu = true;
    boolean painattu = false;
    int x, y;

    @Override
    public void mousePressed(MouseEvent me) {
        if (painattu) {
            return;
        }
        if (me.getButton() != 0) {
            return;
        }
        painattu = true;
        x = me.getXOnScreen();
        y = me.getYOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (!painattu) {
            return;
        }
        if (me.getButton() != 0) {
            return;
        }
        int x1, y1, x2, y2;
        x2 = me.getXOnScreen();
        y2 = me.getYOnScreen();
        x1 = x < x2 ? x : x2;
        y1 = y < y2 ? y : y2;
        x2 = x < x2 ? x2 : x;
        y1 = y < y2 ? y2 : y;
        painattu = false;
        jatkuu = false;
        new OtaTallennaLaheta(kayttoliittyma, x1, y1, x2 - x1, y2 - y1).tee();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

}

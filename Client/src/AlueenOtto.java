
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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

    Kayttoliittyma kayttoliittyma;

    public AlueenOtto(Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }

    JFrame frame;
    final Color tausta = new Color(0, 0, 0, 0);
    final Color reuna = new Color(.5f, .5f, .5f, .5f);
    final Color sisalto = new Color(1.0f, 1.0f, 1.0f, 0.5f);
    
    @Override
    public void run() {
        JButton button = new JButton();
        button.setBorder(null);
        button.addMouseListener(this);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        frame = new JFrame() {
            @Override
            public void paint(Graphics grphcs) {
                super.paint(grphcs);
                grphcs.setColor(tausta);
                grphcs.fillRect(0, 0, kayttoliittyma.leveys, kayttoliittyma.leveys);
                if (painattu) {
                    int x1 = MouseInfo.getPointerInfo().getLocation().x;
                    int y1 = MouseInfo.getPointerInfo().getLocation().y;
                    int x2 = x < x1 ? x1 : x;
                    int y2 = y < y1 ? y1 : y;
                    x1 = x < x1 ? x : x1;
                    y1 = y < y1 ? y : y1;
                    grphcs.setColor(sisalto);
                    grphcs.fillRect(x1, y1, x2 - x1, y2 - y1);
                    grphcs.setColor(reuna);
                    grphcs.drawRect(x1, y1, x2 - x1, y2 - y1);
                }
                repaint();
            }
        };
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.getContentPane().add(button);
        //frame.getRootPane().add(button);
        //frame.getRootPane().setDefaultButton(button);
        frame.setVisible(true);
    }
    boolean jatkuu = true;
    boolean painattu = false;
    int x, y;

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("press");
        if (painattu) {
            return;
        }
        System.out.println(me.getButton());
        if (me.getButton() != 1) {
            return;
        }
        painattu = true;
        x = me.getXOnScreen();
        y = me.getYOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("release");
        if (!painattu) {
            return;
        }
        if (me.getButton() != 1) {
            return;
        }
        int x2 = me.getXOnScreen();
        int y2 = me.getYOnScreen();
        int x1 = x < x2 ? x : x2;
        int y1 = y < y2 ? y : y2;
        x2 = x < x2 ? x2 : x;
        y2 = y < y2 ? y2 : y;
        painattu = false;
        jatkuu = false;
        frame.dispose();
        new OtaTallennaLaheta(kayttoliittyma, x1, y1, x2 - x1, y2 - y1).tee();
        System.out.println("kuvan kaappaus päättyy");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tyokalupalkki.buttons;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;

/**
 *
 * @author lai
 */
public class SiirraButton extends JButton implements MouseListener, MouseMotionListener {

    public SiirraButton() {
        super(LaikaappaGUI.icon("move.png"));
        setUI(new BasicButtonUI());
        setBackground(new Color(0, 0, 0, 0));
        setBorder(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        setToolTipText("move toolbar");
    }

    private Point startFrame = null;
    private Point startMouse = null;

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (startFrame == null) {
            startFrame = LaikaappaGUI.getGUI().getLocation();
            startMouse = me.getLocationOnScreen();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        startFrame = null;
        startMouse = null;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (startFrame != null) {
            LaikaappaGUI.getGUI().setLocation(new Point(startFrame.x + me.getXOnScreen() - startMouse.x, startFrame.y + me.getYOnScreen() - startMouse.y));
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }
}

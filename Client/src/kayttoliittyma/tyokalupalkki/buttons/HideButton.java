/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tyokalupalkki.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;

/**
 *
 * @author lai
 */
public class HideButton extends JButton implements ActionListener {

    public HideButton() {
        super(LaikaappaGUI.icon("hide.png"));
        setUI(new BasicButtonUI());
        setBackground(new Color(0, 0, 0, 0));
        setBorder(null);
        addActionListener(this);
        setToolTipText("hide toolbar");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        LaikaappaGUI.paalle(false);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tyokalupalkki.buttons;

/**
 *
 * @author lai
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import kayttoliittyma.asetukset.AsetuksetGUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;

/**
 *
 * @author lai
 */
public class AsetuksetButton extends JButton implements ActionListener {

    public AsetuksetButton() {
        super(LaikaappaGUI.icon("settings.png"));
        setUI(new BasicButtonUI());
        setBackground(new Color(0, 0, 0, 0));
        setBorder(null);
        addActionListener(this);
        setToolTipText("settings");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AsetuksetGUI.paalle(true);
    }
}

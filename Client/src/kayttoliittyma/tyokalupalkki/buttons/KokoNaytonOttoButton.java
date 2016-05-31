package kayttoliittyma.tyokalupalkki.buttons;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import toiminnot.OtaTallennaLahetaKopioi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;

/**
 *
 * @author Laituli
 */
public class KokoNaytonOttoButton extends JButton implements ActionListener {

    public KokoNaytonOttoButton() {
        super(LaikaappaGUI.icon("screen.png"));
        setUI(new BasicButtonUI());
        setBackground(new Color(0, 0, 0, 0));
        setBorder(null);
        addActionListener(this);
        setToolTipText("take a screenshot");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        OtaTallennaLahetaKopioi.kokonaytto();
    }

}

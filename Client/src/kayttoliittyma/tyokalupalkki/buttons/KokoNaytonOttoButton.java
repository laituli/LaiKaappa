package kayttoliittyma.tyokalupalkki.buttons;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import toiminnot.OtaTallennaLahetaKopioi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Laituli
 */
public class KokoNaytonOttoButton extends JButton implements ActionListener {

    public KokoNaytonOttoButton(int x, int y, int leveys, int korkeus) {
        super();
        setBounds(x, y, leveys, korkeus);
        setText("screenshot");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        OtaTallennaLahetaKopioi.kokonaytto();
    }

}

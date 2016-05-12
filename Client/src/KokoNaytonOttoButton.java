/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

/**
 *
 * @author Laituli
 */
public class KokoNaytonOttoButton extends JButton implements ActionListener {

    Kayttoliittyma kayttoliittyma;

    public KokoNaytonOttoButton(Kayttoliittyma kayttoliittyma, int x, int y, int leveys, int korkeus) {
        super();
        this.kayttoliittyma = kayttoliittyma;
        setBounds(x, y, leveys, korkeus);
        setText("screenshot");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        new OtaTallennaLaheta(kayttoliittyma, 0, 0, kayttoliittyma.leveys, kayttoliittyma.korkeus).tee();
    }

}

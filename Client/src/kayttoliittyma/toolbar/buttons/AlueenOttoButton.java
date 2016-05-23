package kayttoliittyma.toolbar.buttons;


import muu_toiminnot.kuvanotot.alueenotto.AlueenOtto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laituli
 */
public class AlueenOttoButton extends JButton implements ActionListener {

    public AlueenOttoButton(int x, int y, int leveys, int korkeus) {
        super();
        setBounds(x, y, leveys, korkeus);
        setText("areashot");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AlueenOtto.otakuva();
    }
}

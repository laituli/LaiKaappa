package kayttoliittyma.tyokalupalkki.buttons;


import java.awt.Color;
import toiminnot.kuvanotot.alueenotto.AlueenOtto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;

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

    public AlueenOttoButton() {
        super(LaikaappaGUI.icon("area.png"));
        setUI(new BasicButtonUI());
        setBackground(new Color(0, 0, 0, 0));
        setBorder(null);
        addActionListener(this);
        setToolTipText("capture custom area");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AlueenOtto.otakuva();
    }
}

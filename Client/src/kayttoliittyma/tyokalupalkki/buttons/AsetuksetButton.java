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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import kayttoliittyma.asetukset.AsetuksetGUI;

/**
 *
 * @author lai
 */
public class AsetuksetButton extends JButton implements ActionListener {

    public AsetuksetButton(int x, int y, int leveys, int korkeus) {
        super();
        setBounds(x, y, leveys, korkeus);
        setText("Settings");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AsetuksetGUI.paalle(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.toolbar.buttons;

import Main.OhjelmanInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author lai
 */
public class QuitButton extends JButton implements ActionListener {

    public QuitButton(int x, int y, int leveys, int korkeus) {
        super();
        setBounds(x, y, leveys, korkeus);
        setText("QUIT");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        OhjelmanInfo.quit();
    }
}

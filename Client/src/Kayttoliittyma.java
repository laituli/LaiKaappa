/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import javax.swing.JToggleButton;

/**
 *
 * @author Laituli
 */
public class Kayttoliittyma implements Runnable {

    private Kommunikaattori kommunikaattori;
    private Tallentaja tallentaja;
    private KuvanOttaja kuvanOttaja;
    private Kopioija kopioija;
    public final int leveys;
    public final int korkeus;

    public Kayttoliittyma() {
        kopioija = new Kopioija();
        this.kommunikaattori = new Kommunikaattori(kopioija);
        this.tallentaja = new Tallentaja();
        this.kuvanOttaja = new KuvanOttaja();
        leveys = Toolkit.getDefaultToolkit().getScreenSize().width;
        korkeus = Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    public Tallentaja getTallentaja() {
        return tallentaja;
    }

    public KuvanOttaja getKuvanOttaja() {
        return kuvanOttaja;
    }

    public Kommunikaattori getKommunikaattori() {
        return kommunikaattori;
    }

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Laikaappa");
        //frame.setAlwaysOnTop(true);
        frame.setBounds(10, 200, 200, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(null);
        tallennus = new JToggleButton();
        tallennus.setText("save");
        tallennus.setBounds(10, 300, 80, 30);
        tallennus.setSelected(true);
        lahetys = new JToggleButton();
        lahetys.setText("upload");
        lahetys.setBounds(90, 300, 80, 30);
        lahetys.setSelected(true);
        container.add(tallennus);
        container.add(lahetys);

        KokoNaytonOttoButton knob = new KokoNaytonOttoButton(this, 10, 10, 160, 40);
        container.add(knob);

        AlueenOttoButton aob = new AlueenOttoButton(this, 10, 60, 160, 40);
        container.add(aob);
    }

    private JToggleButton lahetys;

    public boolean lahetako() {
        if (lahetys == null) {
            return false;
        }
        return lahetys.isSelected();
    }

    private JToggleButton tallennus;

    public boolean tallennako() {
        if (tallennus == null) {
            return false;
        }
        return tallennus.isSelected();
    }

}

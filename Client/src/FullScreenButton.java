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
public class FullScreenButton extends JButton implements ActionListener {

    Kayttoliittyma kayttoliittyma;

    public FullScreenButton(Kayttoliittyma kayttoliittyma, int x, int y, int leveys, int korkeus) {
        super();
        this.kayttoliittyma = kayttoliittyma;
        setBounds(x, y, leveys, korkeus);
        setText("screenshot");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        BufferedImage image = kayttoliittyma.getKasittelija().otaKuva(0, 0, kayttoliittyma.leveys, kayttoliittyma.korkeus);     
        if(image != null){
            Kasittelija kasittelija = kayttoliittyma.getKasittelija();
            if(kayttoliittyma.tallennako()){
                System.out.println("tallenna");
                kasittelija.tallennaKuva(image);
            }
            if(kayttoliittyma.lahetako()){
                System.out.println("lähetä");
                kasittelija.lahetaKuva(image);
            }
        }else{
            System.out.println("kuvan kaappaus epäonnistuu");
        }
    }

}


import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laituli
 */
public class KuvanAction {

    Kayttoliittyma kayttoliittyma;
    int x;
    int y;
    int leveys;
    int korkeus;

    
    public KuvanAction(Kayttoliittyma kayttoliittyma, int x1, int y1, int leveys, int korkeus) {
        this.kayttoliittyma = kayttoliittyma;
        this.x = x1;
        this.y = y1;
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    
    public void tee() {
        BufferedImage image = kayttoliittyma.getKuvanOttaja().otaKuva(x, y, leveys, korkeus);
        if (image != null) {
            if (kayttoliittyma.tallennako()) {
                System.out.println("tallenna");
                kayttoliittyma.getTallentaja().tallennaKuva(image);
            }
            if (kayttoliittyma.lahetako()) {
                System.out.println("lähetä");
                kayttoliittyma.getLahettaja().lahetaKuva(image);
            }
        }
    }
}

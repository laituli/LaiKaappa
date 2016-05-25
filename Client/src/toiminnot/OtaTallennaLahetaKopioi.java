package toiminnot;

import Main.OhjelmanInfo;
import java.awt.image.BufferedImage;
import toiminnot.kuvanotot.KuvanOttaja;
import yhteys.Kommunikaattori;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laituli
 */
public class OtaTallennaLahetaKopioi {

    private OtaTallennaLahetaKopioi() {
    }

    public static void register() {
    }

    public static void custom(int x, int y, int leveys, int korkeus) {
        BufferedImage image = KuvanOttaja.otaKuva(x, y, leveys, korkeus);
        if (image != null) {
            if (OhjelmanInfo.getTallennako().bool()) {
                Tallentaja.tallennaKuva(image);
            }
            if (OhjelmanInfo.getLahetako().bool()) {
                Kommunikaattori.kommunikoiKuva(image);
            }
        }
    }

    public static void kokonaytto() {
        custom(0, 0, OhjelmanInfo.leveys, OhjelmanInfo.korkeus);
    }
}

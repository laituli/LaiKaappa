package toiminnot;

import Main.OhjelmanInfo;
import asetustiedosto.Asetus;
import asetustiedosto.AsetusUtil;
import java.awt.image.BufferedImage;
import toiminnot.kuvanotot.KuvanOttaja;
import yhteys.Kommunikaattori;
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
public class OtaTallennaLahetaKopioi {

    private OtaTallennaLahetaKopioi() {
    }

    private static Asetus tallennako, lahetako;

    public static void register() {
        tallennako = AsetusUtil.etsiAsetus("tallennako");
        if (tallennako == null) {
            System.out.println("tallennako == null");
        }
        lahetako = AsetusUtil.etsiAsetus("lahetako");
        if (lahetako == null) {
            System.out.println("lahetako == null");
        }
    }

    public static void custom(int x, int y, int leveys, int korkeus) {
        
        BufferedImage image = KuvanOttaja.otaKuva(x, y, leveys, korkeus);
        if (image != null) {
            if ((boolean) tallennako.getArvo()) {
                Tallentaja.tallennaKuva(image);
            }
            if ((boolean) lahetako.getArvo()) {
                Kommunikaattori.kommunikoiKuva(image);
            }
        }
    }

    public static void kokonaytto() {
        custom(0, 0, OhjelmanInfo.leveys, OhjelmanInfo.korkeus);
    }
}

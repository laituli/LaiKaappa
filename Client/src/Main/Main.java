package Main;

import asetustiedosto.Asetukset;
import kayttoliittyma.asetukset.AsetuksetGUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;
import toiminnot.Kopioija;
import toiminnot.OtaTallennaLahetaKopioi;
import toiminnot.Tallentaja;
import toiminnot.kuvanotot.alueenotto.AlueenOtto;
import nappaimistot.NappaimistonKasittelija;
import toiminnot.Odottaja;
import toiminnot.Piilottaja;
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
public class Main {

    public static void main(String[] args) {
        TulosteTiedosto.register();
        Asetukset.register();
        OhjelmanInfo.register();
        Kommunikaattori.register();
        Tallentaja.register();
        Kopioija.register();
        Piilottaja.register();
        Odottaja.register();
        AlueenOtto.register();
        KuvanOttaja.register();
        OtaTallennaLahetaKopioi.register();
        LaikaappaGUI.register();
        AsetuksetGUI.register();
        NappaimistonKasittelija.register();
    }
}

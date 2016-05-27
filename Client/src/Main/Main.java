package Main;

import asetustiedosto.Asetukset;
import kayttoliittyma.asetukset.AsetuksetGUI;
import kayttoliittyma.tyokalupalkki.LaikaappaGUI;
import toiminnot.Kopioija;
import toiminnot.OtaTallennaLahetaKopioi;
import toiminnot.Tallentaja;
import toiminnot.kuvanotot.alueenotto.AlueenOtto;
import nappaimistot.NappaimistonKasittelija;
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
        if (true) {
            Asetukset.register();
        }
        OhjelmanInfo.register();
        Kommunikaattori.register();
        Tallentaja.register();
        AlueenOtto.register();
        Kopioija.register();
        OtaTallennaLahetaKopioi.register();
        LaikaappaGUI.register();
        AsetuksetGUI.register();
        NappaimistonKasittelija.register();
    }
}

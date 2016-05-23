package Main;

import kayttoliittyma.toolbar.LaikaappaGUI;
import muu_toiminnot.Kopioija;
import muu_toiminnot.OtaTallennaLahetaKopioi;
import muu_toiminnot.Tallentaja;
import muu_toiminnot.kuvanotot.alueenotto.AlueenOtto;
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
        OhjelmanInfo.register();
        Kommunikaattori.register();
        Tallentaja.register();
        AlueenOtto.register();
        Kopioija.register();
        OtaTallennaLahetaKopioi.register();
        LaikaappaGUI.register();
        NappaimistonKasittelija.register();
    }
}

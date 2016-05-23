/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nappaimistot;

import nappaimistot.pikanappain.Pikanappain;
import java.util.ArrayList;
import java.util.List;
import nappaimistot.pikanappain.AlueenPika;
import nappaimistot.pikanappain.EnablePika;
import nappaimistot.pikanappain.GUIPika;
import nappaimistot.pikanappain.KokonayttoPika;
import nappaimistot.pikanappain.QuitAlueenOttoPika;
import nappaimistot.pikanappain.QuitPika;

/**
 *
 * @author lai
 */
public class Pikanappaimet {

    private List<Pikanappain> nappaimet;
    private Pikanappain enablePika;

    public Pikanappaimet() {
        nappaimet = new ArrayList<>();
        enablePika = new EnablePika();
        nappaimet.add(enablePika);
        nappaimet.add(new KokonayttoPika());
        nappaimet.add(new AlueenPika());
        nappaimet.add(new QuitPika());
        nappaimet.add(new QuitAlueenOttoPika());
        nappaimet.add(new GUIPika());
    }

    public Pikanappain getEnablePikanappain() {
        return enablePika;
    }

    public List<Pikanappain> getNappaimet() {
        return nappaimet;
    }
}

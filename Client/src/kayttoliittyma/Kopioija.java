package kayttoliittyma;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laituli
 */
public class Kopioija implements ClipboardOwner{

    Clipboard clipboard;

    public Kopioija() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void kopioi(String viesti) {
        System.out.println("kopioidaan");
        StringSelection selection = new StringSelection(viesti);
        clipboard.setContents(selection, this);
        System.out.println("kopioitu");
    }

    @Override
    public void lostOwnership(Clipboard clpbrd, Transferable t) {
    }
}

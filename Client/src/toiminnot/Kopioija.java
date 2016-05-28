package toiminnot;

import asetustiedosto.AsetusUtil;
import asetustiedosto.BinaryAsetus;
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
public class Kopioija {

    private Kopioija() {
    }

    private static Clipboard clipboard;
    private static ClipboardOwner owner;
    private static BinaryAsetus kopioiko;

    public static void register() {
        owner = (Clipboard clpbrd, Transferable t) -> {};
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        kopioiko = (BinaryAsetus) AsetusUtil.etsiAsetus("kopioiko");
    }

    public static void kopioi(String viesti) {
        if (kopioiko.getArvo()) {
            System.out.println("kopioidaan");
            StringSelection selection = new StringSelection(viesti);
            clipboard.setContents(selection, owner);
            System.out.println("kopioitu");
        }
    }
}

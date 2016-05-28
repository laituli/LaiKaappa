/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.asetukset.sivut;

import asetustiedosto.Asetus;
import asetustiedosto.AsetusUtil;
import asetustiedosto.BinaryAsetus;
import asetustiedosto.IntAsetus;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author lai
 */
public class OptionsSivu {

    public static String nimi() {
        return "options";
    }

    public static JPanel panel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(general());
        panel.add(onCapture());
        panel.add(afterCapture());
        return panel;
    }

    private static JPanel general() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("general"));
        return panel;
    }

    private static JPanel onCapture() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("on capture"));
        AsetusVaihtoCheckbox piilotako = new AsetusVaihtoCheckbox("hide toolbar on capture", AsetusUtil.etsiAsetus("piilotako"));
        panel.add(piilotako);
        AsetusIntField viive = new AsetusIntField("delay on capture (mm)", AsetusUtil.etsiAsetus("viive"));
        panel.add(viive);
        return panel;
    }

    private static JPanel afterCapture() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("after capture"));
        panel.add(uploading());
        panel.add(save());
        return panel;
    }

    private static JPanel uploading() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("uploading"));
        AsetusVaihtoCheckbox lahetako = new AsetusVaihtoCheckbox("upload on capture", AsetusUtil.etsiAsetus("lahetako"));
        panel.add(lahetako);
        AsetusVaihtoCheckbox kopioiko = new AsetusVaihtoCheckbox("copy link on capture", AsetusUtil.etsiAsetus("kopioiko"));
        panel.add(kopioiko);
        return panel;
    }

    private static JPanel save() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("saving"));
        AsetusVaihtoCheckbox tallennako = new AsetusVaihtoCheckbox("save on capture", AsetusUtil.etsiAsetus("tallennako"));
        panel.add(tallennako);
        return panel;
    }

    public static class AsetusVaihtoCheckbox extends JCheckBox implements ChangeListener {

        private BinaryAsetus ba;

        public AsetusVaihtoCheckbox(String str, Asetus ba) {
            super(str);
            if (ba instanceof BinaryAsetus) {
                this.ba = (BinaryAsetus) ba;
                setSelected(this.ba.getArvo());
                addChangeListener(this);
            } else {
                System.out.println("BinaryAsetus ei ole: " + this.getText());
            }
        }

        @Override
        public void stateChanged(ChangeEvent ce) {
            ba.setArvo(isSelected());
        }
    }

    public static class AsetusIntField extends JPanel {

        private IntAsetus ia;
        private JButton apply;
        private JTextArea area;
        private JLabel label;

        public AsetusIntField(String str, Asetus ia) {
            super();
            if (ia instanceof IntAsetus) {
                this.ia = (IntAsetus) ia;
                label = new JLabel(str);
                area = new JTextArea();
                area.setText(this.ia.getArvo() + "");
                apply = new JButton("apply");
                apply.addActionListener((ActionEvent ae) -> {
                    int n = Integer.parseInt(area.getText());
                    ((IntAsetus) ia).setArvo(n);
                });
                add(label);
                add(area);
                add(apply);
            } else {
                System.out.println("IntAsetus ei ole: " + area.getName());
            }
        }
    }

}

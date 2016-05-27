package asetustiedosto;

/**
 *
 * @author lai
 */
public class Asetukset {

    public static Asetus[] asetukset;

    private Asetukset() {

    }

    public final static Asetus[] defaultAsetukset = new Asetus[]{
        new BinaryAsetus("piilottaako", Boolean.FALSE),
        new BinaryAsetus("tallennako", Boolean.TRUE),
        new BinaryAsetus("lahetako", Boolean.TRUE),
        new BinaryAsetus("kopioiko", Boolean.TRUE)
    };

    public static void register() {
        asetukset = defaultAsetukset;
        importTiedostosta();
    }

    public static void importTiedostosta() {
        AsetusTiedosto.lue();
        for (Asetus asetus : asetukset) {
            AsetusUtil.TupleIndexString rivi = AsetusUtil.etsiRivi(asetus.tag);
            if (rivi == null) {
                continue;
            }
            asetus.setArvoByString(rivi.string);
        }
    }

    public static void exportTiedostoon() {
        for (Asetus asetus : asetukset) {
            AsetusUtil.setRivi(asetus.tag, asetus.arvoToString());
        }
    }
}

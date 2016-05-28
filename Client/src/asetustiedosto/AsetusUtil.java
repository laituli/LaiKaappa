package asetustiedosto;

/**
 *
 * @author lai
 */
public class AsetusUtil {

    public static Asetus etsiAsetus(String tag) {
        for (Asetus asetus : Asetukset.asetukset) {
            if (asetus.tag.equals(tag)) {
                return asetus;
            }
        }
        return null;
    }

    public static TupleIndexString etsiRivi(String tag) {
        String[] strs;
        int i = 0;
        for (String string : AsetusTiedosto.rivit) {
            strs = string.split(" ");
            if (strs[0].equals(tag)) {
                return new TupleIndexString(i, string);
            }
            i++;
        };
        return null;
    }

    public static boolean setOrAddRivi(String tag, String arvo) {
        TupleIndexString p = etsiRivi(tag);
        if (p == null) {
            AsetusTiedosto.rivit.add(tag + " " + arvo);
            return false;
        }
        AsetusTiedosto.rivit.set(p.index, tag + " " + arvo);
        return true;
    }

    public static class TupleIndexString {

        public int index;
        public String string;

        public TupleIndexString(int i, String string) {
            this.index = i;
            this.string = string;
        }

        @Override
        public String toString() {
            return index + " " + string;
        }

        public String getArvo() {
            return string.split(" ", 2)[1];
        }

    }
}

package asetustiedosto;

/**
 *
 * @author lai
 */
public class BinaryAsetus extends Asetus<Boolean> {

    public BinaryAsetus(String tag, Boolean arvo) {
        super(tag, arvo);
    }

    @Override
    public Boolean stringToArvo(String str) {
        return Boolean.valueOf(str);
    }
}

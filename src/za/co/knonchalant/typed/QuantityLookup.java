package za.co.knonchalant.typed;

import java.util.HashMap;
import java.util.Map;

public class QuantityLookup {

    private static final Map<Quantity, String> LOOKUP;

    // from https://physics.nist.gov/cuu/Units/units.html
    static {
        LOOKUP = new HashMap<>();

        // base units
        LOOKUP.put(new Quantity(Type.of("m")), "length");
        LOOKUP.put(new Quantity(Type.of("kg")), "mass");
        LOOKUP.put(new Quantity(Type.of("s")), "time");
        LOOKUP.put(new Quantity(Type.of("A")), "electric current");
        LOOKUP.put(new Quantity(Type.of("K")), "thermodynamic temperature");
        LOOKUP.put(new Quantity(Type.of("mol")), "amount of substance");
        LOOKUP.put(new Quantity(Type.of("cd")), "luminous intensity");

        // derived units
        LOOKUP.put(new Quantity(Type.of("m", 2)), "area");
        LOOKUP.put(new Quantity(Type.of("m", 3)), "volume");
        LOOKUP.put(new Quantity(Type.of("m"), Type.of("s", -1)), "velocity");
        LOOKUP.put(new Quantity(Type.of("m"), Type.of("s", -2)), "acceleration");
        LOOKUP.put(new Quantity(Type.of("m", -1)), "wave number");
        LOOKUP.put(new Quantity(Type.of("kg"), Type.of("m", -3)), "mass density");
        LOOKUP.put(new Quantity(Type.of("m", 3), Type.of("kg", -1)), "specific volume");
        LOOKUP.put(new Quantity(Type.of("A"), Type.of("m", -2)), "current density");
        LOOKUP.put(new Quantity(Type.of("A"), Type.of("m")), "magnetic field strength");
        LOOKUP.put(new Quantity(Type.of("mol"), Type.of("m", -3)), "amount-of-substance concentration");
        LOOKUP.put(new Quantity(Type.of("cd"), Type.of("m", -2)), "luminance");
    }

    public static String lookup(Quantity quantity) {
        return LOOKUP.get(quantity);
    }
}

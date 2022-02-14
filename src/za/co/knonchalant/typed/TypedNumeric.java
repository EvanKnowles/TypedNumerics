package za.co.knonchalant.typed;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TypedNumeric implements Serializable {
    private final BigDecimal value;
    private final Quantity quantity;

    public TypedNumeric(BigDecimal value, Quantity quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public TypedNumeric add(TypedNumeric other) {
        if (!other.quantity.equals(quantity)) {
            throw new IncompatibleTypesException("Cannot add " + other.quantity + " and " + quantity.toString());
        }

        return new TypedNumeric(value.add(other.value), quantity);
    }

    public TypedNumeric subtract(TypedNumeric other) {
        if (!other.quantity.equals(quantity)) {
            throw new IncompatibleTypesException("Cannot subtract " + other.quantity + " and " + quantity.toString());
        }

        return new TypedNumeric(value.subtract(other.value), quantity);
    }

    public TypedNumeric divide(TypedNumeric other) {
        return new TypedNumeric(value.divide(other.value, RoundingMode.HALF_EVEN), quantity.remove(other.quantity));
    }

    public BigDecimal getValue() {
        return value;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        String lookup = QuantityLookup.lookup(quantity);
        if (lookup == null) {
            return value + quantity.toString();
        }

        return value + quantity.toString() + " (" + lookup + ")";
    }
}

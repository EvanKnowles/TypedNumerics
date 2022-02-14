package za.co.knonchalant.typed;

import java.util.Objects;

public class Type {
    private final String unit;
    private final int order;

    public Type(String unit, int order) {
        this.unit = unit;
        this.order = order;
    }

    public static Type of(String unit) {
        return of(unit, 1);
    }

    public static Type of(String unit, int order) {
        return new Type(unit, order);
    }

    public String getUnit() {
        return unit;
    }

    public int getOrder() {
        return order;
    }

    public Type add(Type type) {
        return new Type(unit, order + type.getOrder());
    }

    @Override
    public String toString() {
        if (order == 1) {
            return unit;
        }
        return unit + "^" + order;
    }

    public Type remove(Type type) {
        return new Type(unit, order - type.getOrder());
    }

    public Type inverse() {
        return new Type(unit, -order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return order == type.order && unit.equals(type.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, order);
    }
}

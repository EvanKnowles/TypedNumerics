package za.co.knonchalant.typed;

import java.math.BigDecimal;
import java.util.*;

public class Quantity {
    private final Map<String, Type> types;

    public Quantity() {
        types = new HashMap<>();
    }

    public Quantity(Type... typesVar) {
        types = new HashMap<>();
        for (Type type : typesVar) {
            add(type);
        }
    }

    public Quantity(Map<String, Type> typesMap) {
        this.types = typesMap;
    }

    private void add(Type type) {
        if (!types.containsKey(type.getUnit())) {
            types.put(type.getUnit(), type);
        } else {
            Type existingType = types.get(type.getUnit());
            Type combine = existingType.add(type);
            if (combine.getOrder() == 0) {
                types.remove(type.getUnit());
            } else {
                types.put(type.getUnit(), combine);
            }
        }
    }

    public Quantity remove(Type type) {
        Map<String, Type> types = new HashMap<>(this.types);

        if (!types.containsKey(type.getUnit())) {
            types.put(type.getUnit(), type.inverse());
        } else {
            Type existingType = types.get(type.getUnit());
            Type combine = existingType.remove(type);
            if (combine.getOrder() == 0) {
                types.remove(type.getUnit());
            } else {
                types.put(type.getUnit(), combine);
            }
        }

        return new Quantity(types);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        List<Type> values = new ArrayList<>(types.values());
        values.sort(Comparator.comparing(Type::getUnit));

        for (Type type : values) {
            result.append(type.toString());
        }

        return result.toString();
    }

    public Quantity remove(Quantity other) {
        Quantity newQuantity = new Quantity(new HashMap<>(types));
        for (Type value : other.types.values()) {
            newQuantity = newQuantity.remove(value);
        }
        return newQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return types.equals(quantity.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(types);
    }

    public TypedNumeric forValue(BigDecimal value) {
        return new TypedNumeric(value, this);
    }
}

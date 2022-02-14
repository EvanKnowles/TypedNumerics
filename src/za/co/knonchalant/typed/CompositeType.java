package za.co.knonchalant.typed;

import java.io.Serializable;

public class CompositeType implements Serializable {
    private CompositeType left;
    private CompositeType right;
    private final EOperation operation;

    private final String identifier;

    public CompositeType(CompositeType left, CompositeType right, EOperation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
        identifier = "";
    }

    public CompositeType(String identifier) {
        this.identifier = identifier;
        this.operation = EOperation.IDENTITY;
    }

    @Override
    public String toString() {
        return operation.readable(left, right, identifier);
    }
}

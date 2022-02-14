package za.co.knonchalant.typed;

import za.co.knonchalant.typed.operations.IdentityOperator;
import za.co.knonchalant.typed.operations.MultiplicationOperation;
import za.co.knonchalant.typed.readers.IdentityReadable;
import za.co.knonchalant.typed.readers.MultiplicationReadable;

public enum EOperation {
    IDENTITY(), ADDITION(), SUBTRACTION(), MULTIPLICATION(new MultiplicationReadable(), new MultiplicationOperation()), DIVISION();

    EOperation(IReadableOperation readableOperation, IOperation operation) {
        this.readableOperation = readableOperation;
        this.operation = operation;
    }

    EOperation() {
        this.operation = new IdentityOperator();
        this.readableOperation = new IdentityReadable();
    }

    private final IReadableOperation readableOperation;
    private final IOperation operation;

    public String readable(CompositeType left, CompositeType right, String identifier) {
        if (readableOperation != null) {
            return readableOperation.convert(left, right, identifier);
        }
        return "not readable";
    }

    public CompositeType operate(CompositeType left, CompositeType right) {
        return operation.operate(left, right);
    }
}

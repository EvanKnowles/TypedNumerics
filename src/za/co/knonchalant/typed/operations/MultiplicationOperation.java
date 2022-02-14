package za.co.knonchalant.typed.operations;

import za.co.knonchalant.typed.EOperation;
import za.co.knonchalant.typed.IOperation;
import za.co.knonchalant.typed.CompositeType;

public class MultiplicationOperation implements IOperation {
    @Override
    public CompositeType operate(CompositeType left, CompositeType right) {
        return new CompositeType(left, right, EOperation.MULTIPLICATION);
    }
}

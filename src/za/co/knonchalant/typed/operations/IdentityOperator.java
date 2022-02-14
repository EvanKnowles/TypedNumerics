package za.co.knonchalant.typed.operations;

import za.co.knonchalant.typed.IOperation;
import za.co.knonchalant.typed.CompositeType;

public class IdentityOperator implements IOperation {
    @Override
    public CompositeType operate(CompositeType left, CompositeType right) {
        return left;
    }
}

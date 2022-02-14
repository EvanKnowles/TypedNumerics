package za.co.knonchalant.typed.readers;

import za.co.knonchalant.typed.IReadableOperation;
import za.co.knonchalant.typed.CompositeType;

public class IdentityReadable implements IReadableOperation {
    @Override
    public String convert(CompositeType left, CompositeType right, String identifier) {
        return identifier;
    }
}

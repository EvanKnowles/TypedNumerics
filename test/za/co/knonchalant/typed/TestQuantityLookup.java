package za.co.knonchalant.typed;

import org.junit.Assert;
import org.junit.Test;

public class TestQuantityLookup {
    @Test
    public void test() {
        Quantity area = new Quantity(Type.of("m"), Type.of("s", -2));
        String lookup = QuantityLookup.lookup(area);
        Assert.assertEquals("acceleration", lookup);
    }
}

package za.co.knonchalant.typed;

import org.junit.Assert;
import org.junit.Test;

public class TestQuantities {
    @Test
    public void testQuantity() {
        Quantity quantity = new Quantity(Type.of("m"));
        Assert.assertEquals("m", quantity.toString());
    }

    @Test
    public void testBiggerQuantity() {
        Quantity quantity = new Quantity(Type.of("m"), Type.of("s", -2));
        Assert.assertEquals("ms^-2", quantity.toString());
    }

    @Test
    public void testCombineQuantity() {
        Quantity quantity = new Quantity(Type.of("m"));
        Quantity quantity2 = new Quantity(Type.of("s", 2));

        Quantity resultQuantity = quantity.remove(quantity2);
        Assert.assertEquals("ms^-2", resultQuantity.toString());
    }
}

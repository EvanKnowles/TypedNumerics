package za.co.knonchalant.typed;

import org.junit.Assert;
import org.junit.Test;

public class TestCompositeTypes {

    @Test
    public void testBasic() {
        CompositeType m = new CompositeType("m");
        Assert.assertEquals("m", m.toString());
    }

    @Test
    public void testAddition() {
        CompositeType m = new CompositeType("m");
        CompositeType alsoM = new CompositeType("m");
        CompositeType resultType = EOperation.ADDITION.operate(m, alsoM);
        Assert.assertEquals("m", resultType.toString());
    }

    @Test
    public void testMultiplication() {
        CompositeType m = new CompositeType("m");
        CompositeType alsoM = new CompositeType("m");
        CompositeType resultType = EOperation.MULTIPLICATION.operate(m, alsoM);
        Assert.assertEquals("m*m", resultType.toString());
    }
}

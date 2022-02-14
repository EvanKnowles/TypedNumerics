package za.co.knonchalant.typed;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestTypedNumerics {

    @Test
    public void testAdd() {
        Quantity q1 = new Quantity(Type.of("m"));
        Quantity q2 = new Quantity(Type.of("m"));

        TypedNumeric typedNumeric = new TypedNumeric(BigDecimal.ONE, q1);
        TypedNumeric typedNumeric2 = new TypedNumeric(BigDecimal.TEN, q2);

        TypedNumeric add = typedNumeric.add(typedNumeric2);
        Assert.assertEquals("m", add.getQuantity().toString());
        Assert.assertEquals(new BigDecimal("11"), add.getValue());
    }

    @Test
    public void testSubtract() {
        Quantity q1 = new Quantity(Type.of("m"));
        Quantity q2 = new Quantity(Type.of("m"));

        TypedNumeric typedNumeric = new TypedNumeric(BigDecimal.ONE, q1);
        TypedNumeric typedNumeric2 = new TypedNumeric(BigDecimal.TEN, q2);

        TypedNumeric add = typedNumeric2.subtract(typedNumeric);
        Assert.assertEquals("m", add.getQuantity().toString());
        Assert.assertEquals(new BigDecimal("9"), add.getValue());
    }

    @Test(expected = IncompatibleTypesException.class)
    public void testSubtractIncompatible() {
        Quantity q1 = new Quantity(Type.of("m"));
        Quantity q2 = new Quantity(Type.of("s"));

        TypedNumeric typedNumeric = new TypedNumeric(BigDecimal.ONE, q1);
        TypedNumeric typedNumeric2 = new TypedNumeric(BigDecimal.TEN, q2);

        typedNumeric2.subtract(typedNumeric);
    }

    @Test(expected = IncompatibleTypesException.class)
    public void testAddIncompatible() {
        Quantity q1 = new Quantity(Type.of("m"));
        Quantity q2 = new Quantity(Type.of("s"));

        TypedNumeric typedNumeric = new TypedNumeric(BigDecimal.ONE, q1);
        TypedNumeric typedNumeric2 = new TypedNumeric(BigDecimal.TEN, q2);

        typedNumeric.add(typedNumeric2);
    }

    @Test
    public void testProduceAcceleration() {
        Quantity changeInVelocityQuantity = new Quantity(Base.Length.val(),
                                                                   Base.Time.val(-1));
        Quantity timeQuantity = new Quantity(Base.Time.val());

        TypedNumeric fourMeters = changeInVelocityQuantity.forValue(BigDecimal.valueOf(4));
        TypedNumeric twoSeconds = timeQuantity.forValue(BigDecimal.valueOf(2));

        TypedNumeric result = fourMeters.divide(twoSeconds);
        System.out.println(result);
    }
}

package za.co.knonchalant.typed;

public enum Base {
    Length("m"),
    Mass("kg"),
    Time("s"),
    ElectricCurrent("A"),
    ThermodynamicTemperature("K"),
    AmountOfSubstance("mol"),
    LuminousIntensity("cd"),
    ;

    private final String symbol;

    Base(String symbol) {
        this.symbol = symbol;
    }

    public Type val() {
        return val(1);
    }

    public Type val(int order) {
        return new Type(this.symbol, order);
    }
}

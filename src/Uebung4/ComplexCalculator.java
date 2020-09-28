package Uebung4;

public class ComplexCalculator extends AbstractCalculator {

    public ComplexCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        return super.add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return super.subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return super.multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return super.divide.calc(a, b);
    }

}

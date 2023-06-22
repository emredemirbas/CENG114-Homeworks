public class IntegerOperator extends Operator {

    private final int value;

    public IntegerOperator(int value) {
        this.value = value;
    }

    @Override
    public Operator add(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof IntegerOperator) {
            IntegerOperator iop = (IntegerOperator) op;
            return new IntegerOperator(this.value + iop.value);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public Operator substract(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof IntegerOperator) {
            IntegerOperator iop = (IntegerOperator) op;
            return new IntegerOperator(this.value - iop.value);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public Operator multiply(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof IntegerOperator) {
            IntegerOperator iop = (IntegerOperator) op;
            return new IntegerOperator(this.value * iop.value);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public double distance(Operator op) {
        if (op instanceof IntegerOperator) {
            IntegerOperator iop = (IntegerOperator) op;
            return (double) (Math.abs(this.value - iop.value));
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntegerOperator) {
            IntegerOperator iop = (IntegerOperator) obj;
            return this.value == iop.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}

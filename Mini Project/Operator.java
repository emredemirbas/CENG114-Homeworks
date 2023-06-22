public abstract class Operator {

    public abstract Operator add(Operator op) throws NotSameOperatorTypeException;

    public abstract Operator substract(Operator op) throws NotSameOperatorTypeException;

    public abstract Operator multiply(Operator op) throws NotSameOperatorTypeException;

    public abstract double distance(Operator op);

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}

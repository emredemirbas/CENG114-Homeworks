public class StringOperator extends Operator {
    private final String value;

    public StringOperator(String value) {
        this.value = value;
    }

    @Override
    public Operator add(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof StringOperator) {
            StringOperator sop = (StringOperator) op;
            return new StringOperator(this.value + sop.value);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public Operator substract(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof StringOperator) {
            StringOperator sop = (StringOperator) op;
            String reversedString = reverseString(this.value);
            String reversedSopValue = reverseString(sop.value);
            String substractedString = reverseString(reversedString.replaceFirst(reversedSopValue, ""));

            return new StringOperator(substractedString);

        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public Operator multiply(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof StringOperator) {
            StringOperator sop = (StringOperator) op;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < value.length(); i++) {
                result.append(value.charAt(i));
                result.append(sop.value);
            }
            return new StringOperator(result.toString());
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public double distance(Operator op) {
        if (op instanceof StringOperator) {
            StringOperator sop = (StringOperator) op;
            int n1 = this.value.length();
            int n2 = sop.value.length();
            int n = Math.max(n1, n2);

            int distance = 0;
            for (int i = 0; i < n; i++) {
                char ch1 = (i < n1 ? this.value.charAt(i) : ' ');
                char ch2 = (i < n2 ? sop.value.charAt(i) : ' ');

                distance += Math.abs(ch1 - ch2);
            }

            return distance;

        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StringOperator) {
            StringOperator sop = (StringOperator) obj;
            return this.value.equals(sop.value);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }
}
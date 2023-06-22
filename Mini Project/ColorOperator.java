enum Color {
    Red, Green, Blue, Magenta, Yellow, Cyan, White, Black;

    @Override
    public String toString() {
        return switch (this) {
            case Red -> "Red";
            case Green -> "Green";
            case Blue -> "Blue";
            case Magenta -> "Magenta";
            case Yellow -> "Yellow";
            case Cyan -> "Cyan";
            case White -> "White";
            case Black -> "Black";
        };
    }
}

public class ColorOperator extends Operator {

    // R G B
    // 1 0 0 ---> Red : 4
    // 0 1 0 ---> Green : 2
    // 0 0 1 ---> Blue : 1
    // 1 0 1 ---> Magenta : 5
    // 1 1 0 ---> Yellow : 6
    // 0 1 1 ---> Cyan : 3
    // 1 1 1 ---> White : 7
    // 0 0 0 ---> Black : 0

    private int[] rgb = new int[3];
    // 0th index stands for Red
    // 1st index stands for Green
    // 2nd index stands for Blue
    private Color color;
    private boolean isPrimaryColor;

    public ColorOperator(Color color) {
        this.color = color;
        switch (this.color) {
            case Red -> rgb = new int[]{1, 0, 0};
            case Green -> rgb = new int[]{0, 1, 0};
            case Blue -> rgb = new int[]{0, 0, 1};
            case Magenta -> rgb = new int[]{1, 0, 1};
            case Yellow -> rgb = new int[]{1, 1, 0};
            case Cyan -> rgb = new int[]{0, 1, 1};
            case White -> rgb = new int[]{1, 1, 1};
            case Black -> rgb = new int[]{0, 0, 0};
        }
        determinePrimaryColorOrNot();
    }

    public ColorOperator(int[] rgb) {
        this.rgb = rgb;
        try {
            determineColor();
        } catch (RGBException e) {
            System.out.println(e);
        }
        determinePrimaryColorOrNot();
    }

    public ColorOperator(int r, int g, int b) {
        this(new int[]{r, g, b});
    }

    private void determineColor() throws RGBException {
        if (rgb[0] == 1 && rgb[1] == 0 && rgb[2] == 0) {
            this.color = Color.Red;
        } else if (rgb[0] == 0 && rgb[1] == 1 && rgb[2] == 0) {
            this.color = Color.Green;
        } else if (rgb[0] == 0 && rgb[1] == 0 && rgb[2] == 1) {
            this.color = Color.Blue;
        } else if (rgb[0] == 1 && rgb[1] == 0 && rgb[2] == 1) {
            this.color = Color.Magenta;
        } else if (rgb[0] == 1 && rgb[1] == 1 && rgb[2] == 0) {
            this.color = Color.Yellow;
        } else if (rgb[0] == 0 && rgb[1] == 1 && rgb[2] == 1) {
            this.color = Color.Cyan;
        } else if (rgb[0] == 1 && rgb[1] == 1 && rgb[2] == 1) {
            this.color = Color.White;
        } else if (rgb[0] == 0 && rgb[1] == 0 && rgb[2] == 0) {
            this.color = Color.Black;
        } else {
            throw new RGBException();
        }
    }

    private void determinePrimaryColorOrNot() {
        int sum = 0;
        for (int x : rgb) {
            sum += x;
        }
        isPrimaryColor = (sum == 1);
    }

    @Override
    public Operator add(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof ColorOperator) {
            ColorOperator cOp = (ColorOperator) op;
            int[] newRgb = new int[rgb.length];
            for (int i = 0; i < rgb.length; i++) {
                newRgb[i] = rgb[i] | cOp.rgb[i];
            }
            return new ColorOperator(newRgb);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public Operator substract(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof ColorOperator) {
            ColorOperator cOp = (ColorOperator) op;
            if (this.isPrimaryColor && cOp.isPrimaryColor && !this.color.toString().equals(cOp.color.toString())) {
                return this;
            }
            int[] newRgb = new int[rgb.length];
            for (int i = 0; i < rgb.length; i++) {
                if (this.rgb[i] == 0 && cOp.rgb[i] == 1) {
                    newRgb[i] = 0;
                } else {
                    newRgb[i] = this.rgb[i] ^ cOp.rgb[i];
                }
            }
            return new ColorOperator(newRgb);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    @Override
    public Operator multiply(Operator op) throws NotSameOperatorTypeException {
        if (op instanceof ColorOperator) {
            ColorOperator cOp = (ColorOperator) op;
            int[] newRgb = new int[rgb.length];
            for (int i = 0; i < rgb.length; i++) {
                newRgb[i] = rgb[i] & cOp.rgb[i];
            }
            return new ColorOperator(newRgb);
        } else {
            throw new NotSameOperatorTypeException();
        }
    }

    private int toDecimal() {
        int result = 0;
        for (int i = 0; i < rgb.length; i++) {
            result += Math.pow(2, rgb.length - (i + 1)) * rgb[i];
        }
        return result;
    }

    @Override
    public double distance(Operator op) {
        if (op instanceof ColorOperator) {
            return Math.abs(this.toDecimal() - ((ColorOperator) op).toDecimal());
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ColorOperator) {
            ColorOperator cOp = (ColorOperator) obj;
            return this.toDecimal() == cOp.toDecimal();
        }
        return false;
    }


    @Override
    public String toString() {
        return color.toString();
    }
}

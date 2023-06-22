import java.util.Arrays;

public class Solver {

    private String bestExpression;
    private double bestDistance = Double.POSITIVE_INFINITY;
    private boolean isFound;

    public void findSolution(Operator[] operators, Operator target) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operators.length && bestDistance != 0; i++) {
            boolean[] used = new boolean[operators.length];
            used[i] = true;
            String expression = operators[i].toString();
            Operator currentResult = operators[i];
            generateExpression(operators, used, target, expression, currentResult);
        }
        long endTime = System.nanoTime() - startTime;
        double executionTime = (endTime) / 1e6;
        if (!isFound) {
            System.out.printf("Input Set : %s\nTarget : %s\nCalculation done but couldn't reach desired output.\nBest expression: %s\nBest distance: %s\nExecution time: %f ms\n", Arrays.toString(operators),target.toString(), bestExpression, bestDistance, executionTime);
        } else {
            System.out.printf("Input Set : %s\nTarget : %s\nCalculation succesfuly done!\nExpression: %s\nExecution time: %f ms\n",Arrays.toString(operators),target.toString(), bestExpression, executionTime);
        }
    }

    private void generateExpression(Operator[] operators, boolean[] used, Operator target, String expression, Operator currentResult) {
        if (currentResult.distance(target) == 0) {
            bestExpression = expression + " = " + target;
            bestDistance = 0;
            isFound = true;
            return;
        }

        double distance = currentResult.distance(target);

        if (bestDistance >= distance) {
            bestDistance = distance;
            bestExpression = expression + " = " + currentResult;
        }

        for (int i = 0; i < operators.length; i++) {
            if (!used[i]) {
                used[i] = true;

                try {
                    generateExpression(operators, used, target, "(" + expression + " + " + operators[i] + ")", currentResult.add(operators[i]));
                    generateExpression(operators, used, target, "(" + expression + " - " + operators[i] + ")", currentResult.substract(operators[i]));
                    generateExpression(operators, used, target, "(" + expression + " * " + operators[i] + ")", currentResult.multiply(operators[i]));

                    used[i] = false;
                } catch (NotSameOperatorTypeException exception) {
                    System.out.println(exception.toString());
                }
            }
        }
    }

    public void resetSolver() {
        isFound = false;
        bestExpression = null;
        bestDistance = Double.POSITIVE_INFINITY;
    }

}

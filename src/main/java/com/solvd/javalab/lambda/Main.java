package com.solvd.javalab.lambda;

import java.util.ArrayList;
import java.util.function.*;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Predicate<Integer> predicate = x -> x > 5;
        log.info("Predicate = " + predicate.test(7));

        UnaryOperator<Double> sqrt = value -> Math.sqrt(value);
        log.info("sqrt = " + sqrt.apply(144.0));

        ISquare square = (val1, val2) -> val1 * val2;
        log.info("Result square = " + square.getSquare(3.0, 3.0));

        IFactorial factorial = (value) -> {

            int result = 1;
            for (int i = 1; i <= value; i++) {
                result = result * i;
            }
            return result;
        };

        log.info("Factorial = " + factorial.getFactorial(3));

        IOperations operationSum = (value1, value2) -> value1 + value2;
        IOperations operationDiv = (value1, value2) -> value1 / value2;
        IOperations operationMul = (value1, value2) -> value1 * value2;
        IOperations operationSub = (value1, value2) -> value1 - value2;
        log.info("operationSum = " + operationSum.getOperation(7, 23));
        log.info("operationDiv = " + operationDiv.getOperation(7, 23));
        log.info("operationMul = " + operationMul.getOperation(7, 23));
        log.info("operationSub = " + operationSub.getOperation(7, 23));


        IOperationMathPi areacircle = value -> {
            double area = Math.PI * value * value;
            return area;
        };

        IOperationMathPi circumference = value -> {
            double result = Math.PI * 2 * value;
            return  result;
        };

        log.info("areacircle = " + String.format("%.2f", areacircle.getOperationMathPi(2.3)));
        log.info("circumference = " + String.format("%.2f", circumference.getOperationMathPi(5.1)));

        IAverage iAverage = value -> {

            ArrayList<Double> listnumbers = new ArrayList<>();

            for (int i = 0; i <= value-1; i++) {

                double ran = Math.random() * 100;
                listnumbers.add(ran);
            }

            int sizelist = listnumbers.size();

            double result = 0;
            for (int i = 0; i<= sizelist-1; i++) {
                result = result + listnumbers.get(i);
            }
            result = result / sizelist;
            return result;
        };

        log.info("iAverage = " + String.format("%.5f", iAverage.getAverageArray(3)));

    }

}

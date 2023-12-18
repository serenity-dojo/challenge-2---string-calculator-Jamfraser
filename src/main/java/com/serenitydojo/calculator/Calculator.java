package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class Calculator {
    public int evaluate(String expression) {
        // check if the input expression is empty and return zero if so
        if(StringUtils.isBlank(expression)) {
            return 0;
        }

        // tokenize the expression - split it into an array of token based on whitespace operators
        // will allow us to iterate through numbers and operators in the input expression
        String [] tokens = expression.split("\\s+");

        // if the expression contains only one token, return the numerical value of that token from the array
        if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        // initialize variables for the result, the current number being processed and the current operator
        int result = 0;
        int currentNumber = 0;
        String operator = "+";

        // loop through each token in the array
        for (String token : tokens)
            // check if the current token is a number
            if (isNumber(token)) {
                // convert the number token to an integer
                int num = Integer.parseInt(token);
                // switch statement to perform calculations based on the current operator
                switch (operator) {
                    // addition case
                    case "+":
                        // add the current number to our result
                        result += currentNumber;
                        // update the current number to the new number
                        currentNumber = num;
                        break;
                    // subtraction case
                    case "-":
                        // accumulate subtraction operations in currentNumber variable
                        currentNumber -= num;
                        break;
                    // multiplication case
                    case "*":
                        // multiply current number by the new number
                        // accumulate our product in currentNumber variable
                        currentNumber *= num;
                        break;
                    default:
                        throw new IllegalMathsOperatorException("Unknown operator symbol: " + operator);
                }
                // if the current token is not a number, then it is an operator
                // update the operator variable accordingly
            } else {
                operator = token;
            }
        // return the final result
        return result + currentNumber;
    }
}

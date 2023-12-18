package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenDoingMaths {
    // create a calculator to use in all our tests
    Calculator calculator = new Calculator();

    @Test
    public void shouldReturnZeroForAnEmptyString() {
        // make sure we are returning zero for an empty string
        assertThat(calculator.evaluate("")).isEqualTo(0);
    }

    @Test(expected = IllegalMathsOperatorException.class)
    public void shouldReportNonSupportedOperations() {
        // attempt unrecognized operators to throw the expected exception
        calculator.evaluate("4 / 2");
        calculator.evaluate("1 ^ 2");
    }

    @Test
    public void shouldReturnTheValueOfASingleNumber() {
        // assert that a single number returns its value
        assertThat(calculator.evaluate("1")).isEqualTo(1);
        assertThat(calculator.evaluate("10")).isEqualTo(10);
    }

    @Test
    public void shouldAddTwoNumbers() {
        // make assertions to test adding two numbers together
        assertThat(calculator.evaluate("1 + 1")).isEqualTo(2);
        assertThat(calculator.evaluate("9 + 6")).isEqualTo(15);
        assertThat(calculator.evaluate("104 + 23")).isEqualTo(127);
    }

    @Test
    public void shouldAddThreeNumbers() {
        // make assertions to test adding three numbers together
        assertThat(calculator.evaluate("1 + 2 + 3")).isEqualTo(6);
        assertThat(calculator.evaluate("10 + 20 + 30")).isEqualTo(60);
        assertThat(calculator.evaluate("111 + 222 + 333")).isEqualTo(666);
    }

    @Test
    public void shouldAlsoSubtract() {
        // make assertions to test subtracting different numbers
        assertThat(calculator.evaluate("10 - 6")).isEqualTo(4);
        assertThat(calculator.evaluate("35 - 21")).isEqualTo(14);
        assertThat(calculator.evaluate("100 - 60 - 20")).isEqualTo(20);
    }

    @Test
    public void shouldAddAndSubtract() {
        // make assertions to test adding and subtracting in the same expression
        assertThat(calculator.evaluate("10 + 5 - 6")).isEqualTo(9);
        assertThat(calculator.evaluate("38 + 9 - 7")).isEqualTo(40);
        assertThat(calculator.evaluate("100 + 528 - 35")).isEqualTo(593);
    }

    @Test
    public void shouldMultiplyNumbers() {
        // make assertions to test using multiplication in expressions
        assertThat(calculator.evaluate("10 * 5")).isEqualTo(50);
        assertThat(calculator.evaluate("10 + 5 * 4")).isEqualTo(30);
        assertThat(calculator.evaluate("20 * 2 - 13")).isEqualTo(27);
    }
}

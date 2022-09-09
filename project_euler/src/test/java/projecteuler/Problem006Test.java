package projecteuler;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem006Test {

    @Test
    public void solution1Test() {
        assertEquals(2640.0, solve(10), 0.0);
        assertEquals(25164150.0, solve(100), 0.0);
    }

    public double solve(int n) {
        return sumOfSquares(n) - squareOfSum(n);
    }

    public double sumOfSquares(int n) {
        int sum = (n * (n + 1)) / 2;
        return Math.pow(sum, 2);
    }

    public double squareOfSum(double n) {
        return (2 * n + 1) * (n + 1) * (n / 6);
    }

}

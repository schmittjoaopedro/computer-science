package projecteuler;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://projecteuler.net/problem=1
 * https://projecteuler.net/thread=1
 */
public class Problem001Test {

    // O(1) solution
    @Test
    public void arithmeticProgressionSolution() {
        // All numbers below 1000
        long x = 999;

        /* Base knowledge to solve this problem:
        Arithmetic progression (AR): a_n = a(n-1)d
        Where:
        a = initial value
        n = n-th term
        d = common difference
         */

        // Formula to discover the sum of {a, a+d, a+2d, ...}: (n/2)(a+l),
        // Where:
        // n = number of terms
        // a = first term
        // l = last term

        // To discover number of terms, n, use AR formula:
        //     a + (n - 1)d = x
        //     n = int((x - a)/d + 1)
        // To simplify as in this problem a = d
        //     n = int(x/d)

        // To discover last term, l
        //     l = d*n, because a = d
        //     l = a*n

        // To find the sum
        //     S = (n/2)(a+l), because n = int(x/d)
        //     S = (int(x/d)/2)(a+l), because l = a*n
        //     S = (int(x/d)/2)(a+a*n), because n = int(x/d)
        //     S = (int(x/a)/2)(a+a*int(x/a))

        // Solving for a = 3
        int a = 3;
        int S3 = (int) (((int)(x/a) / 2.0) * (a + a * (int)(x/a)));

        // Solving for a = 5
        a = 5;
        long S5 = (int) (((int)(x/a) / 2.0) * (a + a * (int)(x/a)));

        // However, how the series contains multiples of 15 in common:
        // (3,6,9,12,15,...) and (5,10,15,...) we subtract once
        // Solving for a = 15
        a = 15;
        long S15 = (int) (((int)(x/a) / 2.0) * (a + a * (int)(x/a)));

        long solution = S3 + S5 - S15;
        Assert.assertEquals(233168, solution);
    }

    // O(n) solution
    @Test
    public void trivialSolution() {
        // All numbers below 1000
        int a1 = 0;
        int n = 999;

        // O(n)
        long sum = 0;
        for (int i = a1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }

        long solution = sum;
        Assert.assertEquals(233168, solution);
    }

}

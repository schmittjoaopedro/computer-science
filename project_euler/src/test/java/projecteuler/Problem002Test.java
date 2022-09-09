package projecteuler;

import org.junit.Assert;
import org.junit.Test;

public class Problem002Test {

    @Test
    public void trivialSolutionTest() {
        int term1 = 1;
        int term2 = 1;
        long sum = 0;
        // O(n)
        while (term2 < 4_000_000) {
            int next = term1 + term2;
            term1 = term2;
            term2 = next;
            if (next % 2 == 0) {
                sum += next;
            }
        }
        Assert.assertEquals(sum, 4613732);
    }

    @Test
    public void optimizedSolutionTest() {
        // F_n = round(g^n / 5^(1/2))
        // F_n < 4_000_000
        Assert.assertEquals(getFibonacciAt(1), 1);
        Assert.assertEquals(getFibonacciAt(2), 1);
        Assert.assertEquals(getFibonacciAt(3), 2);
        Assert.assertEquals(getFibonacciAt(4), 3);
        Assert.assertEquals(getFibonacciAt(5), 5);
        Assert.assertEquals(getFibonacciAt(6), 8);
        Assert.assertEquals(getFibonacciAt(7), 13);

        /*
         F_n = round(g^n / 5^(1/2))
         F_n < 4_000_000

         round(g^n / sqrt(5)) < 4_000_000
         g^n / sqrt(5) < 4_000_000
         g^n < 4_000_000 * sqrt(5)
         n < log_(g) 4_000_000 * sqrt(5)
         */
        double goldRatio = (1 + Math.sqrt(5)) / 2.0;
        int n_max = (int) (Math.log(4_000_000 * Math.sqrt(5)) / Math.log(goldRatio));

        // Every third term of fibonacci is even
        int sum = 0;
        int start = 0;
        int stop = n_max / 3;
        for (int i = start; i <= stop; i++) {
            sum += getFibonacciAt(i * 3);
        }
        Assert.assertEquals(sum, 4613732);
    }

    private long getFibonacciAt(int nth) {
        double goldRatio = (1 + Math.sqrt(5)) / 2.0;
        return Math.round(Math.pow(goldRatio, nth) / Math.sqrt(5));
    }

}

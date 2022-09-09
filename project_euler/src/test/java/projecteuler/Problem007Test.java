package projecteuler;

import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class Problem007Test {

    @Test
    public void solutionTest() {
        assertEquals(13, solve(6));
        assertEquals(104743, solve(10_001));
    }

    public long solve(final long n) {
        long count = 0;
        long primeNumber = 1;
        while (count < n) {
            primeNumber++;
            if (isPrime(primeNumber)) {
                count++;
            }
        }
        return primeNumber;
    }

    private boolean isPrime(final double number) {
        double divisor = 2.0;
        double factoredNumber = number;
        while (factoredNumber > 1.0) {
            if (0 == (factoredNumber % divisor)) {
                break;
            }
            divisor++;
        }
        return divisor == number;
    }

}

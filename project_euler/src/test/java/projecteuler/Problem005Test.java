package projecteuler;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/*
2520 is the smallest number that can be divided by each of the numbers
from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of
the numbers from 1 to 20?
 */
public class Problem005Test {

    @Test
    public void solution1Test() {
        assertEquals(2520L, findSolution(1, 10));
        assertEquals(232792560L, findSolution(1, 20));
        assertEquals(2329089562800L, findSolution(1, 30));
    }

    public long findSolution(int min, int max) { // O(n^2)
        // n = max - min
        long smallestNumber = 1;
        Map<Long, Long> primesCount = new HashMap<>();
        for (int i = min; i <= max; i++) { // O(n)
            findAllPrimes(i).forEach((prime, count) -> // O(n)
                primesCount.compute(prime, (key, val) -> val == null ? count : Math.max(count, val)) // O(1)
            );

        }
        for (Map.Entry<Long, Long> entry : primesCount.entrySet()) { // O(n)
            long prime = entry.getKey();
            long count = entry.getValue();
            smallestNumber = smallestNumber * (long) Math.pow(prime, count);
        }
        return smallestNumber;
    }

    private Map<Long, Long> findAllPrimes(double number) { // O(n)
        Map<Long, Long> primesCount = new HashMap<>();
        double divisor = 2.0;
        while (number > 1.0) { // O(n)
            if (0 == (number % divisor)) {
                number = number / divisor;
                primesCount.compute((long) divisor, (key, val) -> val == null ? 1 : ++val);
                divisor--;
            }
            divisor++;
        }
        return primesCount;
    }

}

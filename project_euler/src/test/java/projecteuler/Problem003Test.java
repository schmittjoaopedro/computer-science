package projecteuler;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003Test {

    @Test
    public void sampleScenariosTest() {
        Assert.assertEquals(29.0, bottomUp(13195), 0.0);
        Assert.assertEquals(6857.0, bottomUp(600851475143.0), 0.0);
    }

    private double bottomUp(double number) {
        double divisor = 2.0;
        while (number > 1.0) {
            if (0 == (number % divisor)) {
                number = number / divisor;
                divisor--;
            }
            divisor++;
        }
        return divisor;
    }

}

package projecteuler;

import org.junit.Test;
import static org.junit.Assert.*;

/*
A palindromic number reads the same both ways. The largest palindrome
made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem004Test {

    @Test
    public void solution1Test() {
        assertEquals("9 = 1 * 9", bruteForceSolution(1));
        assertEquals("9009 = 91 * 99", bruteForceSolution(2));
        assertEquals("906609 = 913 * 993", bruteForceSolution(3));
    }

    public String bruteForceSolution(int n) {
        // n = is the number of digits
        // Permutations: 100 -> 999 = 899^2 - 899 = O(10^n)
        // Checking: O(2n)
        // O(10^n) * O(2n) = O(10^n * n) = O(10^n)
        int first = (int) Math.pow(10, n-1);
        int last = (int) Math.pow(10, n) - 1;
        int term1 = 0, term2 = 0, maxProduct = 0;
        for (int i = first; i <= last; i++) {
            for (int j = i; j <= last; j++) {
                int result = i * j;
                if (isPalindrome(result) && result > maxProduct) {
                    maxProduct = result;
                    term1 = i;
                    term2 = j;
                    System.out.println(maxProduct + " = " + term1 + " * " + term2);
                }
            }
        }
        return maxProduct + " = " + term1 + " * " + term2;
    }

    private boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        boolean isPalindrome = true;
        // 9009 = 4/2 = (int) 2 = 2
        // 19091 = 5/2 = (int) 2.5 = 2
        int stopPoint = (numStr.length() / 2);
        for (int i = 0; i < stopPoint; i++) {
            isPalindrome = isPalindrome &&
                    numStr.charAt(i) == numStr.charAt(numStr.length() - 1 - i);
            if (!isPalindrome) {
                break;
            }
        }
        return isPalindrome;
    }

}

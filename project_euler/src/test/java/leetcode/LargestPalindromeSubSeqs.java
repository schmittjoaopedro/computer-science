package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LargestPalindromeSubSeqs {

    @Test
    public void test() {
        Assert.assertEquals(25, maxProduct("accbcaxxcxx"));
    }

    public int maxProduct(String text) {
        int maxProduct = 0;
        if (text.length() > 1) {
            List<Set<Integer>> subSets = new ArrayList<>();
            for (int size = 1; size <= text.length(); size++) {
                findAllSubSequences(text, "", new Stack<>(), 0, size, subSets);
            }
            maxProduct = findBiggestProduct(subSets);
        }
        return maxProduct;
    }

    private void findAllSubSequences(String word, String subWord, Stack<Integer> indexes, int start, int size, List<Set<Integer>> subSets) {
        if (subWord.length() < size) {
            for (int i = start; i < word.length(); i++) {
                indexes.push(i);
                findAllSubSequences(word, subWord + word.charAt(i), indexes, i + 1, size, subSets);
                indexes.pop();
            }
        } else if (isPalindrome(subWord)) {
            subSets.add(new HashSet<>(indexes));
            System.out.println(subWord);
        }
    }

    private int findBiggestProduct(List<Set<Integer>> subSets) {
        int maxProd = 0;
        for (int i = 0; i < subSets.size(); i++) {
            Set<Integer> s1 = subSets.get(i);
            for (int j = i+1; j < subSets.size(); j++) {
                Set<Integer> s2 = subSets.get(j);
                if (arePartitioned(s1, s2)) {
                    maxProd = Math.max(maxProd, s1.size() * s2.size());
                }
            }
        }
        return maxProd;
    }

    public boolean isPalindrome(String text) {
        int forward = 0;
        int backward = text.length() - 1;
        while (backward > forward) {
            char forwardChar = text.charAt(forward++);
            char backwardChar = text.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    private boolean arePartitioned(Set<Integer> s1, Set<Integer> s2) {
        for (Integer n : s1) {
            if (s2.contains(n)) {
                return false;
            }
        }
        return true;
    }
}

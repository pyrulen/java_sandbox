package dev.pyrulen.leet.palindrome;

import dev.pyrulen.permutations.RecursivePermutationProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPalindromesTest {
    @Test
    public void maxPalindromesGet1() {
        MaxPalindromes instance = new MaxPalindromes(new RecursivePermutationProvider());
        char[][] args = new char[][]{
                new char[]{'m', 'a', 'a', 'm'},
                new char[]{'s', 'a', 's'},
                new char[]{'b', 'b'}
        };
        int expected = 3;
        assertEquals(expected, instance.get(args));
    }

    @Test
    public void maxPalindromesGet2() {
        MaxPalindromes instance = new MaxPalindromes(new RecursivePermutationProvider());
        char[][] args = new char[][]{
                new char[]{'a', 'a', 'a', 'b'},
                new char[]{'b', 'm', 'm'},
                new char[]{'s', 's'}
        };
        int expected = 3;
        assertEquals(expected, instance.get(args));
    }

    @Test
    public void maxPalindromesGet3() {
        MaxPalindromes instance = new MaxPalindromes(new RecursivePermutationProvider());
        char[][] args = new char[][]{
                new char[]{'a', 'a', 'a', 'b'},
                new char[]{'b', 'z', 'm'},
                new char[]{'s', 's'}
        };
        int expected = 2;
        assertEquals(expected, instance.get(args));
    }

    @Test
    public void maxPalindromesGet4() {
        MaxPalindromes instance = new MaxPalindromes(new RecursivePermutationProvider());
        char[][] args = new char[][]{
                new char[]{'a', 'b', 'c', 'd'},
                new char[]{'e', 'f', 'g'},
                new char[]{'h', 'i'}
        };
        int expected = 0;
        assertEquals(expected, instance.get(args));
    }
}

package dev.pyrulen.leet.palindrome;

import dev.pyrulen.permutations.PermutationProvider;

/**
 * Given an array of char arrays, find the maximum number of palindromes given any number of character swaps between arrays.
 *
 * This was originally presented with a focus on a "swap" method, such that for i, j, x, y with such restrictions that
 * i and j were a first index and then x and y were indices into the sub arrays and in bounds for those sub arrays. You
 * could make any number of swaps and test for the number of palindromes where each sub array is treated as a word.
 *
 * This really served to distract from the core problem of iteration and that it was merely permutations. This is a case
 * of being a bit upset with mysself, so here's a clean solution to that problem.
 */
public class MaxPalindromes {

    PermutationProvider provider;

    public MaxPalindromes(PermutationProvider provider) {
        this.provider = provider;
    }

    public int get(char[][] args) {
        int length = 0;
        char[][] workingCopy = new char[args.length][];
        for (int i = 0; i < args.length; i++) {
            length += args[i].length;
            workingCopy[i] = new char[args[i].length];
        }
        char[] characterSet = new char[length];
        int characterSetIndex = 0;
        for (int i = 0; i < args.length; i++) {
            System.arraycopy(args[i], 0, characterSet, characterSetIndex, args[i].length);
            characterSetIndex += args[i].length;
        }
        return provider.getPermutations(characterSet).stream().map( word -> {
            char[] characterSetPermutation = word.toCharArray();
            int characterSetPermutationIndex = 0;
            int palindromeCount = 0;
            for(int i = 0; i < workingCopy.length; i++){
                System.arraycopy(characterSetPermutation, characterSetPermutationIndex, workingCopy[i], 0, workingCopy[i].length);
                characterSetPermutationIndex += workingCopy[i].length;
            }
            for(int i = 0; i < workingCopy.length; i++){
                if(isPalindrome(workingCopy[i])){
                    palindromeCount++;
                }
            }
            return palindromeCount;
        }).max(Integer::compareTo).orElse(0);
    }

    private Boolean isPalindrome(char[] word) {
        for (int i = 0; i <= word.length / 2; i++) {
            if (word[i] != word[word.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

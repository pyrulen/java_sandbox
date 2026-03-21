package dev.pyrulen.permutations;

import java.util.HashSet;
import java.util.Set;

public class RecursivePermutationProvider implements PermutationProvider {
    @Override
    public Set<char[]> getPermutations(char[] source) {
        Set<char[]> results = new HashSet<>();
        if (source.length == 0) {
            return Set.of(new char[]{});
        }
        for(int i = 0; i < source.length; i++) {
            char c =  source[i];
            char[] remainder = new char[source.length-1];
            for(int j = 0, k = 0; j < source.length; j++) {
                if(i != j) {
                    remainder[k++] = source[j];
                }
            }
            Set<char[]> childPermutations = getPermutations(remainder);
            for(char[] child : childPermutations) {
                char[] permutation = new char[child.length + 1];
                permutation[0] = c;
                System.arraycopy(child, 0, permutation, 1, child.length);
                results.add(permutation);
            }
        }
        return results;
    }
}

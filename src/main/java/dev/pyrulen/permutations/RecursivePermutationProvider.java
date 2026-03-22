package dev.pyrulen.permutations;

import java.util.HashSet;
import java.util.Set;

public class RecursivePermutationProvider implements PermutationProvider {
    @Override
    public Set<String> getPermutations(char[] source) {
        Set<String> results = new HashSet<>();
        if (source.length == 0) {
            return Set.of("");
        }
        for(int i = 0; i < source.length; i++) {
            char c =  source[i];
            char[] remainder = new char[source.length-1];
            for(int j = 0, k = 0; j < source.length; j++) {
                if(i != j) {
                    remainder[k++] = source[j];
                }
            }
            Set<String> childPermutations = getPermutations(remainder);
            for(String child : childPermutations) {
                results.add(c + child);
            }
        }
        return results;
    }
}

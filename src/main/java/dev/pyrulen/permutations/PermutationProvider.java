package dev.pyrulen.permutations;

import java.util.Set;

public interface PermutationProvider {
    Set<String> getPermutations(char[] source);
}

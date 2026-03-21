package dev.pyrulen.permutations;

import java.util.Set;

public interface PermutationProvider {
    Set<char[]> getPermutations(char[] source);
}

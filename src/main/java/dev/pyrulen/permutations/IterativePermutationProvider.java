package dev.pyrulen.permutations;

import java.util.HashSet;
import java.util.Set;

public class IterativePermutationProvider implements PermutationProvider {
    @Override
    public Set<char[]> getPermutations(char[] source) {
        Set<char[]> result = new HashSet<>();
        int[] p = new int[source.length];
        int i = 0;
        char[] workingCopy = new char[source.length];
        System.arraycopy(source, 0, workingCopy, 0, source.length);
        char[] sourceCopy = new char[source.length];
        System.arraycopy(source, 0, sourceCopy, 0, source.length);
        result.add(sourceCopy);
        while (i < workingCopy.length) {
            if (p[i] < i) {
                int j = i % 2 * p[i];
                workingCopy[i] = (char)(workingCopy[j] + workingCopy[i]);
                workingCopy[j] = (char)(workingCopy[i] - workingCopy[j]);
                workingCopy[i] = (char)(workingCopy[i] - workingCopy[j]);
                char[] permutation = new char[workingCopy.length];
                System.arraycopy(workingCopy, 0, permutation, 0, workingCopy.length);
                result.add(permutation);
                p[i] = p[i] + 1;
                i = 1;
            } else {
                p[i] = 0;
                i++;
            }
        }
        return result;
    }
}

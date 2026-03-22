package dev.pyrulen.permutations;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.quickperm.org/quickperm.html
 *
 * credit Phillip Paul Fuchs
 */
public class IterativePermutationProvider implements PermutationProvider {
    @Override
    public Set<String> getPermutations(char[] source) {
        Set<String> result = new HashSet<>();
        int[] p = new int[source.length];
        int i = 0;
        char[] workingCopy = new char[source.length];
        System.arraycopy(source, 0, workingCopy, 0, source.length);
        result.add(new String(source));
        while (i < workingCopy.length) {
            if (p[i] < i) {
                int j = i % 2 * p[i];
                workingCopy[i] = (char)(workingCopy[j] + workingCopy[i]);
                workingCopy[j] = (char)(workingCopy[i] - workingCopy[j]);
                workingCopy[i] = (char)(workingCopy[i] - workingCopy[j]);
                result.add(new String(workingCopy));
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

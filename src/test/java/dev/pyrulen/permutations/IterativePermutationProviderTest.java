package dev.pyrulen.permutations;

public class IterativePermutationProviderTest extends PermutationProviderTest {
    @Override
    protected PermutationProvider getProvider() {
        return new IterativePermutationProvider();
    }
}

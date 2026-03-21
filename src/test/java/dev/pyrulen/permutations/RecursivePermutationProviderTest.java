package dev.pyrulen.permutations;

public class RecursivePermutationProviderTest extends PermutationProviderTest {
    @Override
    protected PermutationProvider getProvider() {
        return new RecursivePermutationProvider();
    }
}

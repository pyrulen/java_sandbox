package dev.pyrulen.permutations;

public class StreamingPermutationProviderTest extends PermutationProviderTest {
    @Override
    protected PermutationProvider getProvider() {
        return new StreamingPermutationProvider();
    }
}

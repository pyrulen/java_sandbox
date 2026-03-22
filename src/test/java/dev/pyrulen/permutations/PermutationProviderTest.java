package dev.pyrulen.permutations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PermutationProviderTest {

    protected PermutationProvider provider;

    protected abstract PermutationProvider getProvider();

    @BeforeEach
    public void setup() {
        this.provider = this.getProvider();
    }

    @Test
    public void getPermutationsTest() {
        String source = "1234";
        Set<String> expected = Set.of(
                "1243",
                "1234",
                "1423",
                "1432",
                "1324",
                "1342",
                "2143",
                "2134",
                "2413",
                "2431",
                "2314",
                "2341",
                "4123",
                "4132",
                "4213",
                "4231",
                "4312",
                "4321",
                "3124",
                "3142",
                "3214",
                "3241",
                "3412",
                "3421"
        );
        Set<String> actual = provider.getPermutations(source.toCharArray());
        assertEquals(expected, actual);
    }
}

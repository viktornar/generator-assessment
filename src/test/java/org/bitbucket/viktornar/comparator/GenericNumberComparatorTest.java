package org.bitbucket.viktornar.comparator;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.bitbucket.viktornar.comparator.type.ComparatorType;
import org.bitbucket.viktornar.generator.NumberGenerator;
import org.bitbucket.viktornar.generator.SimpleNumberGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericNumberComparatorTest {
    private GenericNumberComparator numberComparator;
    private SimpleNumberGenerator simpleNumberGeneratorB;
    private SimpleNumberGenerator simpleNumberGeneratorA;
    Pair<NumberGenerator, NumberGenerator>[] numberGenerators = new ImmutablePair[4];

    @Before
    public void setUp() throws Exception {
        numberComparator = new GenericNumberComparator(ComparatorType.LAST_EIGHT_BITS);
        simpleNumberGeneratorA = new SimpleNumberGenerator(65L, 16807L);
        simpleNumberGeneratorB = new SimpleNumberGenerator(8921L, 48271L);

        for (int i = 0; i < 4; i++) {
            simpleNumberGeneratorA = simpleNumberGeneratorA.nextGenerator();
            simpleNumberGeneratorB = simpleNumberGeneratorB.nextGenerator();
            numberGenerators[i] = ImmutablePair.of(simpleNumberGeneratorA, simpleNumberGeneratorB);
        }
    }

    @Test
    public void match() {
        assertFalse(numberComparator.match(
                numberGenerators[1].getLeft(), numberGenerators[1].getRight()
        ));

        assertTrue(numberComparator.match(
                numberGenerators[2].getLeft(), numberGenerators[2].getRight()
        ));
    }
}
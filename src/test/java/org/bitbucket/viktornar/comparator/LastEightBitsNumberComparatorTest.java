package org.bitbucket.viktornar.comparator;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.bitbucket.viktornar.generator.NumberGenerator;
import org.bitbucket.viktornar.generator.SimpleNumberGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastEightBitsNumberComparatorTest {
    NumberComparator numberComparator;
    SimpleNumberGenerator simpleNumberGeneratorA;
    SimpleNumberGenerator simpleNumberGeneratorB;
    Pair<NumberGenerator, NumberGenerator>[] numberGenerators = new ImmutablePair[4];

    @Before
    public void setUp() throws Exception {
        numberComparator = new LastEightBitsNumberComparator();
        simpleNumberGeneratorA = new SimpleNumberGenerator(65L, 16807L);
        simpleNumberGeneratorB = new SimpleNumberGenerator(8921L, 48271L);

        for (int i = 0; i < 4; i++) {
            simpleNumberGeneratorA = simpleNumberGeneratorA.nextGenerator();
            simpleNumberGeneratorB = simpleNumberGeneratorB.nextGenerator();
            numberGenerators[i] = ImmutablePair.of(simpleNumberGeneratorA, simpleNumberGeneratorB);
        }
    }

    @Test
    public void compare() {
        assertEquals(
                1,
                numberComparator.compare(
                        numberGenerators[0].getLeft(), numberGenerators[0].getRight()
                )
        );

        assertEquals(
                -1,
                numberComparator.compare(
                        numberGenerators[1].getLeft(), numberGenerators[1].getRight()
                )
        );

        assertEquals(
                0,
                numberComparator.compare(
                        numberGenerators[2].getLeft(), numberGenerators[2].getRight()
                )
        );
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
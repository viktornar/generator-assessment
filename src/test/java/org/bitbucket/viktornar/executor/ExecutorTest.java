package org.bitbucket.viktornar.executor;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.bitbucket.viktornar.comparator.GenericNumberComparator;
import org.bitbucket.viktornar.comparator.type.ComparatorType;
import org.bitbucket.viktornar.generator.ASimpleNumberGenerator;
import org.bitbucket.viktornar.generator.BSimpleNumberGenerator;
import org.bitbucket.viktornar.generator.NumberGenerator;
import org.bitbucket.viktornar.generator.SimpleNumberGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExecutorTest {
    private GenericNumberComparator numberComparator;
    private SimpleNumberGenerator simpleNumberGeneratorA;
    private SimpleNumberGenerator simpleNumberGeneratorB;
    private Executor executor;

    @Before
    public void setUp() throws Exception {
        numberComparator = new GenericNumberComparator(ComparatorType.LAST_EIGHT_BITS);
        simpleNumberGeneratorA = new ASimpleNumberGenerator(65L);
        simpleNumberGeneratorB = new BSimpleNumberGenerator(8921L);
        executor = new Executor(simpleNumberGeneratorA, simpleNumberGeneratorB, numberComparator);
    }

    @Test
    public void compare() {
        int count = executor.compare(4);
        assertEquals(1, count);
    }
}
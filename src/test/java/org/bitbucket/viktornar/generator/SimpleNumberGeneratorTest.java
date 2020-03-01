package org.bitbucket.viktornar.generator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleNumberGeneratorTest {
    SimpleNumberGenerator simpleNumberGeneratorA;
    SimpleNumberGenerator simpleNumberGeneratorB;

    @Before
    public void setUp() throws Exception {
        simpleNumberGeneratorA = new SimpleNumberGenerator(65L, 16807L);
    }

    @Test
    public void nextNumber() {
        var nextNumber = simpleNumberGeneratorA.nextNumber(simpleNumberGeneratorA.getNumber());
        var expectedNextNumber = 1092455L;
        assertEquals(expectedNextNumber, (long) nextNumber);
    }

    @Test
    public void toBinaryString() {
        var actualBinaryString = simpleNumberGeneratorA.nextGenerator().toBinaryString();
        var expectedBinaryString = "00000000000100001010101101100111";
        assertEquals(expectedBinaryString, actualBinaryString);
    }

    @Test
    public void nextGenerator() {
        simpleNumberGeneratorB = simpleNumberGeneratorA.nextGenerator().nextGenerator();

        var nextNumber = simpleNumberGeneratorB.getNumber();
        var expectedNextNumber = 1181022009L;
        assertEquals(expectedNextNumber, nextNumber);

        var actualBinaryString = simpleNumberGeneratorB.toBinaryString();
        var expectedBinaryString = "01000110011001001111011100111001";
        assertEquals(expectedBinaryString, actualBinaryString);
    }
}
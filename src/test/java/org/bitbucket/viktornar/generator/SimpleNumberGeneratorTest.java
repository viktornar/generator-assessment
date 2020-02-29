package org.bitbucket.viktornar.generator;

import junit.framework.TestCase;

public class SimpleNumberGeneratorTest extends TestCase {
    SimpleNumberGenerator simpleNumberGeneratorA;
    SimpleNumberGenerator simpleNumberGeneratorB;
    public void setUp() throws Exception {
        super.setUp();
        simpleNumberGeneratorA = new SimpleNumberGenerator(65L, 16807L, 2147483647L);
    }

    public void testNextNumber() {
        var nextNumber = simpleNumberGeneratorA.getNumber();
        var expectedNextNumber = 1092455L;
        assertEquals(expectedNextNumber, (long) nextNumber);
    }

    public void testToBinaryString() {
        var actualBinaryString = simpleNumberGeneratorA.toBinaryString();
        var expectedBinaryString = "00000000000100001010101101100111";
        assertEquals(expectedBinaryString, actualBinaryString);
    }

    public void testNextGenerator() {
        simpleNumberGeneratorB = simpleNumberGeneratorA.nextGenerator();

        var nextNumber = simpleNumberGeneratorB.getNumber();
        var expectedNextNumber = 1181022009L;
        assertEquals(expectedNextNumber, (long) nextNumber);

        var actualBinaryString = simpleNumberGeneratorB.toBinaryString();
        var expectedBinaryString = "01000110011001001111011100111001";
        assertEquals(expectedBinaryString, actualBinaryString);
    }
}
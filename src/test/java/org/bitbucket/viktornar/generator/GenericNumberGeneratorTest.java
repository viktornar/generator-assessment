package org.bitbucket.viktornar.generator;

import org.bitbucket.viktornar.generator.type.GeneratorType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericNumberGeneratorTest {
    NumberGenerator aNumberGenerator;
    NumberGenerator bNumberGenerator;

    @Before
    public void setUp() throws Exception {
        aNumberGenerator = new GenericNumberGenerator(GeneratorType.A_NUMBER_GENERATOR, 65L);
        bNumberGenerator = new GenericNumberGenerator(GeneratorType.B_NUMBER_GENERATOR, 8921L);
    }

    @Test
    public void nextGenerator() {
        long aNumber = aNumberGenerator.nextGenerator().getNumber();
        assertEquals(1092455L, aNumber);
        long bNumber = bNumberGenerator.nextGenerator().getNumber();
        assertEquals(430625591L, bNumber);
    }

    @Test
    public void nextNumber() {
        long aNumber = aNumberGenerator.nextNumber(65L);
        assertEquals(1092455L, aNumber);
        long bNumber = bNumberGenerator.nextNumber(8921L);
        assertEquals(430625591L, bNumber);
    }

    @Test
    public void toBinaryString() {
        String aBinaryString = aNumberGenerator.nextGenerator().toBinaryString();
        assertEquals("00000000000100001010101101100111", aBinaryString);
        String bBinaryString = bNumberGenerator.nextGenerator().toBinaryString();
        assertEquals("00011001101010101101001100110111", bBinaryString);
    }
}
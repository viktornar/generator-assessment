package org.bitbucket.viktornar.generator;

public class BSimpleNumberGenerator extends SimpleNumberGenerator {
    private static long B_GENERATOR_FACTOR = 48271L;
    public BSimpleNumberGenerator(long number) {
        super(number, B_GENERATOR_FACTOR);
    }

    @Override
    public String toString() {
        return String.format("BSimpleNumberGenerator{number=%s, factor=%d}",
                toBinaryString(), B_GENERATOR_FACTOR);
    }
}

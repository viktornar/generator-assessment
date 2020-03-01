package org.bitbucket.viktornar.generator;

public class ASimpleNumberGenerator extends SimpleNumberGenerator {
    private static long A_GENERATOR_FACTOR = 16807L;
    public ASimpleNumberGenerator(long number) {
        super(number, A_GENERATOR_FACTOR);
    }
}

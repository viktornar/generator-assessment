package org.bitbucket.viktornar.generator;

import org.apache.commons.lang3.StringUtils;

import static org.bitbucket.viktornar.Constants.INTEGER_SIZE_IN_BITS;
import static org.bitbucket.viktornar.Constants.INTEGER_SIZE_UPPER_BOUND;

public class SimpleNumberGenerator extends NumberGenerator {
    private final long number;
    private final long factor;

    public SimpleNumberGenerator(long number, long factor) {
        this.factor = factor;
        this.number = number;
    }

    @Override
    public SimpleNumberGenerator nextGenerator() {
        return new SimpleNumberGenerator(nextNumber(number), factor);
    }

    @Override
    public long nextNumber(long number) {
        return (number * factor) % INTEGER_SIZE_UPPER_BOUND;
    }

    @Override
    public String toBinaryString() {
        var binaryString = Long.toBinaryString(number);
        return StringUtils.leftPad(binaryString, INTEGER_SIZE_IN_BITS, "0");
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("SimpleNumberGenerator{number=%s, factor=%d}",
                toBinaryString(), factor);
    }
}

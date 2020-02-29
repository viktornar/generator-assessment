package org.bitbucket.viktornar.generator;

import org.apache.commons.lang3.StringUtils;

import static org.bitbucket.viktornar.Constants.INTEGER_SIZE_IN_BITS;

public class SimpleNumberGenerator extends NumberGenerator {
    private final Long number;
    private final Long factor;
    private final Long divider;

    public SimpleNumberGenerator(Long number, Long factor, Long divider) {
        super(number, factor, divider);
        this.factor = factor;
        this.divider = divider;
        this.number = nextNumber(number);
    }

    @Override
    public SimpleNumberGenerator nextGenerator() {
        return new SimpleNumberGenerator(number, factor, divider);
    }

    @Override
    Long nextNumber(Long number) {
        return (number * factor) % divider;
    }

    @Override
    public String toBinaryString() {
        var binaryString = Long.toBinaryString(number);
        return StringUtils.leftPad(binaryString, INTEGER_SIZE_IN_BITS, "0");
    }

    @Override
    public Long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("SimpleNumberGenerator{number=%s, factor=%d, divider=%d}",
                toBinaryString(), factor, divider);
    }
}

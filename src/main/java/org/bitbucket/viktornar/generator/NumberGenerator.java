package org.bitbucket.viktornar.generator;

public abstract class NumberGenerator {
    private final Long number;
    private final Long factor;
    private final Long divider;

    public NumberGenerator(Long number, Long factor, Long divider) {
        this.number = number;
        this.factor = factor;
        this.divider = divider;
    }

    abstract public NumberGenerator nextGenerator();
    abstract Long nextNumber(Long number);
    abstract public String toBinaryString();
    public abstract Long getNumber();
}

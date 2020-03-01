package org.bitbucket.viktornar.generator;

public abstract class NumberGenerator {
    private final long number;
    private final long factor;

    public NumberGenerator(long number, long factor) {
        this.number = number;
        this.factor = factor;
    }

    abstract public NumberGenerator nextGenerator();
    abstract public long nextNumber(long number);
    abstract public String toBinaryString();
    public abstract long getNumber();
}

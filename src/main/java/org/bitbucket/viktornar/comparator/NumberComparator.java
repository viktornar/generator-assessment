package org.bitbucket.viktornar.comparator;

import org.bitbucket.viktornar.generator.NumberGenerator;

import java.util.Comparator;

public abstract class NumberComparator implements Comparator<NumberGenerator> {
    @Override
    public int compare(NumberGenerator left, NumberGenerator right) {
        return left.toBinaryString().compareTo(right.toBinaryString());
    }

    public abstract boolean match(NumberGenerator left, NumberGenerator right);
}

package org.bitbucket.viktornar.generator;

import org.apache.commons.lang3.NotImplementedException;
import org.bitbucket.viktornar.generator.type.GeneratorType;

public class GenericNumberGenerator extends NumberGenerator {
    NumberGenerator generator;

    public GenericNumberGenerator(GeneratorType type, long number) {
        if (type == GeneratorType.A_NUMBER_GENERATOR) {
            generator = new ASimpleNumberGenerator(number);
        } else if (type == GeneratorType.B_NUMBER_GENERATOR) {
            generator = new BSimpleNumberGenerator(number);
        } else {
            throw new NotImplementedException("Generator is not implemented");
        }
    }

    @Override
    public NumberGenerator nextGenerator() {
        return generator.nextGenerator();
    }

    @Override
    public long nextNumber(long number) {
        return generator.nextNumber(number);
    }

    @Override
    public String toBinaryString() {
        return generator.toBinaryString();
    }

    @Override
    public long getNumber() {
        return generator.getNumber();
    }
}

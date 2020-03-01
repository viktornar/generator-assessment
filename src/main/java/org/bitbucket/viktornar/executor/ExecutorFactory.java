package org.bitbucket.viktornar.executor;

import org.bitbucket.viktornar.comparator.GenericNumberComparator;
import org.bitbucket.viktornar.comparator.NumberComparator;
import org.bitbucket.viktornar.comparator.type.ComparatorType;
import org.bitbucket.viktornar.generator.GenericNumberGenerator;
import org.bitbucket.viktornar.generator.NumberGenerator;
import org.bitbucket.viktornar.generator.type.GeneratorType;

public class ExecutorFactory {
    private final GeneratorType leftGeneratorType;
    private final GeneratorType rightGeneratorType;
    private final ComparatorType comparatorType;

    public ExecutorFactory(
            GeneratorType leftGeneratorType,
            GeneratorType rightGeneratorType,
            ComparatorType comparatorType
    ) {
        this.leftGeneratorType = leftGeneratorType;
        this.rightGeneratorType = rightGeneratorType;
        this.comparatorType = comparatorType;
    };

    public Executor createExecutor(
            long firstNumber,
            long secondNumber
    ) {
        NumberGenerator aNumberGenerator = new GenericNumberGenerator(GeneratorType.A_NUMBER_GENERATOR, firstNumber);
        NumberGenerator bNumberGenerator = new GenericNumberGenerator(GeneratorType.B_NUMBER_GENERATOR, secondNumber);
        NumberComparator numberComparator = new GenericNumberComparator(ComparatorType.LAST_EIGHT_BITS);
        return new Executor(aNumberGenerator, bNumberGenerator, numberComparator);
    }
}

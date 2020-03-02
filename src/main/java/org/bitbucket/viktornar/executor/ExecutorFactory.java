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
        NumberGenerator leftNumberGenerator = new GenericNumberGenerator(leftGeneratorType, firstNumber);
        NumberGenerator rightNumberGenerator = new GenericNumberGenerator(rightGeneratorType, secondNumber);
        NumberComparator numberComparator = new GenericNumberComparator(comparatorType);
        return new Executor(leftNumberGenerator, rightNumberGenerator, numberComparator);
    }
}

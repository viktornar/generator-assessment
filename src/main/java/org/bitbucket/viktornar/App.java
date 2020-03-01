package org.bitbucket.viktornar;

import org.bitbucket.viktornar.comparator.type.ComparatorType;
import org.bitbucket.viktornar.executor.Executor;
import org.bitbucket.viktornar.executor.ExecutorFactory;
import org.bitbucket.viktornar.generator.type.GeneratorType;
import org.bitbucket.viktornar.utils.CliUtils;

import static java.lang.String.format;
import static org.bitbucket.viktornar.Constants.INPUT_FIRST_NUMBER_ARG_NAME;
import static org.bitbucket.viktornar.Constants.INPUT_SECOND_NUMBER_ARG_NAME;
import static org.bitbucket.viktornar.utils.CliUtils.parseNumberFromArgument;

public class App {
    public static void main(String... args) {
        System.out.println("App is working...");
        var arguments = CliUtils.parseArguments(args);

        long firstNumber = parseNumberFromArgument(arguments, INPUT_FIRST_NUMBER_ARG_NAME);
        long secondNumber = parseNumberFromArgument(arguments, INPUT_SECOND_NUMBER_ARG_NAME);

        Executor executor =
                new ExecutorFactory(
                        GeneratorType.A_NUMBER_GENERATOR,
                        GeneratorType.B_NUMBER_GENERATOR,
                        ComparatorType.LAST_EIGHT_BITS
                ).createExecutor(firstNumber, secondNumber);

        int matches = executor.compare();

        System.out.println(
                format(
                        "With parameters %s and %s the result is %d",
                        firstNumber,
                        secondNumber,
                        matches
                )
        );
    }
}

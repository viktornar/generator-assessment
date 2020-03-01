package org.bitbucket.viktornar;

import org.bitbucket.viktornar.utils.CliUtils;

import java.util.Map;

import static java.lang.String.format;
import static org.bitbucket.viktornar.Constants.INPUT_FIRST_NUMBER_ARG_NAME;
import static org.bitbucket.viktornar.Constants.INPUT_SECOND_NUMBER_ARG_NAME;
import static org.bitbucket.viktornar.utils.CliUtils.parseNumberFromArgument;

public class App {
    public static void main(String... args) {
        System.out.println("App started");
        var arguments = CliUtils.parseArguments(args);

        long firstNumber = parseNumberFromArgument(arguments, INPUT_FIRST_NUMBER_ARG_NAME);
        long secondNumber = parseNumberFromArgument(arguments, INPUT_SECOND_NUMBER_ARG_NAME);

        System.out.println("App finished");
    }


}

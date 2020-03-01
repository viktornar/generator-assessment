package org.bitbucket.viktornar.utils;

import org.junit.Test;

import static org.bitbucket.viktornar.Constants.INPUT_FIRST_NUMBER_ARG_NAME;
import static org.bitbucket.viktornar.Constants.INPUT_SECOND_NUMBER_ARG_NAME;
import static org.junit.Assert.*;

public class CliUtilsTest {
    @Test
    public void parseNumberFromArgument() {
        var arguments = CliUtils.parseArguments("--first-number", "65", "--second-number", "85");
        var firstNumber = CliUtils.parseNumberFromArgument(arguments, INPUT_FIRST_NUMBER_ARG_NAME);
        var secondNumber = CliUtils.parseNumberFromArgument(arguments, INPUT_SECOND_NUMBER_ARG_NAME);

        assertEquals(65L, firstNumber);
        assertEquals(85L, secondNumber);
    }
}
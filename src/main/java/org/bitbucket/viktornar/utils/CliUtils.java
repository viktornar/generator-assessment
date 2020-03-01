package org.bitbucket.viktornar.utils;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class CliUtils {
    /**
     * Parse arguments by given argument list from main method
     * @param args - arguments as string array
     * @return - parsed arguments store in map to get access by key that mapped to constants
     */
    public static Map<String, String> parseArguments(String... args) {
        HashMap<String, String> arguments = new HashMap<>();

        String key = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                key = args[i].substring(2);
            } else {
                arguments.put(args[i], null);
                continue;
            }

            if ((i + 1) < args.length) {
                if (args[i + 1].charAt(0) != '-') {
                    arguments.put(key, args[i + 1]);
                    i++;
                } else {
                    arguments.put(args[i], null);
                }
            } else {
                arguments.put(args[i], null);
            }
        }
        return arguments;
    }

    /**
     * Parse arguments value by given argument list and argument name
     * @param args - arguments as string array
     * @param argumentName - argument name as a string
     * @return - parsed argument value
     */
    public static long parseNumberFromArgument(Map<String, String> args, String argumentName) {
        long firstNumber = 0L;

        if (args.get(argumentName) != null) {
            try {
                firstNumber = Long.parseLong(args.get(argumentName));
            } catch (NumberFormatException exception) {
                System.out.println(
                        format(
                                "Wrong number format for argument --%s",
                                argumentName
                        )
                );
                System.exit(0);
            }
        } else {
            System.out.println(
                    format(
                            "--%s - was not specified. Usage example: --%s [number]. Program will be terminated.",
                            argumentName,
                            argumentName
                    )
            );
            System.exit(0);
        }

        return firstNumber;
    }
}

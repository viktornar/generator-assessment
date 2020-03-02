package org.bitbucket.viktornar.utils;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class CliUtils {
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

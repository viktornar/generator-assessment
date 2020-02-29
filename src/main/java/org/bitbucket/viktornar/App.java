package org.bitbucket.viktornar;

import org.bitbucket.viktornar.utils.CliUtils;

public class App {
    public static void main(String... args) {
        var arguments = CliUtils.parseArguments(args);
        arguments.keySet().forEach(System.out::println);
        arguments.values().forEach(System.out::println);
        System.out.println("App started");
    }
}

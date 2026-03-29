package org.example;


import org.example.cli.RequestCommand;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exit = new CommandLine(new RequestCommand()).execute(args);
        System.exit(exit);
    }
}
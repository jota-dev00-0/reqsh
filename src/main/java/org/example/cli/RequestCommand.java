package org.example.cli;

import org.example.cli.requests.*;
import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(
        name = "req",
        description = "Request Main Command",
        subcommands = {
                Get.class,
                Post.class,
                Put.class,
                Delete.class
        }
)
public class RequestCommand {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new RequestCommand()).execute(args);
        System.exit(exitCode);
    }
}

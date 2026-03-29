package org.example.cli.requests;

import org.example.service.HttpService;
import org.example.util.JsonFormatter;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(
        name = "get",
        description = "Get Request"
)
public class Get implements Runnable{

    @Parameters(index = "0", description = "API's URI")
    private String url;

    @Override
    public void run() {
        HttpService httpService = new HttpService();
        try {
            String content = httpService.get(url);
            System.out.println(JsonFormatter.format(content));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

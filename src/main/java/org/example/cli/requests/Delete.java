package org.example.cli.requests;

import org.example.service.HttpService;
import org.example.util.JsonFormatter;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.IOException;

@Command(
        name = "delete",
        description = "Delete Request"

)
public class Delete implements Runnable {

    @Parameters(index = "0", description = "URL's API")
    private String url;

    @Option(names = {"-i", "--id"}, description = "id for delete", required = true)
    private Integer id;

    @Override
    public void run() {
        HttpService httpService = new HttpService();
        try {
            String content = httpService.delete(url, id);
            System.out.println(JsonFormatter.format(content));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

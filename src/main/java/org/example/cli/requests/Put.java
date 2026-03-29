package org.example.cli.requests;

import org.example.service.HttpService;
import org.example.util.JsonFormatter;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(
        name = "put",
        description = "Put Request"
)
public class Put implements Runnable {

    @Parameters(index = "0", description = "URL's API")
    private String url;

    @Option(names = {"-i", "--id"}, description = "user's Id", required = true)
    private Integer id;

    @Option(names = {"-d", "--data"}, description = "new data", required = true)
    private String newData;

    @Override
    public void run() {
        HttpService service = new HttpService();
        try {
            String content = service.put(url, id, newData);
            System.out.println(JsonFormatter.format(content));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

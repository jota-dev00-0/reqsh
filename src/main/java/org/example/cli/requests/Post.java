package org.example.cli.requests;

import org.example.service.HttpService;
import org.example.util.JsonFormatter;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(
        name = "post",
        description = "Post Request"
)
public class Post implements Runnable{

    @Parameters(index = "0", description = "API's URL")
    private String url;

    @Option(names = {"-d", "--data"},description = "data",required = true)
    private String data;

    @Override
    public void run() {
        HttpService service = new HttpService();
        try {
            String content = service.post(url, data);
            System.out.println(JsonFormatter.format(content));
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.service;

import com.sun.net.httpserver.Request;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import java.net.http.HttpRequest.*;

public class HttpService {

    HttpClient httpClient = HttpClient.newHttpClient();

    public String get(String uri) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String content = response.body();
        return content;
    }

    public String post(String uri, String data) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(BodyPublishers.ofString(data))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String content = response.body();
        return content;
    }

    public String put(String uri, Integer id, String newData) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri + id))
                .PUT(BodyPublishers.ofString(newData))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String content = response.body();
        return content;
    }

    public String delete(String url, Integer id) throws IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url + id))
                .DELETE()
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String content = response.body();
        return content;
    }
}

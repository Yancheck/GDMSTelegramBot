package org.superwarden.gdmstelegrambot.spring.difficulty;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GdLvlsManager {
    public static int getDemonListLvlCount() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://demonlist.org"))
                .GET()
                .build();

        System.out.println("Getting response");

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.body());

        JsonNode dataNode = rootNode.get("data");
        if (dataNode != null && dataNode.isArray()) {
            System.out.println("All levels cnt: " + dataNode.size());
            return dataNode.size();
        }
        else {
            System.out.println("Invalid data node");
            return -1;
        }
    }
}

package com.luisdias.projeto_integrador_iv_b.web.model.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiHttpRequest implements ApiHttpInterface {
    private final ObjectMapper mapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public <T> HttpRequest createRequest(String endpoint, String method, T body) {
        try {
            String apiPJUrl = "http://localhost:8080/api/clientes";
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(apiPJUrl + endpoint))
                    .header("Content-Type", "application/json");

            switch (method) {
                case "GET" -> builder.GET();
                case "POST" -> builder.POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body)));
                case "PUT" -> builder.PUT(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body)));
                case "DELETE" -> builder.DELETE();
            }
            return builder.build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar objeto para JSON: " + e.getMessage(), e);
        }
    }

    @Override
    public <T> T sendRequest(HttpRequest request, TypeReference<T> typeReference) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return HttpStatus.NO_CONTENT.equals(HttpStatus.valueOf(response.statusCode())) ?
                    null : mapper.readValue(response.body(), typeReference);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error during HTTP request", e);
        }
    }
}

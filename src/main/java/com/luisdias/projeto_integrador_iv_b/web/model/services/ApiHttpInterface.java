package com.luisdias.projeto_integrador_iv_b.web.model.services;

import com.fasterxml.jackson.core.type.TypeReference;

import java.net.http.HttpRequest;

/**
 * Interface de comunicação HTTP com o back-end.
 */
public interface ApiHttpInterface {

    /**
     * Cria uma requisição HTTP com base nos parâmetros fornecidos.
     *
     * @param <T>      Tipo do corpo da requisição.
     * @param endpoint Endpoint específico da API.
     * @param method   Método HTTP (GET, POST, PUT, DELETE).
     * @param body     Corpo da requisição (pode ser null para GET e DELETE).
     * @return Uma instância de HttpRequest.
     */
    <T> HttpRequest createRequest(String endpoint, String method, T body);

    /**
     * Envia a requisição HTTP e processa a resposta.
     *
     * @param <T>           Tipo esperado na resposta.
     * @param request       Requisição HTTP a ser enviada.
     * @param typeReference Referência de tipo para a resposta esperada.
     * @return Resposta convertida para o tipo especificado.
     */
    <T> T sendRequest(HttpRequest request, TypeReference<T> typeReference);
}

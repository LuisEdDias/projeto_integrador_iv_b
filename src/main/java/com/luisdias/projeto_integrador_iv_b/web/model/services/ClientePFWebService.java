package com.luisdias.projeto_integrador_iv_b.web.model.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.luisdias.projeto_integrador_iv_b.web.dtos.*;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.List;

@Service
public class ClientePFWebService implements com.luisdias.projeto_integrador_iv_b.web.controllers.pessoafisica.ClientePFWebService {
    private final ApiHttpInterface apiRequest;

    public ClientePFWebService(ApiHttpInterface apiRequest) {
        this.apiRequest = apiRequest;
    }

    @Override
    public List<ClientePfDTO> getAll() {
        HttpRequest request = apiRequest.createRequest("/pessoas", "GET", null);
        return apiRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public ClientePfDTO getById(Long id) {
        HttpRequest request = apiRequest.createRequest("/pessoas/" + id, "GET", null);
        return apiRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public ClientePfDTO create(PessoaDTO pessoa) {
        HttpRequest request = apiRequest.createRequest("/pessoas", "POST", pessoa);
        return apiRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public void update(long id, PessoaDTO pessoa) {
        HttpRequest request = apiRequest.createRequest("/pessoas/" + id, "PUT", pessoa);
        apiRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public void updateAddress(long id, EnderecoDTO endereco) {
        HttpRequest request = apiRequest.createRequest("/pessoas/" + id + "/endereco", "PUT", endereco);
        apiRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public void delete(long id) {
        HttpRequest request = apiRequest.createRequest("/pessoas/" + id, "DELETE", null);
        apiRequest.sendRequest(request, new TypeReference<>() {});
    }
}

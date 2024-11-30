package com.luisdias.projeto_integrador_iv_b.web.model.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.luisdias.projeto_integrador_iv_b.web.dtos.*;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.List;

@Service
public class ClientePJWebService implements com.luisdias.projeto_integrador_iv_b.web.controllers.pessoajuridica.ClientePJWebService {
    private final ApiHttpInterface apiHttpRequest;

    public ClientePJWebService(ApiHttpInterface apiHttpRequest) {
        this.apiHttpRequest = apiHttpRequest;
    }

    @Override
    public List<ClientePjDTO> getAll() {
        HttpRequest request = apiHttpRequest.createRequest("/empresas", "GET", null);
        return apiHttpRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public ClientePjDTO getById(String id) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas/" + id, "GET", null);
        return apiHttpRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public ClientePjDTO create(EmpresaDTO empresa) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas", "POST", empresa);
        return apiHttpRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public void updateEndereco(String id, EnderecoDTO endereco) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas/" + id + "/endereco", "PUT", endereco);
        apiHttpRequest.sendRequest(request, new TypeReference<>() {});
    }

    @Override
    public void updateEnderecoProprietario(String id, EnderecoDTO endereco) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas/" + id + "/proprietario/endereco", "PUT", endereco);
        apiHttpRequest.sendRequest(request, new TypeReference<>() {
        });
    }

    @Override
    public void updateDadosProprietario(String id, PessoaDTO pessoa) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas/" + id + "/proprietario", "PUT", pessoa);
        apiHttpRequest.sendRequest(request, new TypeReference<>() {
        });
    }

    @Override
    public void newProprietario(String id, PessoaDTO pessoa) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas/" + id + "/proprietario", "POST", pessoa);
        apiHttpRequest.sendRequest(request, new TypeReference<>() {
        });
    }

    @Override
    public void delete(String id) {
        HttpRequest request = apiHttpRequest.createRequest("/empresas/" + id, "DELETE", null);
        apiHttpRequest.sendRequest(request, new TypeReference<Void>() {});
    }
}

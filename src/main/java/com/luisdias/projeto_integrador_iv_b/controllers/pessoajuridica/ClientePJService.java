package com.luisdias.projeto_integrador_iv_b.controllers.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.dtos.pessoajuridica.ClientePJGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;

import java.util.List;

public interface ClientePJService {
    List<ClientePJGetDTO> getAll();
    ClientePJGetDTO getById(String id);
    ClientePJGetDTO create(EmpresaCreateDTO empresaCreateDTO);
    ClientePJGetDTO updateEndereco(String id, EnderecoCreateDTO enderecoCreateDTO);
    ClientePJGetDTO updateEnderecoProprietario(String id, EnderecoCreateDTO enderecoCreateDTO);
    ClientePJGetDTO updateDadosProprietario(String id, PessoaUpdateDTO pessoaUpdateDTO);
    ClientePJGetDTO newProprietario(String id, PessoaCreateDTO pessoaCreateDTO);
    boolean delete(String id);
}

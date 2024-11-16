package com.luisdias.projeto_integrador_iv_b.services.cliente.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.dtos.cliente.pessoafisica.ClientePFGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;

import java.util.List;

public interface ClientePFServiceInterface {
    List<ClientePFGetDTO> getAll();
    ClientePFGetDTO getById(long id);
    ClientePFGetDTO create(PessoaCreateDTO createDTO);
    ClientePFGetDTO update(long id, PessoaUpdateDTO updateDTO);
    ClientePFGetDTO updateAddress(long id, EnderecoCreateDTO enderecoCreateDTO);
    boolean delete(long id);
}

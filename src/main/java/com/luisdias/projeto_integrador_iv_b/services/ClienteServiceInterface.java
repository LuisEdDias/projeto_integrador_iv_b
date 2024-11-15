package com.luisdias.projeto_integrador_iv_b.services;

import com.luisdias.projeto_integrador_iv_b.dtos.ClienteCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.EnderecoCreateDTO;

import java.util.List;

public interface ClienteServiceInterface {
    List<ClienteGetDTO> getAll();
    ClienteGetDTO getById(long id);
    ClienteGetDTO create(ClienteCreateDTO clienteCreateDTO);
    ClienteGetDTO update(long id, ClienteUpdateDTO clienteUpdateDTO);
    ClienteGetDTO updateAddress(long id, EnderecoCreateDTO enderecoCreateDTO);
    boolean delete(long id);
}

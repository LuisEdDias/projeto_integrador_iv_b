package com.luisdias.projeto_integrador_iv_b.services;

import com.luisdias.projeto_integrador_iv_b.dtos.ClienteCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteServiceInterface {
    List<ClienteGetDTO> getAll();
    ClienteGetDTO getById(int id);
    ClienteGetDTO create(ClienteCreateDTO clienteCreateDTO);
    ClienteGetDTO update(int id, ClienteUpdateDTO clienteUpdateDTO);
    boolean delete(int id);
}

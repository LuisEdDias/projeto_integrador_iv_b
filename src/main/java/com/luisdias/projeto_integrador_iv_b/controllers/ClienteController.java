package com.luisdias.projeto_integrador_iv_b.controllers;

import com.luisdias.projeto_integrador_iv_b.dtos.ClienteCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.ClienteUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.services.ClienteServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteServiceInterface clienteService;

    // Injeção de dependência via construtor
    public ClienteController(ClienteServiceInterface clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteGetDTO>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteGetDTO> getClienteById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteGetDTO> createCliente(@RequestBody @Valid ClienteCreateDTO clienteCreateDTO) {
        return ResponseEntity.ok(clienteService.create(clienteCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteGetDTO> updateCliente(@PathVariable long id, @RequestBody @Valid ClienteUpdateDTO clienteUpdateDTO) {
        return ResponseEntity.ok(clienteService.update(id, clienteUpdateDTO));
    }

    @PutMapping("/{id}/endereco")
    public ResponseEntity<ClienteGetDTO> updateEndereco(@PathVariable long id, @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) {
        return ResponseEntity.ok(clienteService.updateAddress(id, enderecoCreateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable long id) {
        boolean deleted = clienteService.delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

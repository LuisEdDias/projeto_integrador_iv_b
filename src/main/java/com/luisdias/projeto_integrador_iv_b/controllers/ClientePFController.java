package com.luisdias.projeto_integrador_iv_b.controllers;

import com.luisdias.projeto_integrador_iv_b.dtos.cliente.pessoafisica.ClientePFGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;
import com.luisdias.projeto_integrador_iv_b.services.cliente.pessoafisica.ClientePFServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Classe responsável por processar a entrada de dados, valida os dados recebidos e
// chama o método adequado do Service
@RestController
@RequestMapping("/clientes")
public class ClientePFController {
    // Declaração da dependência da interface de serviço
    private final ClientePFServiceInterface clienteService;

    // Injeção de dependência via construtor
    public ClientePFController(ClientePFServiceInterface clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClientePFGetDTO>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePFGetDTO> getClienteById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientePFGetDTO> createCliente(@RequestBody @Valid PessoaCreateDTO createDTO) {
        return ResponseEntity.ok(clienteService.create(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePFGetDTO> updateCliente(@PathVariable long id, @RequestBody @Valid PessoaUpdateDTO updateDTO) {
        return ResponseEntity.ok(clienteService.update(id, updateDTO));
    }

    @PutMapping("/{id}/endereco")
    public ResponseEntity<ClientePFGetDTO> updateEndereco(@PathVariable long id, @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) {
        return ResponseEntity.ok(clienteService.updateAddress(id, enderecoCreateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable long id) {
        boolean deleted = clienteService.delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

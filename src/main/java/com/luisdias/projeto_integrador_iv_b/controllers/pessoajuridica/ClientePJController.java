package com.luisdias.projeto_integrador_iv_b.controllers.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.dtos.pessoajuridica.ClientePJGetDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.empresa.EmpresaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.dtos.pessoa.PessoaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Classe responsável por processar a entrada de dados, validar os dados recebidos e
// chamar o método adequado do Service
@RestController
@RequestMapping("/clientes/empresas")
public class ClientePJController {
    // Declaração da dependência da interface de serviço
    private final ClientePJService clienteService;

    // Injeção de dependência via construtor
    public ClientePJController(ClientePJService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClientePJGetDTO>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePJGetDTO> getClienteById(@PathVariable String id) {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientePJGetDTO> createCliente(@RequestBody @Valid EmpresaCreateDTO createDTO) {
        return ResponseEntity.ok(clienteService.create(createDTO));
    }

    @PutMapping("/{id}/endereco")
    public ResponseEntity<ClientePJGetDTO> updateEndereco(@PathVariable String id, @RequestBody @Valid EnderecoCreateDTO updateDTO) {
        return ResponseEntity.ok(clienteService.updateEndereco(id, updateDTO));
    }

    @PutMapping("/{id}/proprietario/endereco")
    public ResponseEntity<ClientePJGetDTO> updateEnderecoProprietario(@PathVariable String id, @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) {
        return ResponseEntity.ok(clienteService.updateEnderecoProprietario(id, enderecoCreateDTO));
    }

    @PutMapping("/{id}/proprietario")
    public ResponseEntity<ClientePJGetDTO> updateProprietario(@PathVariable String id, @RequestBody @Valid PessoaUpdateDTO updateDTO) {
        return ResponseEntity.ok(clienteService.updateDadosProprietario(id, updateDTO));
    }

    @PostMapping("/{id}/proprietario")
    public ResponseEntity<ClientePJGetDTO> newProprietario(@PathVariable String id, @RequestBody @Valid PessoaCreateDTO createDTO) {
        return ResponseEntity.ok(clienteService.newProprietario(id, createDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String id) {
        boolean deleted = clienteService.delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

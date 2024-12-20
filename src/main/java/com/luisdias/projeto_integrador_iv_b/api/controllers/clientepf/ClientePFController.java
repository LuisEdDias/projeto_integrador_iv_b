package com.luisdias.projeto_integrador_iv_b.api.controllers.clientepf;

import com.luisdias.projeto_integrador_iv_b.api.dtos.clientepf.ClientePFGetDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.endereco.EnderecoCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaCreateDTO;
import com.luisdias.projeto_integrador_iv_b.api.dtos.pessoa.PessoaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Classe responsável por processar a entrada de dados, validar os dados recebidos e
// chamar o método adequado do Service
@RestController
@RequestMapping("/api/clientes/pessoas")
public class ClientePFController {
    // Declaração da dependência da interface de serviço
    private final ClientePFService clienteService;

    // Injeção de dependência via construtor
    public ClientePFController(ClientePFService clienteService) {
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
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

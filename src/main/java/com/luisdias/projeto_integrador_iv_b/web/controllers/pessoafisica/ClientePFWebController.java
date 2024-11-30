package com.luisdias.projeto_integrador_iv_b.web.controllers.pessoafisica;

import com.luisdias.projeto_integrador_iv_b.web.dtos.ClientePfDTO;
import com.luisdias.projeto_integrador_iv_b.web.dtos.EnderecoDTO;
import com.luisdias.projeto_integrador_iv_b.web.dtos.PessoaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes/pessoas")
public class ClientePFWebController {
    // Declaração da dependência da interface de serviço
    private final ClientePFWebService clienteService;

    // Injeção de dependência via construtor
    public ClientePFWebController(ClientePFWebService clienteService) {
        this.clienteService = clienteService;
    }

    // Retorna a view 'index' para clientes pessoa física
    @GetMapping
    public String getAllClientes(Model model) {
        model.addAttribute("pessoas", clienteService.getAll());
        return "view/pessoa/index";
    }

    // Retorna a view 'pessoa' para clientes pessoa física
    @GetMapping("/{id}")
    public String getClienteById(@PathVariable long id, Model model) {
        model.addAttribute("pessoa", clienteService.getById(id));
        return "view/pessoa/pessoa";
    }

    // Retorna a view 'cadastro' para clientes pessoa física
    @GetMapping("/cadastro")
    public String cadastroView(){
        return "view/pessoa/cadastro";
    }

    // Recebe e processa os dados de criação de um cliente
    // retornando a view com o recurso criado
    @PostMapping
    public String createCliente(PessoaDTO pessoaDTO) {
        ClientePfDTO cliente = clienteService.create(pessoaDTO);
        return "redirect:/clientes/pessoas/" + cliente.clienteId();
    }

    // Recebe e processa os dados para atualizar um cliente
    // retornando a view com o recurso atualizado
    @PutMapping("/{id}")
    public String updateCliente(@PathVariable long id, PessoaDTO pessoaDTO) {
        clienteService.update(id, pessoaDTO);
        return "redirect:/clientes/pessoas/" + id;
    }

    // Recebe e processa os dados para atualizar o endereço de um cliente
    // retornando a view com o recurso atualizado
    @PutMapping("/{id}/endereco")
    public String updateEndereco(@PathVariable long id, EnderecoDTO enderecoDTO) {
        clienteService.updateAddress(id, enderecoDTO);
        return "redirect:/clientes/pessoas/" + id;
    }

    // Recebe o ID de um cliente à ser deletado do banco de dados, solicita a execução para
    // o serviço e retorna a view 'index'
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable long id) {
        clienteService.delete(id);
        return "redirect:/clientes/pessoas";
    }
}

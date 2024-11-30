package com.luisdias.projeto_integrador_iv_b.web.controllers.pessoajuridica;

import com.luisdias.projeto_integrador_iv_b.web.dtos.ClientePjDTO;
import com.luisdias.projeto_integrador_iv_b.web.dtos.EmpresaDTO;
import com.luisdias.projeto_integrador_iv_b.web.dtos.EnderecoDTO;
import com.luisdias.projeto_integrador_iv_b.web.dtos.PessoaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes/empresas")
public class ClientePJWebController {
    // Declaração da dependência da interface de serviço
    private final ClientePJWebService clienteService;

    // Injeção de dependência via construtor
    public ClientePJWebController(ClientePJWebService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getAllClientes(Model model) {
        model.addAttribute("empresas", clienteService.getAll());
        return "view/empresa/index";
    }

    @GetMapping("/{id}")
    public String getClienteById(@PathVariable String id, Model model) {
        model.addAttribute("empresa", clienteService.getById(id));
        return "view/empresa/empresa";
    }

    @GetMapping("/cadastro")
    public String createView(){
        return "view/empresa/cadastro";
    }

    @PostMapping
    public String createCliente(EmpresaDTO empresa) {
            ClientePjDTO cliente = clienteService.create(empresa);
        return "redirect:/clientes/empresas/" + cliente.clienteId();
    }

    @PutMapping("/{id}/proprietario")
    public String updateDadosProprietario(@PathVariable String id, PessoaDTO pessoa) {
        clienteService.updateDadosProprietario(id, pessoa);
        return "redirect:/clientes/empresas/" + id;
    }

    @PutMapping("/{id}/endereco")
    public String updateEndereco(@PathVariable String id, EnderecoDTO endereco) {
        clienteService.updateEndereco(id, endereco);
        return "redirect:/clientes/empresas/" + id;
    }

    @PutMapping("/{id}/proprietario/endereco")
    public String updateEnderecoProprietario(@PathVariable String id, EnderecoDTO endereco) {
        clienteService.updateEnderecoProprietario(id, endereco);
        return "redirect:/clientes/empresas/" + id;
    }

    @PostMapping("/{id}/proprietario")
    public String newProprietario(@PathVariable String id, PessoaDTO pessoa) {
        clienteService.newProprietario(id, pessoa);
        return "redirect:/clientes/empresas/" + id;
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable String id) {
        clienteService.delete(id);
        return "redirect:/clientes/empresas";
    }
}

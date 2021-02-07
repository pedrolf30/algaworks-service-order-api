package com.example.osworks.osworksapi.controller;

import com.example.osworks.osworksapi.model.Cliente;
import com.example.osworks.osworksapi.repository.ClienteRepository;
import com.example.osworks.osworksapi.service.CadastroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        Optional <Cliente> cliente =  clienteRepository.findById(clienteId);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        return cadastroClienteService.salvar(cliente);
    }

    @PutMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> atualizar (@Valid @PathVariable Long clienteId,
                                              @RequestBody Cliente cliente){

        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = cadastroClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cadastroClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }
}

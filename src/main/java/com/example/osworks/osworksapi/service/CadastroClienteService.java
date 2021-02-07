package com.example.osworks.osworksapi.service;

import com.example.osworks.osworksapi.exception.NegocioException;
import com.example.osworks.osworksapi.model.Cliente;
import com.example.osworks.osworksapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        if (clienteExistente != null && !clienteExistente.equals(cliente)){
            throw new NegocioException("Já existe um cliente cadastro com esse email.");
        }

        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}

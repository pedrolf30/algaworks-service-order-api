package com.example.osworks.osworksapi.service;

import com.example.osworks.osworksapi.exception.NegocioException;
import com.example.osworks.osworksapi.model.Cliente;
import com.example.osworks.osworksapi.model.OrdemServico;
import com.example.osworks.osworksapi.model.StatusOrdemServico;
import com.example.osworks.osworksapi.repository.ClienteRepository;
import com.example.osworks.osworksapi.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado!"));

        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }
}

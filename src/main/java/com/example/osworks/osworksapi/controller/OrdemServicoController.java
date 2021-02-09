package com.example.osworks.osworksapi.controller;

import com.example.osworks.osworksapi.model.OrdemServico;
import com.example.osworks.osworksapi.repository.OrdemServicoRepository;
import com.example.osworks.osworksapi.service.GestaoOrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico){
        return gestaoOrdemServicoService.criar(ordemServico);
    }

    @GetMapping
    public List<OrdemServico> listar(){
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemServicoId){
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if (ordemServico.isPresent()){
            return ResponseEntity.ok(ordemServico.get());
        }

        return ResponseEntity.notFound().build();
    }
}

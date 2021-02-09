package com.example.osworks.osworksapi.controller;

import com.example.osworks.osworksapi.model.OrdemServico;
import com.example.osworks.osworksapi.model.OrdemServicoInput;
import com.example.osworks.osworksapi.model.OrdemServicoRepresentationModel;
import com.example.osworks.osworksapi.repository.OrdemServicoRepository;
import com.example.osworks.osworksapi.service.GestaoOrdemServicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoRepresentationModel criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput){
        OrdemServico ordemServico = toEntity(ordemServicoInput);
        return toModel( gestaoOrdemServicoService.criar(ordemServico));
    }

    @GetMapping
    public List<OrdemServicoRepresentationModel> listar(){
        return toCollectionModel(ordemServicoRepository.findAll());
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoRepresentationModel> buscar(@PathVariable Long ordemServicoId){
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if (ordemServico.isPresent()){
            OrdemServicoRepresentationModel ordemServicoRepresentationModel = toModel(ordemServico.get());
            return ResponseEntity.ok(ordemServicoRepresentationModel);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{ordemServicoId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long ordemServicoId){
        gestaoOrdemServicoService.finalizar(ordemServicoId);
    }

    private OrdemServicoRepresentationModel toModel(OrdemServico ordemServico){
        return modelMapper
                .map(ordemServico, OrdemServicoRepresentationModel.class);
    }

    private List<OrdemServicoRepresentationModel> toCollectionModel(List<OrdemServico> ordensServico){
        return ordensServico.stream()
                .map(ordemServico -> toModel(ordemServico))
                .collect(Collectors.toList());
    }

    private OrdemServico toEntity(OrdemServicoInput ordemServicoInput){
        return modelMapper.map(ordemServicoInput, OrdemServico.class);
    }
}

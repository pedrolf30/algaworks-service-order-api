package com.example.osworks.osworksapi.controller;

import com.example.osworks.osworksapi.exception.EntidadeNaoEncontradaException;
import com.example.osworks.osworksapi.model.Comentario;
import com.example.osworks.osworksapi.model.ComentarioInput;
import com.example.osworks.osworksapi.model.ComentarioRepresentationModel;
import com.example.osworks.osworksapi.model.OrdemServico;
import com.example.osworks.osworksapi.repository.OrdemServicoRepository;
import com.example.osworks.osworksapi.service.GestaoOrdemServicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {


    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioRepresentationModel adicionar(@PathVariable Long ordemServicoId,
                                   @Valid @RequestBody ComentarioInput comentarioInput){

        Comentario comentario = gestaoOrdemServicoService.adicionarComentario(ordemServicoId,
                comentarioInput.getDescricao());

        return toModel(comentario);
    }

    @GetMapping
    public List<ComentarioRepresentationModel> listar(@PathVariable Long ordemServicoId){
        OrdemServico ordemServico =  ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));

        return toCollectionModel(ordemServico.getComentarios());
    }

    private ComentarioRepresentationModel toModel(Comentario comentario){
        return modelMapper.map(comentario, ComentarioRepresentationModel.class);
    }

    private List<ComentarioRepresentationModel> toCollectionModel(List<Comentario> comentarios){
        return comentarios.stream()
                .map(comentario -> toModel(comentario))
                .collect(Collectors.toList());
    }
}

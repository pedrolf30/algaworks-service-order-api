package com.example.osworks.osworksapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OrdemServicoRepresentationModel {

    private Long id;
    private String nomeCliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemServico status;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalização;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public OffsetDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(OffsetDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public OffsetDateTime getDataFinalização() {
        return dataFinalização;
    }

    public void setDataFinalização(OffsetDateTime dataFinalização) {
        this.dataFinalização = dataFinalização;
    }
}

package br.com.ufpb.phoesbus.ProjetoAyty.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @Valid
    @NotNull
    @ManyToOne
    private Cliente cliente;
    @Valid
    @Embedded
    @NotNull
    private Destinatario destinatario;
    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;
    @Valid
    @NotNull
    @OneToMany(mappedBy = "entrega")
    private List<Ocorrencia> ocorrencia;
    @NotNull
    private BigDecimal taxa;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPedido;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    public Ocorrencia adicionarOcorrencia(String descricao){
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);
        return ocorrencia;
    }
}

package br.com.ufpb.phoesbus.ProjetoAyty.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ocorrencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Entrega entrega;
    private String descricao;
    private OffsetDateTime dataRegistro;
}

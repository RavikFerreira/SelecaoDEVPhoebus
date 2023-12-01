package br.com.ufpb.phoesbus.ProjetoAyty.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
@Embeddable
@Data
public class Destinatario {
    @NotBlank
    @Column(name = "destinatario_nome")
    private String nome;
    @Column(name = "destinatario_logradouro")
    @NotBlank
    private String logradouro;
    @Column(name = "destinatario_numero")
    @NotBlank
    private String numero;
    @Column(name = "destinatario_complemento")
    @NotBlank
    private String complemento;
    @Column(name = "destinatario_bairro")
    @NotBlank
    private String bairro;
}

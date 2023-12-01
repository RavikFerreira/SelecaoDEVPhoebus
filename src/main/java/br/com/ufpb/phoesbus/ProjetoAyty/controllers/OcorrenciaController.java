package br.com.ufpb.phoesbus.ProjetoAyty.controllers;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Entrega;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.Ocorrencia;
import br.com.ufpb.phoesbus.ProjetoAyty.services.EntregaService;
import br.com.ufpb.phoesbus.ProjetoAyty.services.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;
    private EntregaService entregaService;
    @GetMapping("/listarOcorrencias/{id}")
    private List<Ocorrencia> listarOcorrencias(@PathVariable Long id){
        Entrega entrega = entregaService.buscar(id);
        return entrega.getOcorrencia();
    }
    @PostMapping("/regitrarOcorrencia/{id}")
    private Ocorrencia registrar( @PathVariable Long id,@Valid @RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.registrar(id, ocorrencia.getDescricao());
    }
}
